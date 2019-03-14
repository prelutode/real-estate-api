package com.estate.services;

import com.estate.models.BaseModel;

public interface BasicService<T extends BaseModel, R> {
    T getById(R id);

    T create(T target);

    boolean removeById(R id);

    boolean remove(T target);

    boolean update(T target);

    boolean existsById(R id);
}
