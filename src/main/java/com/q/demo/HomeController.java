package com.q.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return Map.of("status", "UP");
    }
}
