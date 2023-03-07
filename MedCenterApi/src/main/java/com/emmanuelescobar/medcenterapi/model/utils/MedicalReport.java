package com.emmanuelescobar.medcenterapi.model.utils;

import com.emmanuelescobar.medcenterapi.model.users.Doctor;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
public class MedicalReport {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private final LocalDate CREATION_DATE = LocalDate.now();
    private String report;
    public MedicalReport() {
    }
    public MedicalReport(Doctor doctor, Patient patient, String report) {
        this.doctor = doctor;
        this.patient = patient;
        this.report = report;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
