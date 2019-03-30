package com.estate.models;

import com.estate.database.entities.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements BaseModel<AccountEntity> {

    private String IBAN;
    private String userId;

    @Override
    public AccountEntity toEntity() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setIBAN(this.IBAN);
        accountEntity.setUserId(this.userId);
        return accountEntity;
    }
}
