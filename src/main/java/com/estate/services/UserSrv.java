package com.estate.services;

import com.estate.database.entities.UserEntity;
import com.estate.database.repository.UserRepository;
import com.estate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSrv implements BasicService<User> {
    private UserRepository userRepository;

    @Autowired
    public UserSrv(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(String id) {
        return userRepository
                .findById(id)
                .map(UserEntity::toModel)
                .orElseThrow(() -> new IllegalArgumentException("Found no elements!!!"));
    }

    @Override
    public User create(User target) {
        return userRepository.save(target.toEntity()).toModel();
    }

    @Override
    public boolean removeById(String id) {
        userRepository.deleteById(id);
        return existsById(id);
    }

    @Override
    public int remove(User target) {
        //TODO -> Implement a process able to filter anything matching non null values from object
        return 0;
    }

    @Override
    public boolean update(User target) {
        String id = target.getUser();
        boolean result = true;
        if (existsById(id)) {
            result = removeById(id);
        }
        return result;
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
