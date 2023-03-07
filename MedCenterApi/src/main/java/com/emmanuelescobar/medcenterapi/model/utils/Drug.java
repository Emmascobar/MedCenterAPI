package com.emmanuelescobar.medcenterapi.model.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;

@Entity
public class Drug {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is necesary")
    private String name;
    @NotEmpty(message = "Presentation is necesary")
    private String presentation;
    public Drug() {
    }

    public Drug(String name, String presentation) {
        this.name = name;
        this.presentation = presentation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }
}
