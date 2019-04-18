package com.estate.services;

import com.estate.CRUD.State;
import com.estate.database.repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class StateSrv implements BasicService<State, String> {

    private StateRepository stateRepository;

    @Override
    public State getById(String id) {
        return null;
    }

    @Override
    public State create(State target) {
        return null;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    @Override
    public boolean remove(State target) {
        return false;
    }

    @Override
    public boolean update(State target) {
        return false;
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }
}
