package home.spring.rest.web.controller;

import home.spring.rest.web.model.User;
import home.spring.rest.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user2", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestUserController {

    private UserService userService;

    @Autowired
    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public  User user(Principal principal) {
        return userService.getByFirstName(principal.getName());
    }
}
