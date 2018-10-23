package com.example.mssql.domain;





import java.util.ArrayList;
import java.util.List;


public class WorkHistory {


    public WorkHistory() {
    }


    private int Id ;



    private Person person;



    private Keys keys;



    public Keys getKeys() {
        return keys;
    }

    public void setKeys(Keys keys) {
        this.keys = keys;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
