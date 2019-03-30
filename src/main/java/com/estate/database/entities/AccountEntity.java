package com.estate.database.entities;

import com.estate.models.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity implements BaseEntity<Account> {

    private String IBAN;
    private String userId;

    @Override
    public Account toModel() {
        Account account = new Account();
        account.setIBAN(this.IBAN);
        account.setUserId(this.userId);
        return null;
    }
}
