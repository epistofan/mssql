package com.example.mssql.Controllers;



import com.example.mssql.BL.IntervalSolver;
import com.example.mssql.BL.Solver.MainSolver;
import com.example.mssql.DAO.Repository;
import com.example.mssql.domain.OrgUnit;
import com.example.mssql.domain.Person;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
IntervalSolver intervalSolver = new IntervalSolver();
intervalSolver.solve();
    Iterable<OrgUnit> orgUnits = repository.selectOrgUnits();

    //repository.selectWorkHistory(14);
    model.put("person", person);
    model.put("orgunits", orgUnits);

        return "main";
    }


    @PostMapping("main")
    public String main(@RequestParam String dateFrom, String dateTill, String time, String personIdList, Map<String, Object> model) throws ParseException {



            String result = mainSolver.solve(dateFrom, time, personIdList);

            model.put("all", result);

            model.put("dayNumber", dateFrom);
            return "main";

    }


    @GetMapping("calculator")
    public String calc(Map<String, Object> model){
        String result = "Answer";
        model.put("ravno", result );

        return "calculator";
    }

}
