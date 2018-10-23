package com.example.mssql.domain;


import java.sql.Timestamp;

public class Events {


    private int PersonId;
    private java.sql.Timestamp EventDate;
    private java.sql.Timestamp EventTime;
    private int DeviceId;


    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public Timestamp getEventDate() {
        return EventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        EventDate = eventDate;
    }

    public Timestamp getEventTime() {
        return EventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        EventTime = eventTime;
    }

    public int getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(int deviceId) {
        DeviceId = deviceId;
    }
}




