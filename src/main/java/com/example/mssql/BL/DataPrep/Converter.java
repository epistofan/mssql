package com.example.mssql.BL.DataPrep;

import java.sql.Timestamp;
import java.text.ParseException;

public interface Converter {


    public Timestamp convertDate(String dateFrom);

    public Timestamp convertTime(String time);

}
