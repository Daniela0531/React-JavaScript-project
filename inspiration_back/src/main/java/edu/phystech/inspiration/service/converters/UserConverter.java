package edu.phystech.inspiration.service.converters;

import edu.phystech.inspiration.data.User;
import edu.phystech.inspiration.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}