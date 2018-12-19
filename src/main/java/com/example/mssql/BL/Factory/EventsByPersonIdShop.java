package com.example.mssql.BL.Factory;

import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;
import com.example.mssql.domain.KeysWithPerson;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EventsByPersonIdShop {

    private int i = 0;
    private int j = 0;

    private HashMap<Integer, Stack<EventLog>> eventsByPersonId = new HashMap<Integer, Stack<EventLog>>();



    public HashMap<Integer, Stack<EventLog>> sort1(List<EventLog> eventsOfOneDay, List<KeysWithPerson> keysWithPersonList){

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
    if(stack.isEmpty()){
        System.out.println("empty");

    }else{


        eventsByPersonId.put(keysWithPersonList.get(j).getPersonId(), stack);

            }

        }
            System.out.println(eventsByPersonId);


        return eventsByPersonId;
        }
    }
