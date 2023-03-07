package com.emmanuelescobar.medcenterapi.model.users;

import jakarta.persistence.Entity;

@Entity
public class Receptionist extends User{
    public Receptionist() {
    }

    public Receptionist(String email, String password) {
        super(email, password);
    }
}
