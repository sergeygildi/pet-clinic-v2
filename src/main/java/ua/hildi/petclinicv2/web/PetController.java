package ua.hildi.petclinicv2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.PetType;
import ua.hildi.petclinicv2.service.ClinicService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@SessionAttributes("pet")
public class PetController {

    private final ClinicService clinicService;

    @Autowired
    public PetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.clinicService.findPetTypes();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/owners/{ownerId}/pets/new")
    public String initCreationForm(@PathVariable("ownerId") int ownerId, Model model) {
        Owner owner = this.clinicService.findOwnerById(ownerId);
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("pet", pet);
        return "pets/petForm";
    }

    @PostMapping(value = "/owners/{ownerId}/pets/new")
    public String processCreationForm(@Valid Pet pet, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "pets/petForm";
        } else {
            this.clinicService.savePet(pet);
            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping(value = "/owners/*/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("petId") int petId, Model model) {
        Pet pet = this.clinicService.findPetById(petId);
        model.addAttribute("pet", pet);
        return "pets/petForm";
    }

    @PostMapping(value = "/owners/{ownerId}/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "pets/petForm";
        } else {
            this.clinicService.savePet(pet);
            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }

}
