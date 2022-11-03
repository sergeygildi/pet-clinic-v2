package ua.hildi.petclinicv2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.Visit;
import ua.hildi.petclinicv2.service.ClinicService;

import javax.validation.Valid;

@Controller
@SessionAttributes("visit")
public class VisitController {

    private final ClinicService clinicService;

    @Autowired
    public VisitController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") int petId, Model model) {
        Pet pet = this.clinicService.findPetById(petId);
        Visit visit = new Visit();
        pet.addVisit(visit);
        model.addAttribute("visit", visit);
        return "pets/visitForm";
    }

    @PostMapping(value = "/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "pets/visitForm";
        } else {
            this.clinicService.saveVisit(visit);
            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping(value = "/owners/*/pets/{petId}/visits")
    public ModelAndView showVisits(@PathVariable int petId) {
        ModelAndView mav = new ModelAndView("visitList");
        mav.addObject("visits", this.clinicService.findPetById(petId).getVisits());
        return mav;
    }

}
