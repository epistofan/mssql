package com.example.mssql.BL;

import org.joda.time.LocalTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateTimeConverter {

    private int timeInMs;
    private String timeInString;

    public Timestamp convertDate(String date) throws ParseException {
        SimpleDateFormat dateFormatq = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = date;
        Date parsedDateq = dateFormatq.parse(date2);
        Timestamp convertedDate = new java.sql.Timestamp(parsedDateq.getTime());
        System.out.println(convertedDate);


        return convertedDate;

    }

    public Timestamp convertTime(String time) throws ParseException {

        SimpleDateFormat dateFormatT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeOfSql = "1900-01-01 00:00:00";
        Date parsedDateT = dateFormatT.parse(timeOfSql);

        LocalTime dt = new LocalTime(time);
        int timeNedeed = dt.getMillisOfDay();
        System.out.println(timeNedeed);

        Timestamp convertedTime = new java.sql.Timestamp(parsedDateT.getTime()+timeNedeed);
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
