package com.spring.carservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping
    public String greeting() {
        return "welcome to garage \n" +
                "POST /addCar  BODY: {\"id\":121,\"brand\":\"укажи имя\",\"modelName\":\"укажи модель\"}\n" +
                "POST /addMechanic BODY: {\"id\": 1 ,\"firstName\": \"IVANOVICH\",\"lastName\": \"IVANOV\"}";
    }
}
