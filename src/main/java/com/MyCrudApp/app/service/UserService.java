package com.MyCrudApp.app.service;

import com.MyCrudApp.app.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findById(long id);

    void update (long id,User userUpdated);

    void delete (long id);

    List<User> getAllUsers();
}
