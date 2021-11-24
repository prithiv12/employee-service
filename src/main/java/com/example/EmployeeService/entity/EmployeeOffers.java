package com.example.EmployeeService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Offer")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeOffers {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message="Offer Name is mandatory")
    private String name;

    @NotNull(message="Offer description is mandatory")
    private String description;

    @NotNull(message="Offer category is mandatory")
    private String category;

    @Column(name="open_date")
    private Date openDate;

    @Column(name="engaged_date")
    private Date engagedDate;

    @Column(name="closed_date")
    private Date closedDate;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_id")
    private Employee employee;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="engaged_emp_id")
    private Employee engagedEmployee;

    @JsonIgnore
    @ManyToMany(mappedBy = "likedOffers", fetch = FetchType.LAZY)
    private Set<Employee> likedByEmployees = new HashSet<>();
    
    @NotNull
    @Min(0)
    private Integer likes;

    


}
