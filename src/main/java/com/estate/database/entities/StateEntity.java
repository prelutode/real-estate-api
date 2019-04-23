package com.estate.database.entities;

import com.estate.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateEntity implements BaseEntity<State> {
    @Id
    private long id;
    private String address;

    @Override
    public State toModel() {
        State state = new State();
        state.setId(this.id);
        state.setAddress(this.address);
        return null;
    }

}
