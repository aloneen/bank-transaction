package com.seisen.bank_transfer.controller;


import com.seisen.bank_transfer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;


    @PostMapping
    public String makeTransaction(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount){
        transactionService.makeTransaction(senderId, receiverId, amount);
        return "Transaction successful";
    }

}
