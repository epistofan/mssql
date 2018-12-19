package com.example.mssql.BL.Factory;


import com.example.mssql.domain.EventLog;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class DurationOfTheDayShop {

        private int i;
        private int j;
        private HashMap<Integer, Object> workingTimePairs = new HashMap<>();

    public HashMap<Integer, Object> solver(HashMap<Integer, Stack<EventLog>> eventsByPersonId) throws EmptyStackException {




            Set test = eventsByPersonId.keySet();
            Iterator iterator = test.iterator();

        for (j=0 ; j < eventsByPersonId.size(); j++) {
            Stack pairs = new Stack();
            i = (Integer) iterator.next();
            try {
                System.out.println("id "+i);
                 while( !eventsByPersonId.get(i).isEmpty())

                      {
                        System.out.println(eventsByPersonId.get(i).peek().getEventTime().toLocalDateTime());
                        LocalDateTime localDateTime = (eventsByPersonId.get(i).pop().getEventTime().toLocalDateTime());
                        System.out.println(eventsByPersonId.get(i).peek().getEventTime().toLocalDateTime());
                         LocalDateTime localDateTime2 = (eventsByPersonId.get(i).pop().getEventTime().toLocalDateTime());

                            Duration duration = Duration.between(localDateTime2, localDateTime);
                        System.out.println(duration.toString());

                        pairs.push(duration.toString());
                    }
            }catch (EmptyStackException exception){
                exception.printStackTrace();
                System.out.println("Empty or no end time");
            }
            workingTimePairs.put(i, pairs);
        }

        return workingTimePairs;
    }


}
