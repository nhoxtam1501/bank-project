package dev.ducku.bankingproject.services;

import dev.ducku.bankingproject.dtos.DefaultResponse;
import dev.ducku.bankingproject.dtos.UserRequest;

public interface UserService {
    DefaultResponse createAccount(UserRequest userRequest);
}
