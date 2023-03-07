package com.emmanuelescobar.medcenterapi.repository.scores;

import com.emmanuelescobar.medcenterapi.model.scores.BloodPressureRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodPressureRegistryRepository extends JpaRepository<BloodPressureRegistry, Integer> {


}