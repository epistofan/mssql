package com.example.mssql.BL.DataPrep;

import com.example.mssql.domain.Events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetConverter {


    private int i = 0;
    private List<Events> events  = new ArrayList();
   public List<Events> convert (ResultSet resultSet) throws SQLException {


       while (resultSet.next()) {

           //System.out.println(resultSet.getString("LastName"));
           Events event = new Events();
           event.setPersonId(resultSet.getInt(2));
           event.setEventDate(resultSet.getTimestamp(6));
           event.setEventTime(resultSet.getTimestamp(5));
           event.setDeviceId(resultSet.getInt(7));


           events.add(i, event);
           i++;


       }
       return events;
   }








}
