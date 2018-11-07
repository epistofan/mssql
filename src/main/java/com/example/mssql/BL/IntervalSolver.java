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

        if (dateTime1 == dateTime.plusDays(10)) {
            System.out.println(dateTime);
            System.out.println(dateTime.plusDays(10));
        }else{
            System.out.println("fff");
        }
    }


}
