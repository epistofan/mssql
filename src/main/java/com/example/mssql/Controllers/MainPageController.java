package com.example.mssql.Controllers;


import com.example.mssql.BL.Factory.ReceivingReturningShop;
import com.example.mssql.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.*;

@Controller
public class MainPageController {


    @Autowired
    ReceivingReturningShop receivingReturningShop;
    @Autowired
    Parameters parameters;

    @PostMapping("main")
    public String main(@RequestParam String dateFrom, String dateTill, String time, String personIdList, Map<String, Object> model) throws ParseException {

        parameters.setDateFrom(dateFrom);
        parameters.setDateTill(dateTill);
        parameters.setTime(time);
        parameters.setPersonIdList(personIdList);

        List<PersonsWithTime> result = receivingReturningShop.solve(parameters);

        List<TestClass> results = new ArrayList<>();
        TestClass testClass = new TestClass();
        testClass.setResult(result);
        testClass.setDateTime("01.01.2015");

        TestClass testClass1 = new TestClass();
        testClass1.setResult(result);
        testClass1.setDateTime("02.01.2015");

        results.add(testClass);
        results.add(testClass1);

        model.put("result", results);

        model.put("date", dateFrom);

        return "main";

    }





}
