package com.estate.services;

import com.estate.models.BaseModel;

public interface BasicService<T extends BaseModel> {
    T getById(String id);

    T create(T target);

    boolean removeById(String id);

    int remove(T target);

    boolean update(T target);

    boolean existsById(String id);
}
