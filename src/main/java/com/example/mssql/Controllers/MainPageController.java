package com.example.mssql.Controllers;


import com.example.mssql.BL.Factory.ReceivingReturningShop;
import com.example.mssql.domain.EventLog;
import com.example.mssql.domain.Events;
import com.example.mssql.domain.Parameters;
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

        HashMap<Integer, Object> result1 = receivingReturningShop.solve(parameters);

        List<Events> result = new ArrayList<>();

        Events event1 = new Events();
        event1.setDeviceId(333);
        result.add(event1);

        Events event2 = new Events();
        event2.setDeviceId(4444);
        result.add(event2);

        model.put("result", result);

        model.put("date", dateFrom);

        return "main";

    }





}
