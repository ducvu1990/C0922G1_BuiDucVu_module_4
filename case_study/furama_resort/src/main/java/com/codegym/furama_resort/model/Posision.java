package com.codegym.furama_resort.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Set;

@Entity
public class Posision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    @Max(value = 45)
    private String name;
    @OneToMany(mappedBy = "posision")
    private Set<Employee> employees;

    public Posision() {
    }

    public Posision(int id, String name, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}