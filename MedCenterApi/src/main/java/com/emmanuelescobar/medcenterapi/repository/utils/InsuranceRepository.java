package com.emmanuelescobar.medcenterapi.repository.utils;

import com.emmanuelescobar.medcenterapi.model.utils.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}