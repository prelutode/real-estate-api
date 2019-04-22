package com.estate.controller;

import com.estate.models.Account;
import com.estate.services.AccountSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("account")
public class AccountController {

    private AccountSrv accountSrv;

    @Autowired
    public AccountController(AccountSrv accountSrv) {
        this.accountSrv = accountSrv;
    }

    /**
     * POST method used to insert given account in database.
     * Url: .../account/create
     *
     * @param account intended to be persisted in database.
     * @return the account actually persisted.
     */
    @PostMapping(value = "/create",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Account> createProperty(@RequestBody Account account) {
        Account accountSaved = accountSrv.create(account);
        ResponseEntity<Account> result = new ResponseEntity<>(account, HttpStatus.OK);
        log.info("Saved account: {}", account);
        return result;
    }

    /**
     * Searches for account whose username is the id provided, and returns it.
     *
     * @param id string representing retrieved account.
     * @return account represented by given id.
     */
    @GetMapping(value = "/{id}",
            produces = "application/json")
    public ResponseEntity<Account> getPropertyById(@PathVariable String id) {
        Account account = accountSrv.getById(id);
        log.info("Retrieved account: {}", id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    /**
     * Removes the account represented by the given id.
     *
     * @param id string identifying the account to be removed.
     * @return true if it the account has been removed, false otherwise.
     */
    @DeleteMapping(value = "/{id}",
            produces = "application/json")
    public ResponseEntity<Boolean> deletePropertyById(@PathVariable String id) {
        Boolean exists = accountSrv.removeById(id);
        log.info("Removed account: {}", id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
