package com.example.mssql.BL.Factory;


import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

@Component
public class DurationOfTheDayShop {




    public void solver(HashMap<Integer, Stack<EventLog>> eventsByPersonId){



        while (!eventsByPersonId.isEmpty()) {

            Set test = eventsByPersonId.keySet();
            Integer i = (Integer) test.iterator().next();

            System.out.println(eventsByPersonId.get(i).peek().getEventTime().toLocalDateTime());
            LocalDateTime localDateTime = (eventsByPersonId.get(i).pop().getEventTime().toLocalDateTime());
            System.out.println(eventsByPersonId.get(i).peek().getEventTime().toLocalDateTime());
            LocalDateTime localDateTime2 = (eventsByPersonId.get(i).pop().getEventTime().toLocalDateTime());

            Duration duration = Duration.between(localDateTime2, localDateTime);
            System.out.println(duration.toString());




        }

    }


}
