package com.MyCrudApp.app.repository;

import com.MyCrudApp.app.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT u from  User u join fetch u.roles where u    .name = :username")
    User findByName(@Param("username") String username);
    List<User> findAll();
}
