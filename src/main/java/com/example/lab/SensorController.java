package com.example.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorRepo Spero;

    @PostMapping
    public ResponseEntity setdata(@RequestBody SensorEntity sensor){
        try {
            Spero.save(sensor);
            return ResponseEntity.ok("Сервер работает");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/")
    public ResponseEntity getSensor(){
        try {
            return ResponseEntity.ok("Сервер работает");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}