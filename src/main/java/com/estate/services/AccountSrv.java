package com.estate.services;

import com.estate.database.entities.AccountEntity;
import com.estate.database.repository.AccountRepository;
import com.estate.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSrv implements BasicService<Account, String> {

    private AccountRepository accountRepository;

    @Autowired
    public AccountSrv(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getById(String id) {
        return accountRepository.findById(id)
                .map(AccountEntity::toModel)
                .orElseThrow(() -> new IllegalArgumentException("Found no elements!!!"));
    }

    @Override
    public Account create(Account target) {
        return accountRepository.save(target.toEntity()).toModel();
    }

    @Override
    public boolean removeById(String id) {
        accountRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean remove(Account target) {
        return false;
    }

    @Override
    public boolean update(Account target) {
        boolean result = false;
        String id = target.getIBAN();
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            accountRepository.save(target.toEntity());
            result = true;
        }
        return result;
    }

    @Override
    public boolean existsById(String id) {
        return accountRepository.existsById(id);
    }
}
