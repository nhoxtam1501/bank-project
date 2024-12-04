package dev.ducku.bankingproject.controllers;

import dev.ducku.bankingproject.dtos.DefaultResponse;
import dev.ducku.bankingproject.dtos.UserRequest;
import dev.ducku.bankingproject.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public DefaultResponse createAccount(@RequestBody UserRequest user) {
        return userService.createAccount(user);
    }
}
