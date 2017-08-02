package com.jennilyn.controllers;

import com.jennilyn.Calculator;
import com.jennilyn.interfaces.OperationRepository;
import com.jennilyn.interfaces.UserRepository;
import com.jennilyn.models.CalcUser;
import com.jennilyn.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    OperationRepository opRepo;

    Calculator calculator = new Calculator();

    @RequestMapping("/")
    public String index (Model model){
        Iterable<Operation> operations = opRepo.findAll();
        model.addAttribute("operations", operations);
        return "index";
    }

    @RequestMapping(value = "/submitName", method = RequestMethod.POST)
    public String submitName(@RequestParam("user") String user){
        CalcUser newUser = new CalcUser(user);
        userRepo.save(newUser);
        long id = newUser.getId();
        return "redirect:/calculate/" + id;
    }

    @RequestMapping("/calculate/{userId}")
    public String calculate(@PathVariable("userId") long userId, Model model){
        CalcUser user = userRepo.findOne(userId);
        model.addAttribute("user", user);
        return "calculate";
    }

    @RequestMapping(value = "/calculate/{userId}", method = RequestMethod.POST)
    public String calculateSubmit(@PathVariable("userId") long userId,
                        @RequestParam("operand") String operand,
                        @RequestParam("operand2") String operand2,
                        @RequestParam("operator") String operator,
                        Model model)
    {
        String equation = "";
        double operandD = Double.parseDouble(operand);
        double operand2D = Double.parseDouble(operand2);
        double result = 0.0;

        try {
            String calcString = operand + "," + operand2 + "," + operator;
            equation = operand + ", " + operand2 + ", " + operator;
            result = calculator.calculate(calcString);

        } catch (NumberFormatException ex) {
            equation = "Sorry, something went wrong.";

        } finally {
            CalcUser user = userRepo.findOne(userId);
            Operation newOperation = new Operation(operandD, operand2D, result, operator, user);
            opRepo.save(newOperation);

            model.addAttribute("equation", equation);
            model.addAttribute("calcResult", result);

            return "redirect:/calculate/" + userId;
        }


    }
}
