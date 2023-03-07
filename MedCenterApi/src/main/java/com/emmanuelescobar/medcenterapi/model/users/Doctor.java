package com.emmanuelescobar.medcenterapi.model.users;

import com.emmanuelescobar.medcenterapi.model.utils.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Doctor extends User {
    @NotEmpty(message = "Insert a name")
    private String name;
    @NotEmpty(message = "Insert a surname")
    private  String surname;
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
    private String accountNumber;
    private String SSNumber;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @OneToMany(mappedBy = "doctors")
    private List<Patient> patients;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "doctor")
    private List<PharmacyOrder> pharmacyOrders;
    @OneToMany(mappedBy = "doctor")
    private List<ComplementaryTests> complementaryStudies;
    @OneToMany(mappedBy = "doctor")
    private List<MedicalReport> medicalReports;

    public Doctor() {
    }

    public Doctor(String email, String password, String surname, String DNI, LocalDate dayOfBirth, String sex, String genre, Integer telephoneNumber, String accountNumber, String SSNumber, Speciality speciality, List<Patient> patients, List<Appointment> appointments, List<PharmacyOrder> pharmacyOrders, List<ComplementaryTests> complementaryStudies, List<MedicalReport> medicalReports) {
        super(email, password);
        this.surname = surname;
        this.DNI = DNI;
        this.dayOfBirth = dayOfBirth;
        this.sex = sex;
        this.genre = genre;
        this.telephoneNumber = telephoneNumber;
        this.accountNumber = accountNumber;
        this.SSNumber = SSNumber;
        this.speciality = speciality;
        this.patients = patients;
        this.appointments = appointments;
        this.pharmacyOrders = pharmacyOrders;
        this.complementaryStudies = complementaryStudies;
        this.medicalReports = medicalReports;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSSNumber() {
        return SSNumber;
    }

    public void setSSNumber(String SSNumber) {
        this.SSNumber = SSNumber;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<PharmacyOrder> getPharmacyOrders() {
        return pharmacyOrders;
    }

    public void setPharmacyOrders(List<PharmacyOrder> pharmacyOrders) {
        this.pharmacyOrders = pharmacyOrders;
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
}
