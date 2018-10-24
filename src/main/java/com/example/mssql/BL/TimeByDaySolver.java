package com.example.mssql.BL;

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
    Repository repository;
    @Autowired
    DateTimeConverter dateTimeConverter;
    Stack<Events> stack = new Stack<>();
    List<Events> eventsOfOneDay;
    Stack<EventLog> events = new Stack<>();
    List<EventLog> test = new ArrayList<>();

    public String solve(List listOfPreparedData) {

        Timestamp date3 = (Timestamp) listOfPreparedData.get(0);
        Timestamp time3 = (Timestamp) listOfPreparedData.get(1);
        List<String> userId = (List<String>) listOfPreparedData.get(2);


        eventsOfOneDay = repository.selectEvents();

        System.out.println("before");

        for(i=0; i<eventsOfOneDay.size(); i++) {

int a = eventsOfOneDay.get(i).getPersonId();
int b = Integer.valueOf(userId.get(0));
            if( a == b ){
                stack.push(eventsOfOneDay.get(i));
            }


        }


        System.out.println("after");
        System.out.println("after2");
        System.out.println(stack.size());
while(!stack.isEmpty()){
    System.out.println(stack.pop().getEventTime());
}

        for(i=0; i<userId.size(); i++) {


            for(j=0; j<test.size(); j++){




            }
        }





        int inTime = dateTimeConverter.convertTime(events.get(0).getEventTime());
        int outTime = dateTimeConverter.convertTime(events.get(1).getEventTime());


        System.out.println(outTime-inTime);

        int timeDiff = outTime-inTime;
        String resultTime = dateTimeConverter.timeString(timeDiff);

        System.out.println(resultTime);

        return resultTime;
    }
}
