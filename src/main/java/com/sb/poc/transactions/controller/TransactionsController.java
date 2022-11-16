package com.sb.poc.transactions.controller;

import com.sb.poc.transactions.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @GetMapping("/tesTransaction")
    public String testTransaction() throws Exception {
        transactionsService.saveEmployee();
        return "holaMundo";
    }
}
