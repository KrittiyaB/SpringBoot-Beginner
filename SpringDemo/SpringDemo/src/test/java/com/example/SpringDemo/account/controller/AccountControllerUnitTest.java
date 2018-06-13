package com.example.SpringDemo.account.controller;

import com.example.SpringDemo.account.model.AccountResponse;
import com.example.SpringDemo.account.repository.entity.Account;
import com.example.SpringDemo.account.repository.entity.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;
/**
 * if many given then design again
 */

public class AccountControllerUnitTest {

    private AccountController accountController;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void init() {
        initMocks(this);
        // init -- (1)
        accountController = new AccountController();
        accountController.setAccountRepository(accountRepository);
    }

    @Test
    public void size_of_account_should_be_2() {
        /*Arrange*/
        List<Account> dataForTest = new ArrayList<>();
        dataForTest.add(new Account("T01"));
        dataForTest.add(new Account("T02"));
        given(accountRepository.findAll()).willReturn(dataForTest);

        /*Act | When*/
        List<AccountResponse> responses = accountController.getAccounts("0824926301");

        /*Assertion | Then*/
        assertEquals("Size of result must be 2 ", 2, responses.size());
    }

    @Test
    public void should_throw_exception() {
        /*Arrange*/
        given(accountRepository.findAll()).willReturn(null);

        /*Act | When*/
        List<AccountResponse> responses = accountController.getAccounts("0824926301");

        /*Assertion | Then*/
        assertEquals("Size of result must be 0 ", 0, responses.size());
    }
}