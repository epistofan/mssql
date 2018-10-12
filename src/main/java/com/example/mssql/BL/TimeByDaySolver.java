package com.example.mssql.BL;

import com.example.mssql.DAO.Repository;
import com.example.mssql.domain.EventLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Component
public class TimeByDaySolver {


    @Autowired
    Repository repository;
    @Autowired
    DateTimeConverter dateTimeConverter;

    List<EventLog> events3;

    public String solve(Timestamp date3, Timestamp time3, String codes) {

        List<EventLog> events = repository.select(date3, time3, codes);
        System.out.println(events);


        int i;
StringBuffer sb = new StringBuffer("3F 00 A3 D7 46");
       for (i=0; !events.isEmpty(); i++ ){
           System.out.println(events.get(i).getKeyCode());
           if(events.get(i).getKeyCode().contentEquals(sb)){
               events3.add(events.get(i));

           }
           events.remove(i);
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
