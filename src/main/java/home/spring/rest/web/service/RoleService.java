package home.spring.rest.web.service;


import home.spring.rest.web.DTO.UserDto;
import home.spring.rest.web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    public Set<Role> getRoleByName(List<String> listStringRoles);

    public List<String> getNamesRole(List<Role> listRoles);

    public Set<Role> getRoles(UserDto userDto);
}
