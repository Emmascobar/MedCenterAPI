package com.emmanuelescobar.medcenterapi.model.utils;

import com.emmanuelescobar.medcenterapi.model.users.Patient;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
public class Insurance {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer pharmacyCoverage;
    private Integer attentionCoverage;
    private Integer complementaryCoverage;
    @OneToMany(mappedBy = "insurance")
    private List<Patient> patients;

    public Insurance() {
    }

    public Insurance(String name, Integer pharmacyCoverage, Integer attentionCoverage, Integer complementaryCoverage) {
        this.name = name;
        this.pharmacyCoverage = pharmacyCoverage;
        this.attentionCoverage = attentionCoverage;
        this.complementaryCoverage = complementaryCoverage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPharmacyCoverage() {
        return pharmacyCoverage;
    }

    public void setPharmacyCoverage(Integer pharmacyCoverage) {
        this.pharmacyCoverage = pharmacyCoverage;
    }

    public Integer getAttentionCoverage() {
        return attentionCoverage;
    }

    public void setAttentionCoverage(Integer attentionCoverage) {
        this.attentionCoverage = attentionCoverage;
    }

    public Integer getComplementaryCoverage() {
        return complementaryCoverage;
    }

    public void setComplementaryCoverage(Integer complementaryCoverage) {
        this.complementaryCoverage = complementaryCoverage;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
