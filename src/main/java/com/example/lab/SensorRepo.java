package com.example.lab;

import org.springframework.data.repository.CrudRepository;

public interface SensorRepo extends CrudRepository<SensorEntity,Long> {
}
