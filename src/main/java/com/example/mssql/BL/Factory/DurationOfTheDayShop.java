package com.example.mssql.BL.Factory;


import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.PersonsWithTime;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class DurationOfTheDayShop {

        private int i;
        private int j;
        private HashMap<Integer, Object> workingTimePairs = new HashMap<>();
        private List<PersonsWithTime> personsWithTimeList = new ArrayList<>();

    public List<PersonsWithTime> solver(HashMap<Integer, Stack<EventLog>> eventsByPersonId) throws EmptyStackException {

            Set test = eventsByPersonId.keySet();
            Iterator iterator = test.iterator();

        for (j=0 ; j < eventsByPersonId.size(); j++) {
           // Stack pairs = new Stack();
            List<Duration> pairs = new ArrayList<>();
            PersonsWithTime personsWithTime = new PersonsWithTime();
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

                        pairs.add(duration);
                        personsWithTime.setWorkingTimePairs(pairs);
                    }
            }catch (EmptyStackException exception){
                exception.printStackTrace();
                System.out.println("Empty or no end time");
            }
            //workingTimePairs.put(i, pairs);
            personsWithTime.setId(i);
            personsWithTimeList.add(personsWithTime);
        }

        return personsWithTimeList;
    }


}
