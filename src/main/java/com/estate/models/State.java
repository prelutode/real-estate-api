package com.estate.models;


import com.estate.database.entities.StateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class State implements BaseModel<StateEntity> {
    private long id;
    private String address;

    @Override
    public StateEntity toEntity() {
        StateEntity stateEntity = new StateEntity();
        stateEntity.setId(this.id);
        stateEntity.setAddress(this.address);
        return stateEntity;
    }
}