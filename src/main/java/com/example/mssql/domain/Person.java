package com.example.mssql.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Person", catalog="DAccess", schema="DBO")
public class Person {

    public Person() {
    }

    @Id
    @Column(name="PersonID")
    private int PersonId;




    @Column(name = "Deleted")
    private boolean Deleted;

    @Column(name = "LastName", columnDefinition = "varchar(50)")
    private String LastName;

    @Column(name = "FirstName", columnDefinition = "varchar(50)")
    private String FirstName;



    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public boolean isDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
        Deleted = deleted;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }


}
