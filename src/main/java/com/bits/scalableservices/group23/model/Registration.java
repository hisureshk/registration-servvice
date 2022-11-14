package com.bits.scalableservices.group23.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
public class Registration {

    private @Id @GeneratedValue Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate registrationDate;
    private String userName;
    private String password;
    private String fullName;
    private String status = "Registered";
    private String registrationType;
    private String phoneNum;


    public Registration() {

    }

    public Registration(Timestamp createdAt, LocalDate registrationDate, String userName, String password, String fullName, String status, String phoneNum, String registrationType) {
        this.createdAt = createdAt;
        this.registrationDate = registrationDate;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
        this.phoneNum = phoneNum;
        this.registrationType = registrationType;
    }

    public Registration(LocalDate registrationDate, String userName, String password, String fullName, String phoneNum, String registrationType) {
        this.registrationDate = registrationDate;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.registrationType = registrationType;
    }

    public Registration(LocalDate registrationDate, String fullName, String phoneNum) {
        this.registrationDate = registrationDate;
        this.fullName = fullName;
        this.phoneNum = phoneNum;
    }

}