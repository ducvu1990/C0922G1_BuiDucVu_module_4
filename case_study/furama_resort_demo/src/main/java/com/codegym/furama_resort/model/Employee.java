package com.codegym.furama_resort.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "idCard")
    private String idCard;
    @Column(name = "salary")
    private double salary;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "posisionId", referencedColumnName = "id", nullable = false)
    private Posision posision;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division", nullable = false)
    private Division division;
}
