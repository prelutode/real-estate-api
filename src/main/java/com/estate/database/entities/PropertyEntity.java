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
    private String door;

    @Override
    public Property toModel() {
        Property property = new Property();
        property.setDoor(this.door);
        return property;
    }
}
