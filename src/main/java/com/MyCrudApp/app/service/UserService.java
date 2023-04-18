package com.MyCrudApp.app.service;

import com.MyCrudApp.app.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User findById(long id);

    void update (long id,User userUpdated);

    void delete (long id);

    List<User> getAllUsers();
}
