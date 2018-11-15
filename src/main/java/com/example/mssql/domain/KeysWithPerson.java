package com.example.mssql.domain;

import java.sql.Timestamp;

public class KeysWithPerson {


    private int PersonId;
    private int KeyId;
    private java.sql.Timestamp DateEnd;
    private String KeyCode;


    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getKeyId() {
        return KeyId;
    }

    public void setKeyId(int keyId) {
        KeyId = keyId;
    }

    public Timestamp getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        DateEnd = dateEnd;
    }

    public String getKeyCode() {
        return KeyCode;
    }

    public void setKeyCode(String keyCode) {
        KeyCode = keyCode;
    }
}
