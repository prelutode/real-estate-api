package com.estate.models;


import com.estate.database.entities.PropertyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Property implements BaseModel<PropertyEntity> {
    private String door;

    @Override
    public PropertyEntity toEntity() {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setDoor(this.door);
        return propertyEntity;
    }
}
