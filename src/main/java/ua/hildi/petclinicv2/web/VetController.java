package ua.hildi.petclinicv2.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.hildi.petclinicv2.model.Vets;
import ua.hildi.petclinicv2.service.ClinicService;

@Controller
@RequestMapping("/vets")
@Slf4j
public class VetController {

    private final ClinicService clinicService;

    @Autowired
    public VetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public ModelAndView showVets(Model model) {
        return new ModelAndView("redirect:/vets/list.html", model.asMap());
    }

    @GetMapping(value = "/list")
    public String showVetList(Model model) {
        // Here we are returning an object of type 'Vets' rather than a
        // collection of Vet objects so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        model.addAttribute("vets", vets);

        log.info("In showVetList: " + model);

        return "vets/vetList";
    }
}
