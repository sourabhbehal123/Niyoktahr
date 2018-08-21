package com.example.hp_pc.niyoktahr;

/**
 * Created by hp-pc on 8/1/2018.
 */

public class UserProfile {
    public String name;
    public String location;
    public String dateofbirth;


    public UserProfile() {
    }

    public UserProfile(String name, String dateofbirth, String location) {
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}

