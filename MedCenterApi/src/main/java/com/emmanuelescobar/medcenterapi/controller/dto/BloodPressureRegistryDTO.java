package com.emmanuelescobar.medcenterapi.controller.dto;

import com.emmanuelescobar.medcenterapi.model.scores.Comorbility;

import java.time.LocalDate;

public class BloodPressureRegistryDTO {

    private double averagePAS;
    private double averagePAD;
    private Comorbility comorbility;

    public BloodPressureRegistryDTO() {
    }

    public double getAveragePAS() {
        return averagePAS;
    }

    public void setAveragePAS(double averagePAS) {
        this.averagePAS = averagePAS;
    }

    public double getAveragePAD() {
        return averagePAD;
    }

    public void setAveragePAD(double averagePAD) {
        this.averagePAD = averagePAD;
    }

    public Comorbility getComorbility() {
        return comorbility;
    }

    public void setComorbility(Comorbility comorbility) {
        this.comorbility = comorbility;
    }
}
