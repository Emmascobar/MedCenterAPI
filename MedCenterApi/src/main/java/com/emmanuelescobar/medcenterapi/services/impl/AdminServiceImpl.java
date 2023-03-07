package com.emmanuelescobar.medcenterapi.services.impl;

import com.emmanuelescobar.medcenterapi.model.users.*;
import com.emmanuelescobar.medcenterapi.model.utils.Insurance;
import com.emmanuelescobar.medcenterapi.repository.scores.BloodPressureRegistryRepository;
import com.emmanuelescobar.medcenterapi.repository.users.*;
import com.emmanuelescobar.medcenterapi.repository.utils.InsuranceRepository;
import com.emmanuelescobar.medcenterapi.services.interfaces.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private BloodPressureRegistryRepository bloodPressureRegistryRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    String encodedPassword;

    Role role;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private SecretaryRepository secretaryRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    /** METHODS **/
    public Admin addNewAdmin(Admin admin) {
        encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        role = new Role("ADMIN");
        adminRepository.save(admin);
        return admin;
    }

    public Doctor addNewDoctor(Doctor doctor) {
        encodedPassword = passwordEncoder.encode(doctor.getPassword());
        doctor.setPassword(encodedPassword);
        role = new Role("DOCTOR");
        doctorRepository.save(doctor);
        return doctor;
    }

    public Receptionist addNewReceptionist(Receptionist receptionist) {
        encodedPassword = passwordEncoder.encode(receptionist.getPassword());
        receptionist.setPassword(encodedPassword);
        role = new Role("SECRETARY");
        secretaryRepository.save(receptionist);
        return receptionist;
    }

    public Pharmacy addNewPharmacy(Pharmacy pharmacy) {
        encodedPassword = passwordEncoder.encode(pharmacy.getPassword());
        pharmacy.setPassword(encodedPassword);
        role = new Role("PHARMACY");
        pharmacyRepository.save(pharmacy);
        return pharmacy;
    }

    @Override
    public List<Insurance> getInsuranceList() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance addNewInsurance(Insurance insurance) {
        insuranceRepository.save(insurance);
        return insurance ;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
