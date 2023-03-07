package com.emmanuelescobar.medcenterapi.model.users;

import com.emmanuelescobar.medcenterapi.model.others.Address;
import com.emmanuelescobar.medcenterapi.model.utils.*;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Patient extends User{

    @NotEmpty(message = "Insert a name")
    private String name;
    @NotEmpty(message = "Insert a surname")
    private String surname;
    @NotEmpty(message = "DNI number is empty")
    private String DNI;
    @NotEmpty(message = "please, insert a birthday")
    private LocalDate dayOfBirth;
    @NotEmpty(message = "Sex & Genre are mandatory")
    private String sex;
    @NotEmpty(message = "Sex & Genre are mandatory")
    private String genre;
    @NotEmpty(message = "insert a mobil phone number")
    private Integer telephoneNumber;
    @ManyToOne
    private List<Doctor> doctors;
    @ManyToOne
    private Insurance insurance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<ComplementaryTests> complementaryStudies;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<MedicalReport> medicalReports;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<PharmacyOrder> pharmacyOrders;
    @Embedded
    private Address address;

    public Patient() {
    }

    public Patient(String email, String password, String name, String surname, String DNI, LocalDate dayOfBirth, String sex, String genre, Integer telephoneNumber, List<Doctor> doctors, Insurance insurance, List<Appointment> appointments, List<ComplementaryTests> complementaryStudies, List<MedicalReport> medicalReports, List<PharmacyOrder> pharmacyOrders, Address address) {
        super(email, password);
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
        this.dayOfBirth = dayOfBirth;
        this.sex = sex;
        this.genre = genre;
        this.telephoneNumber = telephoneNumber;
        this.doctors = doctors;
        this.insurance = insurance;
        this.appointments = appointments;
        this.complementaryStudies = complementaryStudies;
        this.medicalReports = medicalReports;
        this.pharmacyOrders = pharmacyOrders;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<ComplementaryTests> getComplementaryStudies() {
        return complementaryStudies;
    }

    public void setComplementaryStudies(List<ComplementaryTests> complementaryStudies) {
        this.complementaryStudies = complementaryStudies;
    }

    public List<MedicalReport> getMedicalReports() {
        return medicalReports;
    }

    public void setMedicalReports(List<MedicalReport> medicalReports) {
        this.medicalReports = medicalReports;
    }

    public List<PharmacyOrder> getPharmacyOrders() {
        return pharmacyOrders;
    }

    public void setPharmacyOrders(List<PharmacyOrder> pharmacyOrders) {
        this.pharmacyOrders = pharmacyOrders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}