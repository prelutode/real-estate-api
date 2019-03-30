package com.estate.database.repository;

import com.estate.database.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, String> {
}
