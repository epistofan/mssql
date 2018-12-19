package com.example.mssql.Controllers;


import com.example.mssql.BL.Factory.IntervalSolver;
import com.example.mssql.DAL.Repository;
import com.example.mssql.domain.OrgUnit;
import com.example.mssql.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class StartPageController {


    @Autowired
    Repository repository;

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





}
