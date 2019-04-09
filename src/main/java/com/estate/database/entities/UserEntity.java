package com.estate.database.entities;

import com.estate.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements BaseEntity<User> {
    @Id
    private String nif;
    private String name;
    private String username;
    private String password;
    private String email;

    @Override
    public User toModel() {
        User user = new User();
        user.setNif(this.nif);
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        return user;
    }
}
