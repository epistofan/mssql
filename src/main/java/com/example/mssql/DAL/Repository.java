package com.example.mssql.DAL;

import com.example.mssql.domain.*;

import java.sql.Timestamp;
import java.util.List;


public interface Repository {



    public List<Person> selectPerson ();

    public List<EventLog> selectEvents (Timestamp timestamp);

    public List<OrgUnit> selectOrgUnits ();

    public List<Keys> selectKeys (int keyId);

    public List<WorkHistory> selectWorkHistory ();

    public List<KeysWithPerson> selectKeysWithPerson(Timestamp dateFrom);
}
