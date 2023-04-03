package com.MyCrudApp.app.service;

import com.MyCrudApp.app.models.User;
import com.MyCrudApp.app.repository.UserRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository rep;

    public UserServiceImpl(UserRepository rep) {
        this.rep = rep;
    }

    @Transactional
    @Override
    public void save(User user){
        rep.save(user);
    }

    @Override
    public User findById(long id) {
        return rep.findById(id).get();
    }

    @Transactional
    @Override
    public void update (long id,User userUpdated) {
        User user = findById(id);
        user.setName(userUpdated.getName());
    }

    @Transactional
    @Override
    public void delete (long id) {
        rep.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> Users = new ArrayList<>();
        for (User user  : rep.findAll()) {
            Users.add(user);
        }
        return Users;
    }
}
