package com.q.demo.controller;

import com.q.demo.entity.ApiLog;
import com.q.demo.repository.ApiLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    private final ApiLogRepository logRepository;

    public HomeController(ApiLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping("/")
    public Map<String, String> index() {
        logRepository.save(new ApiLog("GET", "/"));
        return Map.of(
            "app",     "demo",
            "version", "0.0.1",
            "status",  "running"
        );
    }

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        logRepository.save(new ApiLog("GET", "/status"));
        return Map.of("status", "UP");
    }

    @GetMapping("/logs")
    public List<ApiLog> getLogs() {
        return logRepository.findAll();
    }
}
