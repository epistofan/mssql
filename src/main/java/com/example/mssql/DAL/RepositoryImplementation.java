package com.example.mssql.DAL;

import com.example.mssql.BL.DataPrep.ResultSetConverter;
import com.example.mssql.domain.*;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "prototype")
public class RepositoryImplementation implements Repository {

            ResultSet resultSet = null;
            Statement statement = null;
            PreparedStatement preparedStatement = null;
            java.sql.Connection conn = null;
            DbConnection dbConnection  = new DbConnection ();

            private List<EventLog> events  = new ArrayList();
            private List<Keys> keys = new ArrayList<>();
            List<WorkHistory> workHistories = new ArrayList<>();


    @Override
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

    @Override
    public List<EventLog> selectEvents (Timestamp timestamp) {

        String sql = "Select* from Eventlog where EventDate = ? ORDER BY EventLog.EventTime";
        DateTime date = new DateTime("2015-01-30");
        java.sql.Timestamp timestamp1 = Timestamp.valueOf("2015-01-01 00:00:00");


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


    @Override
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

    @Override
    public List<Keys> selectKeys(int keyId) {

        String sqlStat = "select* from Keys where ID=?";

        List<Keys> keys  = new ArrayList();
        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sqlStat);
            preparedStatement.setInt(1, keyId);
            resultSet = preparedStatement.executeQuery();


        }  catch (SQLException e) {
        e.printStackTrace();
    }
    try{
            int i = 0;
            while (resultSet.next()) {

                Keys key = new Keys();
                key.setId(resultSet.getInt(1));
                key.setKeyCode(resultSet.getString(2));

                keys.add(i, key);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return keys;


    }

    @Override
    public List<WorkHistory> selectWorkHistory() {
        String sqlStat = "select* from Keys where ID=?";

        List<WorkHistory> workHistories  = new ArrayList();
        try {
            conn = dbConnection.getDbConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlStat);
            int i = 0;
            while (resultSet.next()) {

                WorkHistory workHistory = new WorkHistory();
                workHistory.setPersonId(resultSet.getInt(2));
                workHistory.setKeyId(resultSet.getInt(4));
                workHistory.setDateEnd(resultSet.getTimestamp(6));
                workHistories.add(i, workHistory);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return workHistories;

    }


    @Override
    public List<KeysWithPerson> selectKeysWithPerson(Timestamp dateFromInTimestamp) {

        String sqlStat = "SELECT WorkHistory.PersonID, WorkHistory.KeyID, WorkHistory.Date_End, Keys.KeyCode " +
                "FROM WorkHistory INNER JOIN " +
                "Keys ON WorkHistory.KeyID = Keys.ID " +
                "WHERE(WorkHistory.KeyID <> 1) AND (WorkHistory.Date_End > ?)";

        List<KeysWithPerson> keysWithPerson  = new ArrayList();
        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sqlStat);
            preparedStatement.setTimestamp(1, dateFromInTimestamp);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                KeysWithPerson keysWithPerson1 = new KeysWithPerson();
                keysWithPerson1.setPersonId(resultSet.getInt(1));
                keysWithPerson1.setKeyId(resultSet.getInt(2));
                keysWithPerson1.setDateEnd(resultSet.getTimestamp(3));
                keysWithPerson1.setKeyCode(resultSet.getString(4));
                keysWithPerson.add(i, keysWithPerson1);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return keysWithPerson;
    }
}
