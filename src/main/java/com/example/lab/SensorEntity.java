package com.example.lab;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Random;

@Entity
public class SensorEntity {

    @Id
    private Long time;

    private int temperature_sensor;

    private int max;
    private int min;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    private String condition;

    public SensorEntity(Long time,int minimum,int maximum,String c){
        // генерация случайного числа
        Random rand = new Random();
        this.time=time;
        int randomNum = rand.ints(minimum,(maximum+1)).findFirst().getAsInt();
        temperature_sensor = randomNum;
        max=maximum;
        min=minimum;
        condition = c;
    }
    public SensorEntity(){
        time=1L;
    }
    public void setTemperature_sensor(int temperature_sensor) {
        this.temperature_sensor = temperature_sensor;
    }

    public int getTemperature_sensor() {
        return temperature_sensor;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
