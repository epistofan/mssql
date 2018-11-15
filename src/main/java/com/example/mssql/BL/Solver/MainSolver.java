package com.example.mssql.BL.Solver;

import com.example.mssql.BL.DataPrep.Converter;
import com.example.mssql.BL.DataPrep.DateTimeConverter;
import com.example.mssql.BL.DataPrep.PersonListPrepare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Component
public class MainSolver implements Solver{

    @Autowired
    Converter converter;
    @Autowired
    TimeByDaySolver timeByDaySolver;

    @Override
    public String solve(Parameters parameters) {

        List<String>persons = converter.convert(parameters.getPersonIdList());
        Timestamp dateFromInTimestamp = converter.convertDate(parameters.getDateFrom());
        Timestamp dateTillInTimestamp = converter.convertDate(parameters.getDateTill());

        List listOfPrepared = new ArrayList();

        listOfPrepared.add(0,dateFromInTimestamp);
        listOfPrepared.add(1,dateTillInTimestamp);
        listOfPrepared.add(2,persons);


        timeByDaySolver.solve(listOfPrepared);

        return null;
    }
}
