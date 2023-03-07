package com.emmanuelescobar.medcenterapi.repository.users;

import com.emmanuelescobar.medcenterapi.model.users.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {
}