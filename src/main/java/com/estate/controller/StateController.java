package com.estate.controller;

import com.estate.models.State;
import com.estate.services.StateSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("state")
public class StateController {

    private StateSrv stateSrv;

    @Autowired
    public StateController(StateSrv stateSrv) {
        this.stateSrv = stateSrv;
    }


    @PostMapping(value = "/create",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<State> createState(@RequestBody State state) {
        State stateSaved = this.stateSrv.create(state);
        return null;
    }

    @GetMapping(value = "/{id}",
            produces = "application/json")
    public ResponseEntity<State> getStateById(@PathVariable String id) {
        State state = this.stateSrv.getById(id);
        log.info("Retrieved State: {}", id);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

}
