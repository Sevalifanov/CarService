package com.spring.carservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    /**
     * Приветственное сообщение в браузере- необязательно
     * @return
     */
    @GetMapping
    public String greeting() {
        return "welcome to carService";
    }
}
