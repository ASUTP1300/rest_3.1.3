package home.spring.rest.web.dao;

import home.spring.rest.web.model.User;

import java.util.List;

public interface UserDAO {

    void add(User user);

    void update(User user);

    void remove(long id);

    User getById( long id);

    List<User> listUsers();

    User getByFirstName( String firstname);
}
