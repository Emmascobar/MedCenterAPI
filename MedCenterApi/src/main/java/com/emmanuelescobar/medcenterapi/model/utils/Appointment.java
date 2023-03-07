package com.emmanuelescobar.medcenterapi.model.utils;

import com.emmanuelescobar.medcenterapi.model.users.Doctor;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty
    private final LocalDate CREATION_DATE = LocalDate.now();
    @NotEmpty
    private LocalDate appointmentDate;
    @ManyToOne
    @NotEmpty(message = "Patient can't be empty")
    private Patient patient;
    @OneToOne
    @NotEmpty(message = "Doctor can't be empty")
    private Doctor doctor;
    public Appointment() {
    }

    public Appointment(LocalDate appointmentDate, Patient patient, Doctor doctor) {
        this.appointmentDate = appointmentDate;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
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
}
