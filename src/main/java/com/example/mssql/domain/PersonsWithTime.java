package com.example.mssql.domain;

import java.time.Duration;
import java.util.List;

public class PersonsWithTime {


    private int id;
    private String firstName;
    private String lastName;
    private Duration duration;
    private List<Duration> workingTimePairs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public List getWorkingTimePairs() {
        return workingTimePairs;
    }

    public void setWorkingTimePairs(List workingTimePairs) {
        this.workingTimePairs = workingTimePairs;
    }
}
