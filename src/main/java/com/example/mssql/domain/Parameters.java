package com.example.mssql.domain;

import org.springframework.stereotype.Component;

@Component
public class Parameters {

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTill() {
        return dateTill;
    }

    public void setDateTill(String dateTill) {
        this.dateTill = dateTill;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPersonIdList() {
        return personIdList;
    }

    public void setPersonIdList(String personIdList) {
        this.personIdList = personIdList;
    }

    String dateFrom;
    String dateTill;
    String time;
    String personIdList;



}
