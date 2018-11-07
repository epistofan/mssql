package com.example.mssql.BL.Solver;

import com.example.mssql.DAO.Repository;
import com.example.mssql.domain.Events;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sorting {

    private int i = 0;
    private int j = 0;


    Stack<Events> stack = new Stack<>();
    Stack<Object> sorted = new Stack<>();

   public void sort(List<Events> eventsOfOneDay, List<String> userId) {


       for (j = 0; j < userId.size(); j++) {

           for (i = 0; i < eventsOfOneDay.size(); i++) {

               int a = eventsOfOneDay.get(i).getPersonId();
               int b = Integer.parseInt(userId.get(j));
               if (a == b) {
                   stack.push(eventsOfOneDay.get(i));
               }


           }
if (stack.isEmpty()){
    System.out.println("empty");
}else{
    sorted.push(stack);
}


       }
   }
}
