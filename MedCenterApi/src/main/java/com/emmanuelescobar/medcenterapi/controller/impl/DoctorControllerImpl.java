package com.emmanuelescobar.medcenterapi.controller.impl;

import com.emmanuelescobar.medcenterapi.controller.interfaces.DoctorController;
import com.emmanuelescobar.medcenterapi.model.scores.BloodPressureRegistry;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import com.emmanuelescobar.medcenterapi.services.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorControllerImpl implements DoctorController {

    @Autowired
    DoctorService doctorService;


    /** ROUTES **/
    @GetMapping("/doctors/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return doctorService.findAllPatients();
    }

    @GetMapping("/doctors/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatientById(@PathVariable Integer id) {
        return doctorService.findPatientById(id);
    }

    @GetMapping("/doctors/patients/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatientByNameOrSurname(@PathVariable String name) {
        return doctorService.findPatientByNameOrSurname(name);
    }

    @GetMapping("/doctors/patients/{DNI}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatientDNI(@PathVariable String DNI) {
        return doctorService.findPatientDNI(DNI);
    }

    @PostMapping("/doctors/patient/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody Patient patient) {
        return doctorService.addNewPatient(patient);
    }

    @PostMapping("/doctors/patients/{id}/blood-pressure")
    @ResponseStatus(HttpStatus.CREATED)
    public void BPClassification(@PathVariable Integer PatientId, @RequestBody BloodPressureRegistry bloodPressureRegistry) {

    }
}
