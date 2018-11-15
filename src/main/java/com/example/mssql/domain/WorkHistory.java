package com.example.mssql.domain;





import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class WorkHistory {


    public WorkHistory() {
    }


    private int Id ;



    private int personId;

    private int keyId;

    private Timestamp dateEnd;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }
}
