package com.bamossza.project.entities;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonDetails implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(PersonDetails.class);
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="pan")
    private int panCard;

    private int aadhar;
    private String firstName;
    private String middelName;
    private String lastName;
    private String email;
    private String address;
    private int houseNo;
    private int pincode;
    private String city;
    private String state;

    public PersonDetails() {
    }

    public PersonDetails(int panCard, int aadhar, String firstName, String middelName, String lastName, String email, String address, int houseNo, int pincode, String city, String state) {
        this.panCard = panCard;
        this.aadhar = aadhar;
        this.firstName = firstName;
        this.middelName = middelName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.houseNo = houseNo;
        this.pincode = pincode;
        this.city = city;
        this.state = state;

    }
}
