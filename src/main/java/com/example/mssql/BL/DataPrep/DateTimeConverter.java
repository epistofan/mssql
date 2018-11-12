package com.example.mssql.BL.DataPrep;

import org.joda.time.LocalTime;

import java.sql.Timestamp;


public class DateTimeConverter implements Converter{

    private int timeInMs;
    private String timeInString;

    @Override
    public Timestamp convertDate(String dateFrom)  {
        String TimeOfTimestamp = " 00:00:00";
        Timestamp convertedDate = Timestamp.valueOf(dateFrom+TimeOfTimestamp);
        System.out.println(convertedDate);

        return convertedDate;

    }

    @Override
    public Timestamp convertTime(String time) {

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
