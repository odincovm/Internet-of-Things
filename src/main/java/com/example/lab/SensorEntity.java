package com.example.lab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sensor;
    private int temperature;
    private int time;

    public SensorEntity() {
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getTime() {
        return time;
    }
}
