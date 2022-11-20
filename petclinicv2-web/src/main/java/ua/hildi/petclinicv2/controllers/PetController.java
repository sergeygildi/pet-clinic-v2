package ua.hildi.petclinicv2.controllers;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.dto.*;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.services.OwnerService;
import ua.hildi.petclinicv2.services.PetService;
import ua.hildi.petclinicv2.services.PetTypeService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final Mapper mapper;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService, Mapper mapper) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.mapper = mapper;
    }

    @ModelAttribute("types")
    public Collection<PetTypeDto> populatePetTypes() {
        return petTypeService.findAll()
                .stream()
                .map(mapper::toPetTypesDto)
                .collect(toList());
    }

    @ModelAttribute("owner")
    public OwnerDto findOwner(@PathVariable("ownerDtoId") Long ownerDtoId) {
        return Stream.of(ownerService.findById(ownerDtoId))
                .map(mapper::toOwnerDto)
                .findFirst()
                .get();
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(OwnerCreationDto ownerDto, Model model) {
        Owner owner = mapper.toOwner(ownerDto);
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(OwnerDto ownerDto, @Valid PetDto petDto, BindingResult result, ModelMap model) {
        Pet pet = mapper.toPet(petDto);
        Owner owner = mapper.toOwner(ownerDto);

        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid PetDto petDto, BindingResult result, OwnerDto ownerDto, Model model) {
        Pet pet = mapper.toPet(petDto);
        Owner owner = mapper.toOwner(ownerDto);

        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

}
