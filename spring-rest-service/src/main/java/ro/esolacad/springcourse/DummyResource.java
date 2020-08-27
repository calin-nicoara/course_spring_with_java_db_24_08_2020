package ro.esolacad.springcourse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/dummy")
@CrossOrigin("http://localhost:4200")
public class DummyResource {

    @GetMapping("/open")
    public String open() {
        return "I am open to everyone!";
    }

    @GetMapping("/closed")
    public String closed(Principal principal) {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Object principal = context.getAuthentication().getPrincipal();

        return "Open only for customer! " + principal;
    }
}
