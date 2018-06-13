package com.example.SpringDemo.account.model;

import lombok.Data;

@Data
public class AccountResponse {
    private String accountNo;
    private String name;
    private String accountType;
    private String mobileNo;

    public AccountResponse() {
    }

    public AccountResponse(String accountNo, String name, String accountType, String mobileNo) {
        this.accountNo = accountNo;
        this.name = name;
        this.accountType = accountType;
        this.mobileNo = mobileNo;
    }
}

