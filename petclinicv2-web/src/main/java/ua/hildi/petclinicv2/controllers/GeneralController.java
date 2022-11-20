package ua.hildi.petclinicv2.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@ControllerAdvice
@Slf4j
public class GeneralController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/router")
    public String accessDeniedRouter(@RequestParam("q") String resource) {
        log.debug("In accessDeniedRouter resource = " + resource);

        return "redirect:/" + resource;
    }

    @RequestMapping("/unauthorized")
    public ModelAndView accessDenied() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("timestamp", new Date());
        mav.setViewName("unauthorized");
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest req, Exception e) {
        log.warn("In handleException", e);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("timestamp", new Date());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("exception");
        return mav;
    }

    @GetMapping("/oups")
    public String triggerException() {
        return "notimplemented";
    }
}
