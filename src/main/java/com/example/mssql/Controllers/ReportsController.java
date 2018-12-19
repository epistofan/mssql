package com.example.mssql.Controllers;



import com.example.mssql.domain.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ReportsController {


    /*@ModelAttribute("keys")
    public void addAttributes(Model model) {
        List<Keys> keys = repositoryImplementation.selectKeys();

        model.addAllAttributes(keys);
    }*/


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
