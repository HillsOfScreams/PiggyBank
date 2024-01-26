package com.testing.piggybank;

import com.testing.piggybank.model.Currency;
import com.testing.piggybank.model.Transaction;
import com.testing.piggybank.transaction.CreateTransactionRequest;
import com.testing.piggybank.transaction.TransactionController;
import com.testing.piggybank.transaction.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TransactionTests {

    @Autowired
    private TransactionController transactionController;

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    void beforeEach() {
        transactionRepository.deleteAll();
    }

    @Test
    void createTransaction_storesTransactionInDatabase() {
        CreateTransactionRequest request = new CreateTransactionRequest();
        request.setCurrency(Currency.EURO);
        request.setRecieverAccountId(1L);
        request.setSenderAccountId(2L);
        request.setDescription("integration test transaction");
        request.setAmount(new BigDecimal(50));

        transactionController.createTransaction(request);

        List<Transaction> result = transactionRepository.findByReceiverAccountId(1);
        Assertions.assertEquals(1, result.size());
    }
}