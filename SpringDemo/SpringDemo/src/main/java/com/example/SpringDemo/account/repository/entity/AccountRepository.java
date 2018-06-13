package com.example.SpringDemo.account.repository.entity;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    /* CrudRepository
     * id is integer
     * select * from Account where id
     * */
}
