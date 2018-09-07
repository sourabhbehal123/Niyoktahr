package com.example.hp_pc.niyoktahr;

/**
 * Created by hp-pc on 8/29/2018.
 */

public class jobpost_constructor{
        public String jobTitle;
        public String jobDescription;
    public String salary;

    public String userid;


    public jobpost_constructor() {
    }

    public jobpost_constructor(String jobTitle, String jobDescription, String salary, String userid) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.salary = salary;
        this.userid = userid;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
