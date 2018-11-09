package com.example.mssql.BL;

import org.joda.time.DateTime;

import java.sql.Timestamp;

public class IntervalSolver {


    DateTime dateTime;
    DateTime dateTime1;
    Timestamp timestamp;
    Timestamp timestamp1;

    public void solve (){



        dateTime = new DateTime("2015-01-01");
        dateTime1 = new DateTime("2015-01-30");

        Timestamp timestamp1 = Timestamp.valueOf("2015-01-01 00:00:00");
        System.out.println(timestamp1);
        String time = "05:15:11";
        String timeOfSql = "1900-01-01 ";
        Timestamp convertedTime = Timestamp.valueOf(timeOfSql + time);
        System.out.println(convertedTime);

        if (dateTime1 == dateTime.plusDays(10)) {
            System.out.println(dateTime);
            System.out.println(dateTime.plusDays(10));
        }else{
            System.out.println("fff");
        }
    }


}
