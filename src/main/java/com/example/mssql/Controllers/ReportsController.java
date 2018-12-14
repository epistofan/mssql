package com.example.mssql.Controllers;



import com.example.mssql.BL.Solver.IntervalSolver;
import com.example.mssql.BL.Solver.MainSolver;
import com.example.mssql.BL.Solver.Parameters;
import com.example.mssql.BL.Solver.Solver;
import com.example.mssql.DAL.Repository;
import com.example.mssql.domain.OrgUnit;
import com.example.mssql.domain.Person;
import com.example.mssql.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

@Controller
public class ReportsController {



    @Autowired
    Repository repository;

    @Autowired
    Solver solver;
    @Autowired
    Parameters parameters;




    /*@ModelAttribute("keys")
    public void addAttributes(Model model) {
        List<Keys> keys = repositoryImplementation.selectKeys();

        model.addAllAttributes(keys);
    }*/
    @GetMapping("main")
    public String main(Map<String, Object> model) {

    Iterable<Person> person = repository.selectPerson();
    Iterable<OrgUnit> orgUnits = repository.selectOrgUnits();

        IntervalSolver intervalSolver = new IntervalSolver();
        intervalSolver.solve();


    model.put("person", person);
    model.put("orgunits", orgUnits);

        return "main";
    }


    @PostMapping("main")
    public String main(@RequestParam String dateFrom, String dateTill, String time, String personIdList, Map<String, Object> model) throws ParseException {

            parameters.setDateFrom(dateFrom);
            parameters.setDateTill(dateTill);
            parameters.setTime(time);
            parameters.setPersonIdList(personIdList);

            String result = solver.solve(parameters);

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

    @GetMapping("index")
    public String index(){



        return "index";
    }
    @GetMapping("/")
    public String index1(Map<String, Object> model){



        return "index";
    }
    @PostMapping("index")
    public String login1(HttpServletRequest httpRequest, Map<String, Object> model, String username, String password){


        return "index";
    }
    @PostMapping("start")
    public String start(){


        return "start";
    }
    @GetMapping("start")
    public String index1(){


        return "start";
    }
}
