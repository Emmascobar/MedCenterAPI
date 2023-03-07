package com.emmanuelescobar.medcenterapi.services.interfaces;

import com.emmanuelescobar.medcenterapi.model.scores.BloodPressureRegistry;
import com.emmanuelescobar.medcenterapi.model.users.Patient;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    // DOCTOR Permission:
    //-	Create patients.
    //-	Find all and a specific patient by ID, Name or DNI.
    //-	Read, write and uses the tables and scores of system.

    List<Patient> findAllPatients();
    Optional<Patient> findPatientById(Integer id);
    Optional<Patient>  findPatientByNameOrSurname(String name);
    Optional<Patient>  findPatientDNI(String DNI);
    Patient addNewPatient(Patient patient);
    void BPClassification(Integer PatientId, BloodPressureRegistry bloodPressureRegistry);

}
