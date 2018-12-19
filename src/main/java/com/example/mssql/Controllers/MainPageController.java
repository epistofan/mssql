package com.example.mssql.Controllers;


import com.example.mssql.BL.Factory.ReceivingReturningShop;
import com.example.mssql.domain.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

        HashMap<Integer, Object> result = receivingReturningShop.solve(parameters);

        model.put("result", result.get(9));

        model.put("date", dateFrom);

        return "main";

    }





}
