package com.emmanuelescobar.medcenterapi.model.users;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
    }

    public Admin(String email, String password) {
        super(email, password);
    }
}
