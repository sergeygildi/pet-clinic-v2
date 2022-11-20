package ua.hildi.petclinicv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.hildi.petclinicv2.model.dto.Mapper;
import ua.hildi.petclinicv2.model.dto.VetDto;
import ua.hildi.petclinicv2.services.VetService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class VetController {

    private final VetService vetService;
    private final Mapper mapper;

    public VetController(VetService vetService, Mapper mapper) {
        this.vetService = vetService;
        this.mapper = mapper;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody List<VetDto> getVetsJson() {
        return vetService.findAll().stream().map(mapper::toVet).collect(toList());
    }
}
