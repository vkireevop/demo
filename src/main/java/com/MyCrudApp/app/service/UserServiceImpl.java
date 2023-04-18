package com.MyCrudApp.app.service;

import com.MyCrudApp.app.models.User;
import com.MyCrudApp.app.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository rep) {
        this.userRepository = rep;
    }

    @Transactional
    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void update (long id,User userUpdated) {
        User user = findById(id);
        user.setName(userUpdated.getName());
    }

    @Override
    public User findByUsername (String username) {
        return userRepository.findByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username);
    }

    @Transactional
    @Override
    public void delete (long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
