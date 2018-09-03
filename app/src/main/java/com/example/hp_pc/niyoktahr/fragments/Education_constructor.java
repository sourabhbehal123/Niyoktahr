package com.example.hp_pc.niyoktahr.fragments;

/**
 * Created by hp-pc on 8/18/2018.
 */

public class Education_constructor {
    public String course;
    public String university;
    public String qualifications;

    public Education_constructor(String course, String university, String qualifications) {
        this.course = course;
        this.university = university;
        this.qualifications = qualifications;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
