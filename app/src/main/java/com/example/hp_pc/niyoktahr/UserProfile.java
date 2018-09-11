package com.example.hp_pc.niyoktahr;

/**
 * Created by hp-pc on 8/1/2018.
 */

public class UserProfile {
    public String  personal_namecon , personal_emailcon , personal_locationcon, personal_phonecon , personal_dobcon;

    public UserProfile(String personal_namecon, String personal_emailcon, String personal_locationcon, String personal_phonecon, String personal_dobcon) {
        this.personal_namecon = personal_namecon;
        this.personal_emailcon = personal_emailcon;
        this.personal_locationcon = personal_locationcon;
        this.personal_phonecon = personal_phonecon;
        this.personal_dobcon = personal_dobcon;
    }

    public UserProfile() {
    }

    public String getPersonal_namecon() {
        return personal_namecon;
    }

    public void setPersonal_namecon(String personal_namecon) {
        this.personal_namecon = personal_namecon;
    }

    public String getPersonal_emailcon() {
        return personal_emailcon;
    }

    public void setPersonal_emailcon(String personal_emailcon) {
        this.personal_emailcon = personal_emailcon;
    }

    public String getPersonal_locationcon() {
        return personal_locationcon;
    }

    public void setPersonal_locationcon(String personal_locationcon) {
        this.personal_locationcon = personal_locationcon;
    }

    public String getPersonal_phonecon() {
        return personal_phonecon;
    }

    public void setPersonal_phonecon(String personal_phonecon) {
        this.personal_phonecon = personal_phonecon;
    }

    public String getPersonal_dobcon() {
        return personal_dobcon;
    }

    public void setPersonal_dobcon(String personal_dobcon) {
        this.personal_dobcon = personal_dobcon;
    }
}

