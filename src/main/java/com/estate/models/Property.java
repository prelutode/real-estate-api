package com.estate.models;


import com.estate.database.entities.PropertyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Property implements BaseModel<PropertyEntity> {
    private Short floor;
    private String door;
    private String street;


    @Override
    public PropertyEntity toEntity() {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setFloor(this.floor);
        propertyEntity.setDoor(this.door);
        propertyEntity.setStreet(this.street);
        return propertyEntity;
    }
}
