package com.example.SpringDemo.account.controller;

import com.example.SpringDemo.account.model.AccountResponse;
import com.example.SpringDemo.account.repository.entity.Account;
import com.example.SpringDemo.account.repository.entity.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerAndMockTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void findAccountsByMobileNo_Return2Accounts() {
        /*Arrange*/
        List<Account> dataForTest = new ArrayList<>();
        dataForTest.add(new Account("T01"));
        dataForTest.add(new Account("T02"));
        dataForTest.add(new Account("T03"));

        given(accountRepository.findAll()).willReturn(dataForTest);

        /*Act*/
        List<AccountResponse> accountList = testRestTemplate.getForObject("/account/0824926301", List.class);

        /*Assert*/
        assertEquals(3, accountList.size());
    }


}