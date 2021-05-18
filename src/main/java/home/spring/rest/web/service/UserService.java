package home.spring.rest.web.service;

import home.spring.rest.web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void update(User user);

    void remove(long id);

    User getById( long id);

    User getByFirstName(String firstname);

    List<User> listUsers();

    public User save(User user);
}
