package com.estate.controller;



import com.estate.models.Property;
import com.estate.services.PropertySrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("property")
public class PropertyController {
    private PropertySrv propertySrv;

    @Autowired
    public PropertyController(PropertySrv propertySrv) {
        this.propertySrv = propertySrv;
    }

    /**
     * POST method used to insert given property in database.
     * Url: .../property/create
     *
     * @param property intended to be persisted in database.
     * @return the property actually persisted.
     */
    @PostMapping(value = "/create",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property propertySaved = propertySrv.create(property);
        ResponseEntity<Property> result = new ResponseEntity<>(property, HttpStatus.OK);
        log.info("Saved property: {}", property);
        return result;
    }

    /**
     * Searches for property whose username is the id provided, and returns it.
     *
     * @param id string representing id.
     * @return user represented by given id.
     */
    @GetMapping(value = "/{id}",
            produces = "application/json")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertySrv.getById(id);
        log.info("Retrieved property: {}", id);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",
            produces = "application/json")
    public ResponseEntity<Boolean> deletePropertyById(@PathVariable Long id) {
        Boolean exists = propertySrv.removeById(id);
        log.info("Removed property: {}", id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
