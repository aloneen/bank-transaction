package com.seisen.bank_transfer.repository;

import com.seisen.bank_transfer.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
