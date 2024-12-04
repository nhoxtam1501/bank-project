package dev.ducku.bankingproject.services.impl;

import dev.ducku.bankingproject.dtos.DefaultResponse;
import dev.ducku.bankingproject.dtos.UserRequest;
import dev.ducku.bankingproject.dtos.UserResponse;
import dev.ducku.bankingproject.entities.User;
import dev.ducku.bankingproject.repositories.UserRepository;
import dev.ducku.bankingproject.services.UserService;
import dev.ducku.bankingproject.utils.AccountUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceMySQL implements UserService {
    private static final String ACCOUNT_EXISTS_CODE = "001";
    private static final String ACCOUNT_EXISTS_MESSAGE = "This user already exists";
    private static final String ACCOUNT_CREATION_SUCCESS_CODE = "002";
    private static final String ACCOUNT_CREATION_SUCCESS_MESSAGE = "Account has been successfully created";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceMySQL(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DefaultResponse createAccount(UserRequest userRequest) {
        User newUser = new User();
        if (existByEmail(userRequest.getEmail())) {
            return new DefaultResponse(ACCOUNT_EXISTS_CODE, ACCOUNT_EXISTS_MESSAGE, null);
        }
        modelMapper.map(userRequest, newUser);
        newUser.setStatus(User.STATUS.ENABLED);
        newUser.setBalance(BigDecimal.ZERO);
        newUser.setAccountNumber(AccountUtils.generateAccountNumber());
        User savedUser = userRepository.save(newUser);
        UserResponse userResponse = UserResponse.builder()
                .accountNumber(savedUser.getAccountNumber())
                .balance(savedUser.getBalance())
                .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                .build();
        return new DefaultResponse(ACCOUNT_CREATION_SUCCESS_CODE, ACCOUNT_CREATION_SUCCESS_MESSAGE, userResponse);
    }

    private boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
