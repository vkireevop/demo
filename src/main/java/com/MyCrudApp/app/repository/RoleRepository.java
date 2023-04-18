package com.MyCrudApp.app.repository;

import com.MyCrudApp.app.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,Long> {
    List<Role> findAll();
}
