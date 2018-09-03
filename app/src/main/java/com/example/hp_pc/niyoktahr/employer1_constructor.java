package com.example.hp_pc.niyoktahr;

/**
 * Created by hp-pc on 8/24/2018.
 */

public class employer1_constructor {
    public String company;
    public String profession;
    public String job;

    public employer1_constructor(String company, String profession, String job) {
        this.company = company;
        this.profession = profession;
        this.job = job;
    }

    public employer1_constructor() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
