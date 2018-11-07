package com.example.mssql.BL.Solver;

import com.example.mssql.BL.DateTimeConverter;
import com.example.mssql.DAO.Repository;
import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;
import com.example.mssql.domain.WorkHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

@Component
public class TimeByDaySolver {

    int i = 0;
    int j;
    List events4 = new ArrayList();


    @Autowired
    DateTimeConverter dateTimeConverter;
    @Autowired
    Repository repository;

    private List<Events> eventsOfOneDay;
    Stack<EventLog> events = new Stack<>();


    public String solve(List listOfPreparedData) {

        Timestamp date3 = (Timestamp) listOfPreparedData.get(0);
        Timestamp time3 = (Timestamp) listOfPreparedData.get(1);
        List<String> userId = (List<String>) listOfPreparedData.get(2);

          System.out.println("choose from events needed id");

          eventsOfOneDay = repository.selectEvents(date3);
          Sorting sorting = new Sorting();
          sorting.sort(eventsOfOneDay, userId);







        int inTime = dateTimeConverter.convertTime(events.get(0).getEventTime());
        int outTime = dateTimeConverter.convertTime(events.get(1).getEventTime());


        System.out.println(outTime-inTime);

        int timeDiff = outTime-inTime;
        String resultTime = dateTimeConverter.timeString(timeDiff);

        System.out.println(resultTime);

        return resultTime;
    }
}
