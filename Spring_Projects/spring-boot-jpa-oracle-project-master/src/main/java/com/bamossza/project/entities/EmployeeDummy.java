package com.bamossza.project.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "employeesdummy123")
public class EmployeeDummy {





    //annotations
    @Id
    @Column(name="employeedummyId123", unique=true, nullable=false, precision=10, scale=0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;

    @Column(name = "first_Name_Dummy_123", nullable = false)
    @Getter
    @Setter
    private String firstName;


    @Getter
    @Setter
    private String lastName;

    @Column(name = "emailIddummy123", nullable = false)
    @Getter
    @Setter
    private String emailId;

    @Column(name = "educationdummy123", nullable = false)
    @Getter
    @Setter
    private String education;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    public EmployeeDummy() {

    }

    public EmployeeDummy(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }*/

}