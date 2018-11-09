package com.example.mssql.DAO;

import com.example.mssql.BL.DbConnection;
import com.example.mssql.BL.ResultSetConverter;
import com.example.mssql.domain.*;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class Repository {

            ResultSet resultSet = null;
            Statement statement = null;
            PreparedStatement preparedStatement = null;
            java.sql.Connection conn = null;
            DbConnection dbConnection  = new DbConnection ();

            private List<Events> events  = new ArrayList();
            private List<Keys> keys = new ArrayList<>();
            List<WorkHistory> workHistories = new ArrayList<>();

    public List<EventLog> select(Timestamp date3, Timestamp time3){

            return null;
    }

    public List<Person> selectPerson () {

            String sqlStat = "select* from Person where Deleted=0";

            List<Person> rperson  = new ArrayList();
        try {
            conn = dbConnection.getDbConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlStat);
                int i = 0;
            while (resultSet.next()) {

                System.out.println(resultSet.getString("LastName"));
                Person person = new Person();
                person.setPersonId(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(7));
                person.setLastName(resultSet.getString(6));
                person.setDeleted(resultSet.getBoolean(10));


                rperson.add(i, person);
               i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("cant connect to db");
        }


        return rperson;
    }

    public List<Events> selectEvents (Timestamp timestamp) {

        /*String sql = "SELECT WorkHistory.KeyID, WorkHistory.PersonID, WorkHistory.Date_End, EventLog.KeyCode, EventLog.EventTime, EventLog.EventDate, EventLog.DeviceID, "
                + "Device.DeviceName "
                +"FROM WorkHistory INNER JOIN "
                +"Person ON WorkHistory.PersonID = Person.PersonID INNER JOIN "
                +"Keys ON WorkHistory.KeyID = Keys.ID INNER JOIN "
                +"EventLog ON Keys.KeyCode = EventLog.KeyCode INNER JOIN "
                +"Device ON EventLog.DeviceID = Device.DeviceID "
                +"WHERE (Person.PersonID = 99) AND (WorkHistory.KeyID <> 1) AND (WorkHistory.Date_End > '2015-01-01') AND (EventLog.EventDate = CONVERT(DATETIME, "
                +"'2015-01-01 00:00:00', 102)) "
                +"ORDER BY EventLog.EventTime";
*/
        String sql = "Select* from Eventlog where EventDate = ? ORDER BY EventLog.EventTime";
        DateTime date = new DateTime("2015-01-30");
        Timestamp timestamp1 = Timestamp.valueOf("2015-01-01 00:00:00");


        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setTimestamp(1, timestamp1);
            resultSet = preparedStatement.executeQuery();

            ResultSetConverter resultSetConverter = new ResultSetConverter();
            events = resultSetConverter.convert(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }



    public List<OrgUnit> selectOrgUnits () {

        String sqlStat = "select* from OrgUnit where Deleted=0";

        List<OrgUnit> orgUnits  = new ArrayList();
        try {
            conn = dbConnection.getDbConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlStat);
            int i = 0;
            while (resultSet.next()) {

                OrgUnit orgUnit = new OrgUnit();
                orgUnit.setOrgUnitId(resultSet.getInt(1));
                orgUnit.setParentOrgUnitId(resultSet.getInt(2));
                orgUnit.setOrgUnitName(resultSet.getString(3));
                orgUnit.setDeleted(resultSet.getBoolean(4));


                orgUnits.add(i, orgUnit);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return orgUnits;
    }
}
