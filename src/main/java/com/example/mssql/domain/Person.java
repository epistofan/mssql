package com.example.mssql.domain;





import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Person {

    public Person() {
    }


    private int PersonId;




    private boolean Deleted;


    private String LastName;


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
