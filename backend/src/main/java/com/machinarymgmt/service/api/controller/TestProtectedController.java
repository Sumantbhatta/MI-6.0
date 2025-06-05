package com.machinarymgmt.service.api.controller;

import com.machinarymgmt.service.api.data.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestProtectedController {

    // Accessible only to admin
    @GetMapping("/admin/dashboard")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("✅ Welcome, Admin! This is your dashboard.");
    }

    // Accessible to admin or employee
    @GetMapping("/employee/tasks")
    public ResponseEntity<String> employeeAccess() {
        return ResponseEntity.ok("✅ Hello Employee or Admin! Here are your tasks.");
    }

    // Accessible to any logged-in user
    @GetMapping("/user/profile")
    public ResponseEntity<String> userProfile() {
        return ResponseEntity.ok("👤 Welcome, you are logged in. This is your profile.");
    }
}
