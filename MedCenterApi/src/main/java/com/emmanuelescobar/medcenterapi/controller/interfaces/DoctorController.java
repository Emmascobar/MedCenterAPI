package com.emmanuelescobar.medcenterapi.controller.interfaces;

import com.emmanuelescobar.medcenterapi.model.scores.BloodPressureRegistry;
import com.emmanuelescobar.medcenterapi.model.users.Patient;

import java.util.List;
import java.util.Optional;

public interface DoctorController {

    // DOCTOR Permission:
    //-	Create patients.
    //-	Find all and a specific patient by ID, Name or DNI.
    //-	Read, write and uses the tables and scores of system.

    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Integer id);
    Optional<Patient>  getPatientByNameOrSurname(String name);
    Optional<Patient>  getPatientDNI(String DNI);
    Patient addNewPatient(Patient patient);
    void BPClassification(Integer PatientId, BloodPressureRegistry bloodPressureRegistry);

}
