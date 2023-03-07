package com.emmanuelescobar.medcenterapi.controller.interfaces;

import com.emmanuelescobar.medcenterapi.model.users.*;
import com.emmanuelescobar.medcenterapi.model.utils.Insurance;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface AdminController {

    // ADMIN Permission:
    //-	Create another Admin Users.
    //-	Create Doctors, Patients, Secretary & Pharmacy Users.
    //-	He can find All Users and find by ID to.

    Admin addNewAdmin(Authentication authentication, Admin admin);
    Doctor addNewDoctor(Authentication authentication, Doctor doctor);
    Receptionist addNewReceptionist(Authentication authentication, Receptionist receptionist);
    Pharmacy addNewPharmacy(Authentication authentication, Pharmacy pharmacy);
    Insurance addNewInsurance(Authentication authentication, Insurance insurance);
    List<Insurance> getInsuranceList();
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);
}
