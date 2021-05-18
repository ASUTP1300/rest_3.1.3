package home.spring.rest.web.repository;

import home.spring.rest.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstName(String firstname);

    User findUserById(Long id);

    User findUserByEmail(String email);
}
