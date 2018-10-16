package com.example.mssql.Controllers;



import com.example.mssql.BL.MainSolver;
import com.example.mssql.BL.PersonListPrepare;
import com.example.mssql.DAO.Repository;
import com.example.mssql.BL.DateTimeConverter;
import com.example.mssql.BL.TimeByDaySolver;
import com.example.mssql.TransactionLogRepository;
import com.example.mssql.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@Controller
public class ReportsController {


    @Autowired
    Repository repository;

    @Autowired
    MainSolver mainSolver;





    /*@ModelAttribute("keys")
    public void addAttributes(Model model) {
        List<Keys> keys = repository.selectKeys();

        model.addAllAttributes(keys);
    }*/
    @GetMapping("/main")
    public String main(Map<String, Object> model) {

    Iterable<Person> person = repository.selectPerson();

    repository.selectWorkHistory(14);
    model.put("person", person);
        return "main";
    }


    @PostMapping("main")
    public String main(@RequestParam String date, String time, String personIdList, Map<String, Object> model) throws ParseException {



            String result = mainSolver.solve(date, time, personIdList);

            model.put("all", result);

            model.put("dayNumber", date);
            return "main";

    }


    @GetMapping("calculator")
    public String calc(Map<String, Object> model){
        String result = "Answer";
        model.put("ravno", result );

        return "calculator";
    }

}
