package com.example.mssql.domain;

import java.util.Date;
import java.util.List;

public class TestClass {


    private String dateTime;

    private List<PersonsWithTime> result;


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<PersonsWithTime> getResult() {
        return result;
    }

    public void setResult(List<PersonsWithTime> result) {
        this.result = result;
    }
}
