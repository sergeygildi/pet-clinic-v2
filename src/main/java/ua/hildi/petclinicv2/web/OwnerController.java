package ua.hildi.petclinicv2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.service.ClinicService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@SessionAttributes(types = Owner.class)
@RequestMapping(value = "/owners")
public class OwnerController {

    private final ClinicService clinicService;

    @Autowired
    public OwnerController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/new")
    public String initCreationForm(Model model) {
        Owner owner = new Owner();
        model.addAttribute(owner);
        return "owners/ownerForm";
    }

    @PostMapping(value = "/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "owners/ownerForm";
        } else {
            this.clinicService.saveOwner(owner);
            status.setComplete();
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping(value = "/find")
    public String initFindForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping
    public ModelAndView showOwners(Model model) {
        return new ModelAndView("redirect:/owners/list.html", model.asMap());
    }

    @GetMapping(value = "/list")
    public String processFindForm(Owner owner, BindingResult result, Model model, HttpSession session) {
        Collection<Owner> results = null;

        // find owners by last name
        if (StringUtils.isEmpty(owner.getLastName())) {
            // allow parameterless GET request for /owners to return all records
            results = this.clinicService.findOwners();
        } else {
            results = this.clinicService.findOwnerByLastName(owner.getLastName());
        }

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", new Object[]{owner.getLastName()}, "not found");
            return "owners/findOwners";
        }

        session.setAttribute("searchLastName", owner.getLastName());

        if (results.size() > 1) {
            // multiple owners found
            model.addAttribute("owners", results);
            return "owners/ownersList";
        } else {
            // 1 owner found
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping(value = "/{ownerId}/edit")
    public String initUpdateOwner(@PathVariable("ownerId") int ownerId, Model model) {
        Owner owner = this.clinicService.findOwnerById(ownerId);
        model.addAttribute(owner);
        return "owners/ownerForm";
    }

    @PostMapping(value = "/{ownerId}/edit")
    public String processUpdateOwner(@Valid Owner owner, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "owners/ownerForm";
        } else {
            this.clinicService.saveOwner(owner);
            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }

    @RequestMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.clinicService.findOwnerById(ownerId));
        return mav;
    }
}
