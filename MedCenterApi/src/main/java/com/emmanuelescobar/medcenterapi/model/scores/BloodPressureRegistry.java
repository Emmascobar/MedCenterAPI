package com.emmanuelescobar.medcenterapi.model.scores;

import com.emmanuelescobar.medcenterapi.model.users.Patient;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
public class BloodPressureRegistry {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dateOfRegistry;
    private double averagePAS;
    private double averagePAD;
    private Comorbility comorbility;
    private String classification;
    private String suggestedTreatment;
    @ManyToMany
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public BloodPressureRegistry() {
    }

    public BloodPressureRegistry(LocalDate dateOfRegistry, double averagePAS, double averagePAD, Comorbility comorbility, String classification, String suggestedTreatment) {
        this.dateOfRegistry = dateOfRegistry;
        this.averagePAS = averagePAS;
        this.averagePAD = averagePAD;
        this.comorbility = comorbility;
        this.classification = classification;
        this.suggestedTreatment = suggestedTreatment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfRegistry() {
        return dateOfRegistry;
    }

    public void setDateOfRegistry(LocalDate dateOfRegistry) {
        this.dateOfRegistry = dateOfRegistry;
    }

    public double getAveragePAS() {
        return averagePAS;
    }

    public void setAveragePAS(double averagePAS) {
        this.averagePAS = averagePAS;
    }

    public double getAveragePAD() {
        return averagePAD;
    }

    public void setAveragePAD(double averagePAD) {
        this.averagePAD = averagePAD;
    }

    public Comorbility getComorbility() {
        return comorbility;
    }

    public void setComorbility(Comorbility comorbility) {
        this.comorbility = comorbility;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSuggestedTreatment() {
        return suggestedTreatment;
    }

    public void setSuggestedTreatment(String suggestedTreatment) {
        this.suggestedTreatment = suggestedTreatment;
    }
}
