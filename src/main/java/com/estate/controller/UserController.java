package com.estate.controller;

import com.estate.models.User;
import com.estate.services.UserSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    private UserSrv userSrv;

    @Autowired
    public UserController(UserSrv userSrv) {
        this.userSrv = userSrv;
    }

    /**
     * POST method used to insert given user in database.
     * Url: .../user/create
     *
     * @param user intended to be persisted in database.
     * @return the user actually persisted.
     */
    @PostMapping(value = "/create",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userSrv.create(user);
        ResponseEntity<User> result = new ResponseEntity<>(savedUser, HttpStatus.OK);
        log.info("Saved user: {}", savedUser.getNIF());
        return result;
    }

    /**
     * Searches for user whose username is the id provided, and returns it.
     *
     * @param id string represeting username.
     * @return user represented by given id.
     */
    @GetMapping(value = "/{id}",
            produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userSrv.getById(id);
        log.info("Retrieved user: {}", user.getNIF());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
