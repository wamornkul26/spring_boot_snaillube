package com.demo.snaillube.appointments;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private LocalDate appointmentDate; 
    private Integer timeslot;
    
    public Appointment() {
    }

    public Appointment(Long id, String name, String phoneNumber, String email, LocalDate appointmentDate, Integer timeslot) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.appointmentDate = appointmentDate;
        this.timeslot = timeslot;
    }

    public Appointment(String name, String phoneNumber, String email, LocalDate appointmentDate, Integer timeslot) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.appointmentDate = appointmentDate;
        this.timeslot = timeslot;   
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAppointmenDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getTimeslot() {
        return timeslot;
    }
    // We might need to check if the date time is appropriate.  After 9am and before 6pm
    public void setTimelot(Integer timeslot) {
        this.timeslot = timeslot;
    }
}
