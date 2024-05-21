package com.example.lab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SensorEntity {

    @Id
    private Long time;

    private int temperature;


    public SensorEntity(Long time,int minimum,int maximum){
        // генерация случайного числа
        this.time=time;
        int randomNum = (int) (minimum + (int)(Math.random() * maximum));
        temperature = randomNum;
    }
    public SensorEntity(){
        time=1L;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
