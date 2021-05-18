package home.spring.rest.web.service;

import home.spring.rest.web.dao.UserDAO;
import home.spring.rest.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public UserDetailServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        User user = userDAO.getByFirstName(firstName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
