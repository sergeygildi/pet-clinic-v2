package ua.hildi.petclinicv2.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.dto.OwnerDto;
import ua.hildi.petclinicv2.services.OwnerService;
import ua.hildi.petclinicv2.util.Mapper;

import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping("/owners")
@Controller
@Slf4j
public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        log.info("Try to set Disallowed Fields ('id')");
        dataBinder.setDisallowedFields("id");
        log.info("Disallowed Fields set");
    }

    @GetMapping("/find")
    public String findOwners(Model model) {
        log.info("Redirect to page: 'owners/findOwners'");
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(OwnerDto ownerDto, BindingResult result, Model model) {
        log.info("Process find form ...");
        Mapper mapper = new Mapper();
        Owner owner = mapper.toOwner(ownerDto);
        if (owner.getLastName() == null) {
            log.info("owner last name is empty");
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()) {
            log.error("Cannot find this owner by input last name");
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            owner = results.get(0);
            log.info("Owner found. Return owner");
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable @Min(5) Long ownerId) {
        log.info("Try to get owner page by ID ...");
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        log.info("Owner page is successfully added");
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        log.info("initCreationForm ...");
        model.addAttribute("owner", new Owner());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(OwnerDto ownerDto, BindingResult result) {
        Mapper mapper = new Mapper();
        Owner owner = mapper.toOwner(ownerDto);
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable @Min(5) Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        log.info("Owner is successfully updated");
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(OwnerDto ownerDto, BindingResult result, @PathVariable @Min(5) Long ownerId) {
        Mapper mapper = new Mapper();
        Owner owner = mapper.toOwner(ownerDto);

        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

}