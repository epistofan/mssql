package com.example.mssql.BL.DataPrep;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonListPrepare {



    public List<String> convert (String PersonIdList){

            List listOfUserId = new ArrayList(Arrays.asList(PersonIdList.split(",")));

        return listOfUserId;
    }

}
