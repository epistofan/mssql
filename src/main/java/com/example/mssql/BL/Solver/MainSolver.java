package com.example.mssql.BL.Solver;

import com.example.mssql.BL.DataPrep.DateTimeConverter;
import com.example.mssql.BL.DataPrep.PersonListPrepare;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Component
public class MainSolver {



    private PersonListPrepare personListPrepare = new PersonListPrepare();

    private DateTimeConverter dateTimeConverter = new DateTimeConverter();

    private TimeByDaySolver timeByDaySolver = new TimeByDaySolver();

    private String timeValue;


    private List prepare(String dateFrom, String dateTill, String PersonIdList, String time) throws ParseException {


        List persons = personListPrepare.convert(PersonIdList);


        Timestamp dateFromInTimestamp = dateTimeConverter.convertDate(dateFrom);
        Timestamp dateTillInTimestamp = dateTimeConverter.convertDate(dateTill);

        List listOfPrepared = new ArrayList();

        listOfPrepared.add(0,dateFromInTimestamp);
        listOfPrepared.add(1,dateTillInTimestamp);
        listOfPrepared.add(2,persons);


        return listOfPrepared ;
    }

    public String solve(String dateFrom, String dateTill, String personIdList, String time) throws ParseException {

        List listOfPreparedData = this.prepare(dateFrom, dateTill, personIdList, time);


        timeByDaySolver.solve(listOfPreparedData);


        return timeValue;
    }


}
