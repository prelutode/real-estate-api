package com.estate.models;

import com.estate.database.entities.BaseEntity;

public interface BaseModel<T extends BaseEntity> {

    /**
     * This method is implemented by all entities in the projects. It let us convert from the Entity to a Model.
     * Entity -> Object that represent a database table, only used to access the database.
     * Model -> Object that is used by the application.
     *
     * @return Given entity as application model
     */
    T toEntity();
}
