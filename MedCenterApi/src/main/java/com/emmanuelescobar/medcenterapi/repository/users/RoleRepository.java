package com.emmanuelescobar.medcenterapi.repository.users;

import com.emmanuelescobar.medcenterapi.model.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}