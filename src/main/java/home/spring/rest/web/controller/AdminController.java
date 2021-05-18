package home.spring.rest.web.controller;

import home.spring.rest.web.repository.RoleRepository;
import home.spring.rest.web.service.RoleServiceImp;
import home.spring.rest.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    private RoleServiceImp roleService;

    private RoleRepository roleRepository;


    @GetMapping()
    public String example() {
        return "admin/index";
    }
}