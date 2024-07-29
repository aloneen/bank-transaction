package com.seisen.bank_transfer.service;


import com.seisen.bank_transfer.entity.Transaction;
import com.seisen.bank_transfer.entity.User;
import com.seisen.bank_transfer.repository.TransactionRepository;
import com.seisen.bank_transfer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;



    public void makeTransaction(Long senderId, Long receiverId, Double amount){
        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);


        Transaction transaction = new Transaction();

        transaction.setSenderId(senderId);
        transaction.setReceiverId(receiverId);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());


        userRepository.save(sender);
        userRepository.save(receiver);
        transactionRepository.save(transaction);


    }






}
