package ua.hildi.petclinicv2.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.dto.OwnerDto;
import ua.hildi.petclinicv2.model.dto.PetDto;
import ua.hildi.petclinicv2.model.dto.PetTypeDto;
import ua.hildi.petclinicv2.services.OwnerService;
import ua.hildi.petclinicv2.services.PetService;
import ua.hildi.petclinicv2.services.PetTypeService;
import ua.hildi.petclinicv2.util.Mapper;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Stream;

@Controller
@RequestMapping("/owners/{ownerId}")
@Slf4j
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetTypeDto> populatePetTypes() {
        log.info("Try to return Pet types ...");
        Mapper mapper = new Mapper();
        return petTypeService.findAll()
                .stream()
                .map(mapper::toPetTypesDto)
                .toList();
    }

    @ModelAttribute("owner")
    public OwnerDto findOwner(@PathVariable("ownerId") @Min(5) Long ownerId) {
        log.info("Try to find owner by id ...");
        Mapper mapper = new Mapper();
        return Stream.of(ownerService.findById(ownerId))
                .map(mapper::toOwnerDto)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(OwnerDto ownerDto, Model model) {
        Mapper mapper = new Mapper();
        Owner owner = mapper.toOwner(ownerDto);
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        log.info("Try to save owner ...");
        ownerService.save(owner);
        log.info("... success");
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(OwnerDto ownerDto, PetDto petDto, BindingResult result, ModelMap model) {
        Mapper mapper = new Mapper();
        Pet pet = mapper.toPet(petDto);
        Owner owner = mapper.toOwner(ownerDto);

        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPets() != null) {
            log.error("Duplicate: name is already exists");
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            log.info("Pet is successfully saved");
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable @Min(5) Long petId, Model model) {
        log.info("Try to find pet by id ...");
        model.addAttribute("pet", petService.findById(petId));
        log.info("... success");
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(PetDto petDto, BindingResult result, @NotNull OwnerDto ownerDto, Model model) {
        Mapper mapper = new Mapper();
        Owner owner = mapper.toOwner(ownerDto);
        Pet pet = mapper.toPet(petDto);

        log.info("Try to update pet by id ...");

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
