package com.example.mssql.BL.Factory;

import com.example.mssql.DAL.Repository;
import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.KeysWithPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class DurationOfTheDayShop {


    @Autowired
    EventsByPersonIdShop eventsByPersonIdShop;

    private int i = 0;
    private int j;
    private List events4 = new ArrayList();


    private List<EventLog> eventsOfOneDay;
    private List<KeysWithPerson> keysWithPersonList;
    Stack<EventLog> events = new Stack<>();

    @Autowired
    private Repository repository;
    @Autowired
    DurOfTheDayShop durOfTheDayShop;


    public String solve(List listOfPreparedData) {

        Timestamp dateFrom = (Timestamp) listOfPreparedData.get(0);
        Timestamp dateTill = (Timestamp) listOfPreparedData.get(1);
        List<String> userId = (List<String>) listOfPreparedData.get(2);


          System.out.println("choose from events needed id");

          eventsOfOneDay = repository.selectEvents(dateFrom);
          keysWithPersonList=repository.selectKeysWithPerson(dateFrom);




        durOfTheDayShop.solver(eventsByPersonIdShop.sort1(eventsOfOneDay, keysWithPersonList));

        String resultTime = null;



        return resultTime;
    }
}
