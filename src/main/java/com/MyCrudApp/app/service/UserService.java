package com.MyCrudApp.app.service;

import com.MyCrudApp.app.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);
    public UserDetails loadUserByUsername(String username);
    User findByUsername(String username);

    User findById(long id);

    void update (long id,User userUpdated);

    void delete (long id);

    List<User> getAllUsers();
}
