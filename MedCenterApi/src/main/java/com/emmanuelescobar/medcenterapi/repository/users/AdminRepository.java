package com.emmanuelescobar.medcenterapi.repository.users;

import com.emmanuelescobar.medcenterapi.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}