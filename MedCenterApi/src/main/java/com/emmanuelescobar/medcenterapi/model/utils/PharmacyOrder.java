package com.emmanuelescobar.medcenterapi.model.utils;

import com.emmanuelescobar.medcenterapi.model.users.Doctor;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PharmacyOrder {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDate DATE = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "pacient")
    @NotEmpty(message = "Pacient can't be empty")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor")
    @NotEmpty(message = "Doctor can't be empty")
    private Doctor doctor;
    private List<Drug> drugs;
    private BigDecimal dosage;
    private Integer DaysOfTreatment;
    private BigDecimal totalPrice;

    public PharmacyOrder() {
    }

    public PharmacyOrder(@NotNull Integer id, Patient patient, Doctor doctor, List<Drug> drugs, BigDecimal dosage, Integer daysOfTreatment, BigDecimal totalPrice) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.drugs = drugs;
        this.dosage = dosage;
        DaysOfTreatment = daysOfTreatment;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDATE() {
        return DATE;
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

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public BigDecimal getDosage() {
        return dosage;
    }

    public void setDosage(BigDecimal dosage) {
        this.dosage = dosage;
    }

    public Integer getDaysOfTreatment() {
        return DaysOfTreatment;
    }

    public void setDaysOfTreatment(Integer daysOfTreatment) {
        DaysOfTreatment = daysOfTreatment;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
