package com.example.mssql.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Keys", catalog="DAccess", schema="DBO")
public class Keys {


    public Keys() {
    }


    @Id
    @Column(name="ID")
    private int Id;

    @Column(name="KeyCode", columnDefinition = "char(40)")
    private String KeyCode;

}
