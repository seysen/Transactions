package com.seysen.transactions.controller;

import com.seysen.transactions.model.Transaction;
import com.seysen.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/transaction")
    public Transaction saveTransaction(@RequestParam long sender, @RequestParam long recipient, @RequestParam double amount) {
        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setRecipient(recipient);
        transaction.setAmount(amount);
        return service.save(transaction);
    }

    @GetMapping("/transaction")
    public Transaction getTransaction(@RequestParam long id) {
        Transaction transaction = service.findById(id);
        if (transaction == null) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
        return transaction;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return service.findAll();
    }

    @DeleteMapping("/transaction")
    public void deleteTransaction(@RequestParam long id) {
        service.deleteById(id);
    }
}
