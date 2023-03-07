package com.emmanuelescobar.medcenterapi.controller.impl;

import com.emmanuelescobar.medcenterapi.controller.interfaces.AdminController;
import com.emmanuelescobar.medcenterapi.model.users.*;
import com.emmanuelescobar.medcenterapi.model.utils.Insurance;
import com.emmanuelescobar.medcenterapi.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminControllerImpl implements AdminController {

    @Autowired
    AdminService adminService;

    /** ROUTES **/
    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addNewAdmin(Authentication authentication, @RequestBody @Valid Admin admin) {
        return adminService.addNewAdmin(admin);
    }

    @PostMapping("/admin/users/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addNewDoctor(Authentication authentication, @RequestBody @Valid Doctor doctor) {
        return adminService.addNewDoctor(doctor);
    }

    @PostMapping("/admin/users/receptionist")
    @ResponseStatus(HttpStatus.CREATED)
    public Receptionist addNewReceptionist(Authentication authentication, @RequestBody @Valid Receptionist receptionist) {
        return adminService.addNewReceptionist(receptionist);
    }


    @PostMapping("/admin/users/pharmacy")
    @ResponseStatus(HttpStatus.CREATED)
    public Pharmacy addNewPharmacy(Authentication authentication, @RequestBody @Valid Pharmacy pharmacy) {
        return adminService.addNewPharmacy(pharmacy);
    }
    @PostMapping("/admin/insurance")
    @ResponseStatus(HttpStatus.CREATED)
    public Insurance addNewInsurance(Authentication authentication, @RequestBody @Valid Insurance insurance) {
        return adminService.addNewInsurance(insurance);
    }

    @GetMapping("/admin/insurance")
    @ResponseStatus(HttpStatus.OK)
    public List<Insurance> getInsuranceList() {
        return adminService.getInsuranceList();
    }

    @GetMapping("/admin/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/admin/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Integer id) {
        return adminService.getUserById(id);
    }
}
