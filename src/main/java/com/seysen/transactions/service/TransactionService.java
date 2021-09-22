package com.seysen.transactions.service;

import com.seysen.transactions.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);
    Transaction findById(long id);
    List<Transaction> findAll();
    void deleteById(long id);
}
