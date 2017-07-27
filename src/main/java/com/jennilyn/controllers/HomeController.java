package com.jennilyn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(@RequestParam(value = "operand", required=false) String operand,
                        @RequestParam(value = "operand2", required=false) String operand2,
                        @RequestParam(value = "operator", required=false) String operator)
    {
        System.out.println(operand);
        System.out.println(operand2);
        System.out.println(operator);

        return "index";
    }
}
