package com.LogActivity.api.service;

import com.LogActivity.api.domain.User;
import com.LogActivity.api.domain.exception.CreateAccountValidationException;
import com.LogActivity.api.infra.api.dao.UserRepository;
import com.LogActivity.api.infra.api.server.dto.CreateUserRequestDto;
import com.LogActivity.api.infra.api.server.dto.UserResponseDto;
import com.LogActivity.api.infra.jpa.UserEntity;
import com.LogActivity.api.infra.jpa.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserService(
            UserRepository userRepository,
            UserMapper userMapper
    ){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
    }

    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto){
        if(userRepository.existsByEmail(createUserRequestDto.getEmail())){
            throw new CreateAccountValidationException("email already exists", "USER_ALREADY_EXCEPTION");
        }

        User user=userMapper.toDomain(createUserRequestDto);

        user = new User(
                null,
                user.getName(),
                user.getEmail(),
                java.time.LocalDateTime.now()
        );

        UserEntity userEntity=userMapper.toEntity(user);

        UserEntity savedEntity = userRepository.save(userEntity);

        return userMapper.toResponse(savedEntity);
    }
}
