package com.estate.database.entities;


import com.estate.models.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Property")
@NoArgsConstructor
@AllArgsConstructor
public class PropertyEntity implements BaseEntity<Property> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Short floor;
    private String door;
    private String street;

    @Override
    public Property toModel() {
        Property property = new Property();
        property.setFloor(this.floor);
        property.setDoor(this.door);
        property.setStreet(this.street);
        return property;
    }
}
