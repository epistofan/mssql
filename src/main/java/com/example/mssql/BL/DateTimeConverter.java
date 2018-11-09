package com.example.mssql.BL;

import org.joda.time.LocalTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;



public class DateTimeConverter {

    private int timeInMs;
    private String timeInString;

    public Timestamp convertDate(String dateFrom) throws ParseException {
        String TimeOfTimestamp = " 00:00:00";
        Timestamp convertedDate = Timestamp.valueOf(dateFrom+TimeOfTimestamp);
        System.out.println(convertedDate);

        return convertedDate;

    }

    public Timestamp convertTime(String time) throws ParseException {

        String dateOfTimestamp = "1900-01-01 ";
        Timestamp convertedTime = Timestamp.valueOf(dateOfTimestamp + time);
        System.out.println(convertedTime);

        return convertedTime;
    }
    public int convertTime(Timestamp timestamp){

        LocalTime dt = new LocalTime(timestamp);

        timeInMs = dt.getMillisOfDay();



        return timeInMs;
    }

    public String timeString (int timeInMs){

        LocalTime lc = new LocalTime(timeInMs);
        timeInString = lc.toString();

        return timeInString;
    }

}
