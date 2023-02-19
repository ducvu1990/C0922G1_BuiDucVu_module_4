package com.codegym.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(name = "userName", length = 255, nullable = false)
    private String userName;
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;
    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    public User() {
    }

    public User(String userName, String password, Employee employee, Set<UserRole> userRoles) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
        this.userRoles = userRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
