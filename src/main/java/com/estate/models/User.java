package com.estate.models;


import com.estate.database.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements BaseModel<UserEntity> {
    private String nif;
    private String name;
    private String username;
    private String password;
    private String email;

    @Override
    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setNif(this.nif);
        userEntity.setName(this.name);
        userEntity.setUsername(this.username);
        userEntity.setPassword(this.password);
        userEntity.setEmail(this.email);
        return userEntity;
    }
}
