package com.example.mssql.BL.Factory;

import com.example.mssql.BL.DataPrep.Converter;
import com.example.mssql.DAL.Repository;
import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.KeysWithPerson;
import com.example.mssql.domain.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


@Component
public class ReceivingReturningShop {

    @Autowired
    Converter converter;
    @Autowired
    DurationOfTheDayShop durationOfTheDayShop;
    @Autowired
    EventsByPersonIdShop eventsByPersonIdShop;
    @Autowired
    Repository repository;


    private List<EventLog> eventsOfOneDay;
    private List<KeysWithPerson> keysWithPersonList;
    private HashMap<Integer, Stack<EventLog>> eventsByPersonId =new HashMap<>();
    private HashMap<Integer, Object> readyList = new HashMap<>();

    public HashMap<Integer, Object> solve(Parameters parameters) {

        List<String>persons = converter.convert(parameters.getPersonIdList());
        Timestamp dateFromInTimestamp = converter.convertDate(parameters.getDateFrom());
        Timestamp dateTillInTimestamp = converter.convertDate(parameters.getDateTill());

        eventsOfOneDay = repository.selectEvents(dateFromInTimestamp);
        keysWithPersonList=repository.selectKeysWithPerson(dateFromInTimestamp);

        eventsByPersonId = eventsByPersonIdShop.sort1(eventsOfOneDay, keysWithPersonList);

        readyList = durationOfTheDayShop.solver(eventsByPersonId);


        return readyList;
    }
}
