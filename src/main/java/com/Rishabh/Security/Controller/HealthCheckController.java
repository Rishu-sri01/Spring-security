package com.Rishabh.Security.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @org.springframework.web.bind.annotation.GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
