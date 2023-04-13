package com.MyCrudApp.app.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
@Entity
public class Role implements GrantedAuthority {

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    @Id
    private long role_id;

    private String role;

    public Role() {

    }

    @Override
    public String getAuthority() {
        return role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
