package ua.hildi.petclinicv2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.hildi.petclinicv2.model.Message;
import ua.hildi.petclinicv2.repository.MessageRepository;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public String list(Model model) {
        Collection<Message> messages = this.messageRepository.findAll();
        model.addAttribute("messages", messages);

        return "messages/messageList";
    }

    @RequestMapping("{id}")
    public ModelAndView view(@PathVariable("id") Message message) {
        return new ModelAndView("messages/messageView", "message", message);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Message message) {
        return "messages/messageForm";
    }

    @PostMapping
    public ModelAndView create(@Valid Message message, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("messages/messageForm", "formErrors", result.getAllErrors());
        }
        message = this.messageRepository.save(message);
        redirect.addFlashAttribute("statusMessage", "Successfully created a new message");
        return new ModelAndView("redirect:/messages/{message.id}", "message.id", message.getId());
    }

    @RequestMapping("foo")
    public String foo() {
        throw new RuntimeException("Expected exception in controller");
    }
}
