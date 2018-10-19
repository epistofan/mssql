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
    List<WorkHistory> events3;
    Stack<EventLog> events = new Stack<>();
    List<EventLog> test = new ArrayList<>();

    public String solve(List listOfPreparedData) {

        Timestamp date3 = (Timestamp) listOfPreparedData.get(0);
        Timestamp time3 = (Timestamp) listOfPreparedData.get(1);
        List<String> codes = (List<String>) listOfPreparedData.get(2);


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


        for(i=0; i<codes.size(); i++) {

                     int idr = Integer.parseInt(codes.get(i));

                     events3 = repository.selectWorkHistory(idr);

            for(j=0; j<test.size(); j++){
              String trtrtrtr =  test.get(j).getKeyCode();
               String uyfvbkl = events3.get(i).getKeys().getKeyCode();

            if(test.get(j).getKeyCode() == events3.get(i).getKeys().getKeyCode()){
                test.get(j).getKeyCode();
                events3.get(i).getKeys().getKeyCode();
                System.out.println("yes");
            }
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
