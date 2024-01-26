package Junit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.testing.piggybank.account.*;
import com.testing.piggybank.model.Account;
import com.testing.piggybank.model.Direction;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

public class Junit {

    //getaccounts is van de accountservice
    @Test
    void testGetAccounts() {
        // Mocking dependencies
        AccountService accountServiceMock = mock(AccountService.class);

        // Creating test data
        long userId = 123;
        List<Account> mockAccounts = Arrays.asList(
                new Account(BigDecimal.valueOf(1000.50), "Account1", userId),
                new Account(BigDecimal.valueOf(500.75), "Account2", userId)
        );

        // Setting up the mock behavior
        when(accountServiceMock.getAccountsByUserId(userId)).thenReturn(mockAccounts);

        // Calling the method to test
        List<Account> accountResponses = accountServiceMock.getAccountsByUserId(userId);

        // Verifying the results
        assertNotNull(accountResponses);
        assertEquals(mockAccounts.size(), accountResponses.size());

        // Additional assertions for each account
        for (int i = 0; i < mockAccounts.size(); i++) {
            Account mockAccount = mockAccounts.get(i);
            Account accountResponse = accountResponses.get(i);

            assertEquals(mockAccount.getBalance(), accountResponse.getBalance());
            assertEquals(mockAccount.getName(), accountResponse.getName());
            assertEquals(mockAccount.getId(), accountResponse.getId());
            // Adjust as needed based on your actual model structure
        }
    }





    /* updateBalance is voor service */
    @Test
    void testGetAccount() {
        // Mocking dependencies
        AccountService accountServiceMock = mock(AccountService.class);

        // Creating test data
        long userId = 123;
        Account testAccount = new Account(BigDecimal.valueOf(1000.50), "Account1", userId);

        // Setting up the mock behavior
        when(accountServiceMock.getAccount(userId)).thenReturn(Optional.of(testAccount));

        // Calling the method to test
        Optional<Account> accountResponse = accountServiceMock.getAccount(userId);

        Account responseBody = accountResponse.get();
        assertNotNull(responseBody);

        assertEquals(testAccount.getBalance(), responseBody.getBalance());
        assertEquals(testAccount.getName(), responseBody.getName());
        assertEquals(testAccount.getId(), responseBody.getId());
    }


    /* updateBalance is voor service */
    @Test
    void testUpdateBalance() {
        // Mock dependencies
        AccountRepository accountRepositoryMock = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepositoryMock);

        // Create test data
        long accountId = 1L;
        BigDecimal initialBalance = BigDecimal.valueOf(1000.0);
        BigDecimal amountToAdd = BigDecimal.valueOf(200.0);

        // Mock the behavior of the accountRepository
        Account mockAccount = new Account(initialBalance, "TestAccount", 123L);
        when(accountRepositoryMock.findById(accountId)).thenReturn(Optional.of(mockAccount));

        // Call the method to test
        accountService.updateBalance(accountId, amountToAdd, Direction.CREDIT);

        // Verify the results
        verify(accountRepositoryMock, times(1)).findById(accountId);

        // Assertions
        assertEquals(initialBalance.subtract(amountToAdd), mockAccount.getBalance());
        verify(accountRepositoryMock, times(1)).save(mockAccount);
    }
}
