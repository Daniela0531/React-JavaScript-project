package edu.phystech.inspiration.service;

import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import edu.phystech.inspiration.data.repo.StoryRepository;
import edu.phystech.inspiration.data.repo.UserRepository;
import edu.phystech.inspiration.service.converters.StoryConverter;
import edu.phystech.inspiration.service.converters.UserConverter;
import edu.phystech.inspiration.service.dto.StoryDto;
import edu.phystech.inspiration.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    private final StoryRepository storyRepository;

    private final StoryConverter storyConverter;

    private final StoryService storyService;

    public void addUser(UserDto userDto) {
        User user = userConverter.toEntity(userDto);
        User savedUser = userRepository.save(user);
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return userConverter.toDto(user);
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email); // .orElse(null)
        if (user == null) {
            return null;
        }
        return userConverter.toDto(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

//    public List<UserDto> getAllUsers() {
//        return userRepository.findAll()
//                .stream()
//                .map(userConverter::toDto)
//                .toList();
//    }

    public List<StoryDto> getAllStoriesByUser(UserDto userDto) {
        List<Story> stories = storyRepository.findAllByUser(userConverter.toEntity(userDto));
        return stories.stream()
                .map(storyConverter::toDto)
                .toList();
    }

    public List<StoryDto> getCompletedStoriesByUser(UserDto userDto) {
        List<StoryDto> storiesDto = getAllStoriesByUser(userDto);
        return storiesDto.stream()
                .filter(storyService::isCompleted)
                .toList();
    }

    public User isUserExists(UserDto userDto) {
        return userRepository.findUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
    }
}

