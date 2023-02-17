package com.codegym.security.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private boolean enabled;
    @OneToMany(mappedBy = "User")
    private Set<UserRole> userRole;

    public User() {
    }

    public User(int id, String userName, boolean enabled, Set<UserRole> userRole) {
        this.id = id;
        this.userName = userName;
        this.enabled = enabled;
        this.userRole = userRole;
    }
}
