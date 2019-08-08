package edu.mum.cs.cs425.banking.bankingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/banking", "/banking/home"})
    public String home() {
        return "home/index";
    }
}
