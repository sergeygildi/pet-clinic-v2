package ua.hildi.petclinicv2.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.hildi.petclinicv2.model.dto.VetDto;
import ua.hildi.petclinicv2.services.VetService;
import ua.hildi.petclinicv2.util.DTOConverter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@Slf4j
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {
        log.info("Try to return vets index page ...");
        model.addAttribute("vets", vetService.findAll());
        log.info("... success");
        return "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody List<VetDto> getVetsJson() {
        log.info("Try to return all Vets ...");
        DTOConverter DTOConverter = new DTOConverter();
        List<VetDto> collect = vetService.findAll().stream().map(DTOConverter::toVet).collect(toList());
        log.info("... success");
        return collect;
    }
}
