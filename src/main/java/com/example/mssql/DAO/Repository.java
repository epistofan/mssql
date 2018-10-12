package com.example.mssql.DAO;

import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Keys;
import com.example.mssql.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

import java.sql.Timestamp;

import java.util.List;

@Component
public class Repository {

    @Autowired
    EntityManagerFactory entityManagerFactory;
    private List<Keys> keys;


    public List<EventLog> select(Timestamp date3, Timestamp time3, String codes){
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
       Session session = sessionFactory.openSession();



            //List events = session.createQuery("select e from EventLog e where e.EventDate = :date and e.KeyCode = :codes order by e.EventTime asc")
        List events = session.createQuery("select e from EventLog e where e.EventDate = :date")

            .setParameter("date", date3)
           // .setParameter("time", time3)
            //.setParameter("codes", codes)
            .list();

            session.close();

            return events;
    }

    public List<Person> selectPerson () {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        List person = session.createQuery("select p from Person p where p.Deleted = 0 ")

                .list();

        session.close();



        return person;
    }

}
