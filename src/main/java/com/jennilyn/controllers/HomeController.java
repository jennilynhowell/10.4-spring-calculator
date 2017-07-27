package com.jennilyn.controllers;

import com.jennilyn.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    Calculator calculator = new Calculator();

    @RequestMapping("/")
    public String index(@RequestParam(value = "operand", required=false) String operand,
                        @RequestParam(value = "operand2", required=false) String operand2,
                        @RequestParam(value = "operator", required=false) String operator,
                        Model model)
    {


        try {
            String calcString = operand + "," + operand2 + "," + operator;
            String equation = operand + ", " + operand2 + ", " + operator;
            double result = calculator.calculate(calcString);
            System.out.println("Result: " + result);

            model.addAttribute("equation", equation);
            model.addAttribute("calcResult", result);

        } catch (NumberFormatException ex) {
            String errorMsg = "Sorry, something went wrong.";
            model.addAttribute("calcResult", errorMsg);
            ex.printStackTrace();
        }


        return "index";
    }
}
