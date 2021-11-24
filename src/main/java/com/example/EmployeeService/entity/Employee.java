package com.example.EmployeeService.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message="Employee Name is mandatory")
    private String eName;
    
    //@NotNull
    private String eDepartment;
    
    @NotNull(message="Employee gender is mandatory")
    private String gender;

    @NotNull(message="Employee age is mandatory")
    @Min(21)
    @Max(60)
    private Integer age;

    @Column(name="contact_number")
    private Long phoneNumber;

    private String email;

    @Column(name="points_gained")
    private Integer pointsGained;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EmployeeOffers> offers;

    @OneToMany(mappedBy = "engagedEmployee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EmployeeOffers> engagedInOffers;

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinTable(name="liked_by",
            joinColumns = {
                    @JoinColumn(name="emp_id",referencedColumnName="id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="offer_id",referencedColumnName="id")
            })
    private Set<EmployeeOffers> likedOffers = new HashSet<>();

    

}
