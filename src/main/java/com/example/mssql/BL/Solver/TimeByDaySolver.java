package com.example.mssql.BL.Solver;

import com.example.mssql.DAL.Repository;
import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;
import com.example.mssql.domain.KeysWithPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class TimeByDaySolver {


    @Autowired
    Sorting sorting;

    private int i = 0;
    private int j;
    private List events4 = new ArrayList();


    private List<EventLog> eventsOfOneDay;
    private List<KeysWithPerson> keysWithPersonList;
    Stack<EventLog> events = new Stack<>();

    @Autowired
    private Repository repository;


    public String solve(List listOfPreparedData) {

        Timestamp dateFrom = (Timestamp) listOfPreparedData.get(0);
        Timestamp dateTill = (Timestamp) listOfPreparedData.get(1);
        List<String> userId = (List<String>) listOfPreparedData.get(2);


          System.out.println("choose from events needed id");

          eventsOfOneDay = repository.selectEvents(dateFrom);
          keysWithPersonList=repository.selectKeysWithPerson();

            sorting.sort1(eventsOfOneDay, keysWithPersonList);



        String resultTime = null;



        return resultTime;
    }
}
