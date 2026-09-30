package com.medical.patientservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope    // ← Bắt buộc để bean này reload khi có /actuator/refresh
public class WelcomeController {

    /**
     * Giá trị này được nạp từ Config Server.
     * Khi gọi POST /actuator/refresh, Spring sẽ tạo lại bean này
     * với giá trị mới của app.welcome.
     */
    @Value("${app.welcome}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }
}