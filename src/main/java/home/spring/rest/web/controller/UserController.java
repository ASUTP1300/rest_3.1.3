package home.spring.rest.web.controller;

import home.spring.rest.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


        @GetMapping("/user")
        public String showResults() {
            return "user/getById";
        }
}
