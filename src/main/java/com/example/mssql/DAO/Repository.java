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



        //List events = session.createQuery("select e from EventLog e where e.EventDate = :date and e.KeyCode = :codes order by e.EventTime asc")
       // List events = session.createQuery("select e from EventLog e where e.EventDate = :date ")

           // .setParameter("date", date3)
           // .setParameter("time", time3)
            //.setParameter("codes", codes)
            //.list();



            return null;
    }

    public List<Person> selectPerson () {
       /* SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        List person = session.createQuery("select p from Person p where p.Deleted = 0 ")

                .list();

        session.close();
*/
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

    public List<Events> selectEvents (int id) {
        /*SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

       *//* workHistories = session.createQuery("select w from WorkHistory w left join w.person p where p.PersonId = :id ")
                .setParameter("id", id)
              id  .list();*//*

        workHistories = session.createQuery("select new WorkHistory w left join w.person p where p.PersonId = :id ")
                .setParameter("id", id)
                .list();

        session.close();*/

        //System.out.println(workHistories.get(0).getPerson().getLastName());
        //System.out.println(workHistories.get(0).getKeys().getKeyCode());

        String sql = "SELECT  Person.PersonID, Person.LastName, Person.FirstName, WorkHistory.KeyID, WorkHistory.ID, Keys.KeyCode, EventLog.EventDate, EventLog.EventTime, EventLog.DeviceID FROM WorkHistory JOIN Person ON Person.PersonID=WorkHistory.PersonID JOIN Keys ON WorkHistory.KeyID=Keys.ID JOIN EventLog ON Keys.KeyCode=EventLog.KeyCode where EventDate='2015-01-01' and Person.PersonID='113' order by EventTime";

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
}
