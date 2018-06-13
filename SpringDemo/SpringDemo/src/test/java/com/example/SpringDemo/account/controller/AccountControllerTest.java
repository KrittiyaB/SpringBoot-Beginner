package com.example.SpringDemo.account.controller;

import com.example.SpringDemo.account.model.AccountResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //integration test//
public class AccountControllerTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    public void findAccountsByMobileNo_Return2Accounts() {
        List<AccountResponse> accountList = restTemplate.getForObject("/account/0824926301", List.class);
        assertEquals(2, accountList.size());
    }
}