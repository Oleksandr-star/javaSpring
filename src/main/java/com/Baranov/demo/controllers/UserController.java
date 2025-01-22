package com.Baranov.demo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<String> users = new ArrayList<>();

    public UserController() {
        users.add("User 1");
        users.add("User 2");
    }

    @PostMapping
    public String registerUser(@RequestBody String userName) {
        users.add(userName);
        return "User " + userName + " registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String userName, @RequestParam String password) {
        if (users.contains(userName)) {
            return "User " + userName + " logged in successfully!";
        } else {
            return "User not found!";
        }
    }

    @DeleteMapping("/{index}")
    public String deleteUser(@PathVariable int index) {
        if (index >= 0 && index < users.size()) {
            String removedUser = users.remove(index);
            return "User " + removedUser + " deleted successfully!";
        } else {
            return "User not found!";
        }
    }

    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }
    @GetMapping("/users")
    public String usersPage() {
        return "users";
    }
}
