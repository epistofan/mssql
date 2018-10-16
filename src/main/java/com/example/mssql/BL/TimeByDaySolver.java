package com.example.mssql.BL;

import com.example.mssql.DAO.Repository;
import com.example.mssql.domain.EventLog;
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
    Stack<Object> stack = new Stack<>();
    List<EventLog> events3;
    Stack<EventLog> events = new Stack<>();
    List<EventLog> test = new ArrayList<>();

    public String solve(List listOfPreparedData) {

        Timestamp date3 = (Timestamp) listOfPreparedData.get(0);
        Timestamp time3 = (Timestamp) listOfPreparedData.get(1);
        List codes = (List) listOfPreparedData.get(2);


        List<EventLog> events1 = repository.select(date3, time3);



        System.out.println("before");
        //while (events1.size() != test.size()) {
        for(i=0; i<events1.size(); i++) {

                    System.out.println(events1.get(i));
                    System.out.println(events1.get(i).getKeyCode());

                    test.add(events1.get(i));
                   //events1.remove(i);

        }


        System.out.println("after");
        System.out.println("after2");
        System.out.println(test.size());


        while(!codes.isEmpty()){

            codes.get(i);
            //List<WorkHistory> events3 = repository.selectWorkHistory(codes.get(i).toString());
            for(j=0; events.isEmpty(); j++){

                if(events.pop().getEventId() == i){

                    stack.push(events.pop());


                }




            }






            codes.remove(i);








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
