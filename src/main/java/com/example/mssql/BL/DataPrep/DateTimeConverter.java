package com.example.mssql.BL.DataPrep;

import org.joda.time.LocalTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
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

    @Override
    public List<String> convert(String PersonIdList) {
        List listOfUserId = new ArrayList(Arrays.asList(PersonIdList.split(",")));

        return listOfUserId;
    }


}
