package com.estate.services;


import com.estate.database.entities.PropertyEntity;
import com.estate.database.repository.PropertyRepository;
import com.estate.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertySrv implements BasicService<Property, Long> {
    private PropertyRepository propertyRepository;

    @Autowired
    public PropertySrv(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property getById(Long id) {
        return propertyRepository
                .findById(id)
                .map(PropertyEntity::toModel)
                .orElseThrow(() -> new IllegalArgumentException("Found no elements!!!"));
    }

    @Override
    public Property create(Property target) {
        return propertyRepository.save(target.toEntity()).toModel();
    }

    @Override
    public boolean removeById(Long id) {
        propertyRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean remove(Property target) {
        //TODO -> Implement a process able to filter anything matching non null values from object
        return true;
    }

    @Override
    public boolean update(Property target) {
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return propertyRepository.existsById(id);
    }
}
