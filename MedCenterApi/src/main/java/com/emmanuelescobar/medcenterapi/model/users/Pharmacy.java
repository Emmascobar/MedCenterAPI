package com.emmanuelescobar.medcenterapi.model.users;

import jakarta.persistence.Entity;

@Entity
public class Pharmacy extends User {
    public Pharmacy() {
    }
    public Pharmacy(String email, String password) {
        super(email, password);
    }
}
