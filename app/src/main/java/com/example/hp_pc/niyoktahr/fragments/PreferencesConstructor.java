package com.example.hp_pc.niyoktahr.fragments;

/**
 * Created by hp-pc on 8/19/2018.
 */

public class PreferencesConstructor {
    public String city111,city12,city13;

    public PreferencesConstructor() {
    }

    public PreferencesConstructor(String city111, String city12, String city13) {
        this.city111 = city111;
        this.city12 = city12;
        this.city13 = city13;
    }

    public String getCity111() {
        return city111;
    }

    public void setCity111(String city111) {
        this.city111 = city111;
    }

    public String getCity12() {
        return city12;
    }

    public void setCity12(String city12) {
        this.city12 = city12;
    }

    public String getCity13() {
        return city13;
    }

    public void setCity13(String city13) {
        this.city13 = city13;
    }
}
