package com.example.mssql.BL;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonListPrepare {



    public List<String> convert (String PersonIdList){

            ArrayList listOfCodes = new ArrayList(Arrays.asList(PersonIdList.split(",")));

        return listOfCodes;
    }

}
