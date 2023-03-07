package com.emmanuelescobar.medcenterapi.repository.users;

import com.emmanuelescobar.medcenterapi.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}