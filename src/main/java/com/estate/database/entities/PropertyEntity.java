package com.estate.database.entities;


import com.estate.database.entities.utils.PropertyId;
import com.estate.models.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Property")
@NoArgsConstructor
@AllArgsConstructor
public class PropertyEntity implements BaseEntity<Property> {
    @EmbeddedId
    private PropertyId id;

    public Short getDoor() {
        return this.id.getDoor();
    }

    public void setDoor(Short door) {
        this.id.setDoor(door);
    }

    public Short getFloor() {
        return this.id.getFloor();
    }

    public void setFloor(Short floor) {
        this.id.setFloor(floor);
    }


    @Override
    public Property toModel() {
        Property property = new Property();
        property.setDoor(this.id.getDoor());
        return property;
    }
}