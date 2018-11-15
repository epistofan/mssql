package com.example.mssql.BL.DataPrep;

import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetConverter {


    private int i = 0;
    private List<EventLog> events  = new ArrayList();

   public List<EventLog> convert (ResultSet resultSet) throws SQLException {


       while (resultSet.next()) {

           //System.out.println(resultSet.getString("LastName"));
           EventLog event = new EventLog();
           //event.setPersonId(resultSet.getInt(2));
           event.setEventDate(resultSet.getTimestamp(2));
           event.setEventTime(resultSet.getTimestamp(3));
           event.setDeviceId(resultSet.getInt(6));
           event.setKeyCode(resultSet.getString(7));


           events.add(i, event);
           i++;


       }
       return events;
   }








}
