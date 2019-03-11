package com.estate.models;


import com.estate.database.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements BaseModel<UserEntity> {
    private String user;
    private String password;

    @Override
    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser(this.user);
        userEntity.setPassword(this.password);
        return userEntity;
    }
}
