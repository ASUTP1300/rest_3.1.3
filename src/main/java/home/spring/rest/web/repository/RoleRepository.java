package home.spring.rest.web.repository;

import home.spring.rest.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {

    Role findByRole(String roleName);

    Role findRoleById(Long id);
}
