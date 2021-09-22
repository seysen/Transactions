package com.seysen.transactions.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions")
@NoArgsConstructor
@Setter
@Transactional
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long sender;
    private long recipient;
    private double amount;
}
