package com.MyCrudApp.app.repository;

import com.MyCrudApp.app.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String username);
}
