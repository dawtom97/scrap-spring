package com.example.scrap_app.controller;

import com.example.scrap_app.model.UserModel;
import com.example.scrap_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<Map<String, String>> createUser(@Valid @RequestBody UserModel user) {
        userService.create(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("code","201");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Map<String,Object>> getUsers() {
        List<UserModel> data = userService.getAll();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "All users retrieved");
        response.put("code","200");
        response.put("data", data);

        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<Map<String,String>> deleteUser(@RequestParam String id) {
        userService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        response.put("code","200");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<Map<String,Object>> getUserById(@PathVariable String id) {
        UserModel user = userService.getUserById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User founded");
        response.put("code","200");
        response.put("data", user);

        return ResponseEntity.ok(response);
    }

}
