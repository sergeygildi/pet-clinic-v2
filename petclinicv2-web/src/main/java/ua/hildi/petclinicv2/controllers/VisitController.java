package ua.hildi.petclinicv2.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.Visit;
import ua.hildi.petclinicv2.model.dto.VisitDto;
import ua.hildi.petclinicv2.util.Mapper;
import ua.hildi.petclinicv2.services.PetService;
import ua.hildi.petclinicv2.services.VisitService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
@Slf4j
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        log.info("setDisallowedFields: id");
        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("visit")
    public VisitDto loadPetWithVisit(@PathVariable("petId") @Min(5) Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        log.info("Try to create visit ...");
        Visit visit = Visit.builder()
                .date(LocalDate.now())
                .pet(pet)
                .build();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        Mapper mapper = new Mapper();
        return mapper.toVisitDto(visit);
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") @Min(5) Long petId, Map<String, Object> model) {
        log.info("Init new visit form ...");
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(VisitDto visitDto, BindingResult result) {
        Mapper mapper = new Mapper();
        Visit visit = mapper.toVisit(visitDto);
        log.info("Try to create visit ...");
        if (result.hasErrors()) {
            log.error("Can't create new visit. {}", result.getFieldError());
            return "pets/createOrUpdateVisitForm";
        } else {
            log.info("...success");
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
