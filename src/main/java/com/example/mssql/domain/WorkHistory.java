package com.example.mssql.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="WorkHistory", catalog="DAccess", schema="DBO")
public class WorkHistory {


    public WorkHistory() {
    }


    @Id
    @Column(name="ID")
    private int Id ;


    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "PersonID")
    private Person person;


    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "KeyID")
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
