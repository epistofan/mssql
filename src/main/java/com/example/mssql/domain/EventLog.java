package com.example.mssql.domain;


import org.springframework.stereotype.Component;


import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Objects;



    public class EventLog {

        public EventLog() {
        }

       private int EventId;

        private java.sql.Timestamp EventDate;


        private java.sql.Timestamp EventTime;


        private int EventTypeCode;


        private int PreprocessorId;


        private int DeviceId;


        private String KeyCode;


        private int DoorState;


        private String Changed;

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public java.sql.Timestamp getEventDate() {
        return EventDate;
    }

    public void setEventDate(java.sql.Timestamp eventDate) {
        EventDate = eventDate;
    }

    public java.sql.Timestamp getEventTime() {
        return EventTime;
    }

    public void setEventTime(java.sql.Timestamp eventTime) {
        EventTime = eventTime;
    }

    public int getEventTypeCode() {
        return EventTypeCode;
    }

    public void setEventTypeCode(int eventTypeCode) {
        EventTypeCode = eventTypeCode;
    }

    public int getPreprocessorId() {
        return PreprocessorId;
    }

    public void setPreprocessorId(int preprocessorId) {
        PreprocessorId = preprocessorId;
    }

    public int getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(int deviceId) {
        DeviceId = deviceId;
    }

    public String getKeyCode() {
        return KeyCode;
    }

    public void setKeyCode(String keyCode) {
        KeyCode = keyCode;
    }

    public int getDoorState() {
        return DoorState;
    }

    public void setDoorState(int doorState) {
        DoorState = doorState;
    }

    public String getChanged() {
        return Changed;
    }

    public void setChanged(String changed) {
        Changed = changed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventLog eventLog = (EventLog) o;
        return EventId == eventLog.EventId &&
                EventTypeCode == eventLog.EventTypeCode &&
                PreprocessorId == eventLog.PreprocessorId &&
                DeviceId == eventLog.DeviceId &&
                DoorState == eventLog.DoorState &&
                Objects.equals(EventDate, eventLog.EventDate) &&
                Objects.equals(EventTime, eventLog.EventTime) &&
                Objects.equals(KeyCode, eventLog.KeyCode) &&
                Objects.equals(Changed, eventLog.Changed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EventId, EventDate, EventTime, EventTypeCode, PreprocessorId, DeviceId, KeyCode, DoorState, Changed);
    }
}
