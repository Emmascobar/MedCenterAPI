package com.emmanuelescobar.medcenterapi.repository.users;

import com.emmanuelescobar.medcenterapi.model.users.Doctor;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


}