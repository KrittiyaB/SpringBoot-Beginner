package com.example.SpringDemo.account.controller;

import com.example.SpringDemo.account.model.AccountResponse;
import com.example.SpringDemo.account.repository.entity.Account;
import com.example.SpringDemo.account.repository.entity.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //add servlet define class -> restful
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{mobileNo}")
    public List<AccountResponse> getAccounts(@PathVariable String mobileNo) {
        Iterable<Account> accounts = accountRepository.findAll();
        if (accounts == null) {
            accounts = new ArrayList<>();
        }

        //Convert from Account to AccountResponse
        List<AccountResponse> foundAccountResponse = new ArrayList<>();

        for (Account account : accounts) {
            foundAccountResponse.add(
                    new AccountResponse(account.getAccountId(), account.getMobileNo(), account.getAccountType(), account.getMobileNo()));
        }
        return foundAccountResponse;
    }

   /* @PostConstruct
    public void initData(){
        Account account1 = new Account();
        account1.setAccountId("01");
        Account account2 = new Account();
        account2.setAccountId("02");
        accountRepository.save(account1);
        accountRepository.save(account2);
    }*/
}
