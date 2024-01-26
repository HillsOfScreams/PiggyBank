package com.testing.piggybank;

import com.testing.piggybank.account.AccountResponse;
import com.testing.piggybank.model.Currency;
import com.testing.piggybank.transaction.CreateTransactionRequest;
import com.testing.piggybank.transaction.GetTransactionsResponse;
import com.testing.piggybank.transaction.TransactionResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerApiTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_getAccount_responseOk() {
        ResponseEntity<AccountResponse> response = restTemplate.exchange(
                "/api/v1/accounts/{accountId}",
                HttpMethod.GET,
                null,
                AccountResponse.class,
                2L
        );

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        Assertions.assertEquals(2L, Objects.requireNonNull(response.getBody()).getId());
    }

}
