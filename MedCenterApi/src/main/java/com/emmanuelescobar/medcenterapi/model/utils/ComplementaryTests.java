package com.emmanuelescobar.medcenterapi.model.utils;

import com.emmanuelescobar.medcenterapi.model.users.Doctor;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ComplementaryTests {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDate CREATION_DATE = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "patient")
    @NotEmpty(message = "Patient can't be empty")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor")
    @NotEmpty(message = "Doctor can't be empty")
    private Doctor doctor;
    @NotEmpty
    private String type;
    @NotEmpty
    private LocalDate appointmentDate;
    private BigDecimal totalPrice;
    public ComplementaryTests() {
    }
    public ComplementaryTests(Patient patient, Doctor doctor, String type, LocalDate appointmentDate, BigDecimal totalPrice) {
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
        this.appointmentDate = appointmentDate;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCREATION_DATE() {
        return CREATION_DATE;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
