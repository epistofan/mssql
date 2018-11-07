package com.example.mssql.BL.Solver;

import com.example.mssql.BL.DateTimeConverter;
import com.example.mssql.BL.PersonListPrepare;
import com.example.mssql.BL.Solver.TimeByDaySolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MainSolver {


    @Autowired
    PersonListPrepare personListPrepare;
    @Autowired
    DateTimeConverter dateTimeConverter;
    @Autowired
    TimeByDaySolver timeByDaySolver;

    String timeValue;

    public List prepare(String PersonIdList, String date, String time) throws ParseException {


        List persons = personListPrepare.convert(PersonIdList);

        Timestamp timeInTimestamp = dateTimeConverter.convertTime(time);
        Timestamp dateInTimestamp = dateTimeConverter.convertDate(date);

        List listOfPrepared = new ArrayList();

        listOfPrepared.add(0,dateInTimestamp);
        listOfPrepared.add(1,timeInTimestamp);
        listOfPrepared.add(2,persons);


        return listOfPrepared ;
    }

    public String solve(String date, String time, String personIdList) throws ParseException {

        List listOfPreparedData = this.prepare(personIdList, date, time);


        timeByDaySolver.solve(listOfPreparedData);


        return timeValue;
    }


}
