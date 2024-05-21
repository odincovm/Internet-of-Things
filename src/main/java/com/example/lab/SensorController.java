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
    Long time = 0L;
    int day=0;
    @PostMapping("/start")
    public ResponseEntity setdata(@RequestBody limitations lim){
        try {
            while(day<24) {
                time++;
                SensorEntity sens = new SensorEntity(time, lim.min, lim.max,"norm");
                day+=1;
                if(sens.getTemperature_sensor()>lim.max-2){
                    lim.min-=2;
                    lim.max-=2;
                    sens.setCondition("Down");
                }
                if(sens.getTemperature_sensor()<lim.min+2) {
                    lim.min += 2;
                    lim.max += 2;
                    sens.setCondition("Up");

                }
                if(lim.max>=36) {
                    lim.max = 22;
                    lim.min = 12;
                    sens.setCondition("Max_reset");
                }
                if (lim.min < 10) {
                    lim.max = 22;
                    lim.min = 12;
                    sens.setCondition("Min_reset");
                }
                Spero.save(sens);
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
