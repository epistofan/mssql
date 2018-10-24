package com.example.mssql.DAO;

import com.example.mssql.BL.DbConnection;
import com.example.mssql.domain.*;

import org.springframework.stereotype.Component;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

            ResultSet resultSet = null;
            Statement statement = null;
            java.sql.Connection conn = null;
            DbConnection dbConnection  = new DbConnection ();

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
        }


        return rperson;
    }

    public List<Events> selectEvents () {

        String sql = "SELECT  Person.PersonID, Person.LastName, Person.FirstName, WorkHistory.KeyID, WorkHistory.ID, Keys.KeyCode, EventLog.EventDate, EventLog.EventTime, EventLog.DeviceID FROM WorkHistory JOIN Person ON Person.PersonID=WorkHistory.PersonID JOIN Keys ON WorkHistory.KeyID=Keys.ID JOIN EventLog ON Keys.KeyCode=EventLog.KeyCode where EventDate='2015-01-01' order by EventTime";

        List<Events> events  = new ArrayList();
        try {
            conn = dbConnection.getDbConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            int i = 0;
            while (resultSet.next()) {

                System.out.println(resultSet.getString("LastName"));
                Events event = new Events();
                event.setPersonId(resultSet.getInt(1));
                event.setEventDate(resultSet.getTimestamp(7));
                event.setEventTime(resultSet.getTimestamp(8));
                event.setDeviceId(resultSet.getInt(9));


                events.add(i, event);
                i++;
            }
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
