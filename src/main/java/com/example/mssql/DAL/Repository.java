package com.example.mssql.DAL;

import com.example.mssql.domain.Events;
import com.example.mssql.domain.OrgUnit;
import com.example.mssql.domain.Person;

import java.sql.Timestamp;
import java.util.List;


public interface Repository {



    public List<Person> selectPerson ();

    public List<Events> selectEvents (Timestamp timestamp);

    public List<OrgUnit> selectOrgUnits ();

}
