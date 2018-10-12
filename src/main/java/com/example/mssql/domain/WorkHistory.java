package com.example.mssql.domain;


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


    @Column(name="PersonID")
    private int PersonId;


}
