package com.example.mssql.BL.Solver;

import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;
import com.example.mssql.domain.KeysWithPerson;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.*;

@Component
public class Sorting {

    private int i = 0;
    private int j = 0;


    private Stack<EventLog> zhopa = new Stack<>();
    private Stack<Object> sorted = new Stack<>();
    private HashMap<Integer, Object> eventsByPersonId = new HashMap<>();

   public void sort(List<Events> eventsOfOneDay, List<String> userId) {




   }

    public void sort1(List<EventLog> eventsOfOneDay, List<KeysWithPerson> keysWithPersonList){

        for(j = 0; j < keysWithPersonList.size(); j++) {
            Stack<EventLog> stack = new Stack<>();
              for (i = 0; i < eventsOfOneDay.size(); i++) {

                  System.out.println(eventsOfOneDay.get(i).getKeyCode());
                  System.out.println(keysWithPersonList.get(j).getKeyCode());
                String s1 = eventsOfOneDay.get(i).getKeyCode();
                String s2 = keysWithPersonList.get(j).getKeyCode();


                                      if (s1.equals(s2)) {

                             stack.push(eventsOfOneDay.get(i));

        }


    }
    if(stack.isEmpty()){System.out.println("empty");

    }else{


        eventsByPersonId.put(keysWithPersonList.get(j).getPersonId(), stack);

    }

}
            System.out.println(eventsByPersonId);

        zhopa = (Stack<EventLog>) eventsByPersonId.get(9);

        while (!zhopa.isEmpty()) {
          System.out.println(zhopa.pop().getEventTime().toLocalDateTime());
            System.out.println(zhopa.pop().getEventTime().toLocalDateTime());

            LocalDateTime localDateTime = (zhopa.pop().getEventTime().toLocalDateTime());
            LocalDateTime localDateTime2 = (zhopa.pop().getEventTime().toLocalDateTime());

            Duration duration = Duration.between(localDateTime2, localDateTime);


        }
    }
}
