package com.estate.database.entities.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PropertyId implements Serializable {
    @Column
    private Short floor;
    @Column
    private Short door;
}
