package com.example.SpringDemo.account.repository.entity;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest //in memory database h2 by default
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    /*1 test case = 1 transaction*/
//    @Ignore
    @Test
    public void createAccountIntoDatabase() {
        //Arrange
        Account account = new Account();
        account.setAccountId("01");
        account.setMobileNo("0824926301");

        //Action
        Account actualAccount = accountRepository.save(account);

        //Assert
        assertNotNull(actualAccount);
        assertTrue(actualAccount.getId() > 0);
        assertEquals("01", actualAccount.getAccountId());
    }

//    @Ignore
    @Test
    public void createAccountIntoDatabase2() {

        // Initial data
        assertEquals(0, accountRepository.count());

        //Insert new account
        Account account = new Account();
        account.setAccountId("01");
        account.setMobileNo("0824926301");
        accountRepository.save(account);

        assertEquals(1, accountRepository.count());
    }
}