package com.example.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/Conditioner")
public class SensorController {
    @Autowired
    private SensorRepo Spero;
    Long time = 5L;
    int day=0;
    @PostMapping("/start")
    public ResponseEntity setdata(@RequestBody limitations lim){
        try {
            while(day<50) {
                time++;
                SensorEntity sens = new SensorEntity(time, lim.min, lim.max);
                Spero.save(sens);
                day+=1;
                TimeUnit.SECONDS.sleep(5);
            }
            return ResponseEntity.ok("Сгенерирована новая запись в бд");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/check")
    public ResponseEntity getSensor(){
        try {
            return ResponseEntity.ok("Кондиционер подключен и готов работать");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
