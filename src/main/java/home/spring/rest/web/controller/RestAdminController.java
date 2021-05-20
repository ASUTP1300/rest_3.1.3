package home.spring.rest.web.controller;


import home.spring.rest.web.DTO.UserDto;
import home.spring.rest.web.model.Role;
import home.spring.rest.web.model.User;
import home.spring.rest.web.repository.RoleRepository;
import home.spring.rest.web.service.RoleServiceImp;
import home.spring.rest.web.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestAdminController {

    private UserService userService;

    private RoleServiceImp roleService;

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleService(RoleServiceImp roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> allRoles() {
        return ResponseEntity.ok().body(roleRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable("id") long id, Model model) {
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@RequestBody UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userDto, User.class);
        if (userDto.getRoles() != null) {
            user.setRoles(roleService.getRoles(userDto));
        } else {
            Role DefaultRole = roleRepository.findRoleById(2L);
            user.setRoles(Collections.singleton(DefaultRole));
        }
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editWithLocation(@RequestBody UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userDto, User.class);
        user.setRoles(roleService.getRoles(userDto));
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteWithLocation(@RequestBody UserDto userDto) {
        userService.remove(userDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    Здесь была аннотация @ResponseBody -- в этом месте данная она не нужна, так как @RestController
    уже  подтягивает эту аннотацию на методы
     */
    @GetMapping("/getOne")
    public ResponseEntity<User> getOne(long id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @GetMapping("/auth")
    public ResponseEntity<User> auth(Principal principal) {
        return ResponseEntity.ok().body(userService.getByFirstName(principal.getName()));
    }
}
