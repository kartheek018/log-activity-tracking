package com.LogActivity.api.infra.jpa;

import com.LogActivity.api.domain.User;
import com.LogActivity.api.infra.api.server.dto.CreateUserRequestDto;
import com.LogActivity.api.infra.api.server.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(CreateUserRequestDto dto){
        return new User(
                null,
                dto.getName(),
                dto.getEmail(),
                null
        );
    }

    public UserEntity toEntity(User user){
        UserEntity userEntity=new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setCreatedAt(userEntity.getCreatedAt());

        return userEntity;
    }

    public UserResponseDto toResponse(UserEntity userEntity){
        UserResponseDto responseDto=new UserResponseDto();
        responseDto.setId(userEntity.getId());
        responseDto.setEmail(userEntity.getEmail());
        responseDto.setName(userEntity.getName());
        responseDto.setCreatedAt(userEntity.getCreatedAt());

        return responseDto;
    }
}
