package edu.phystech.inspiration.controllers;


import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import edu.phystech.inspiration.service.StoryService;
import edu.phystech.inspiration.service.UserService;
import edu.phystech.inspiration.service.converters.StoryConverter;
import edu.phystech.inspiration.service.converters.UserConverter;
import edu.phystech.inspiration.service.dto.StoryDto;
import edu.phystech.inspiration.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final StoryService storyService;
    private final UserConverter userConverter;
    private final StoryConverter storyConverter;

    @CrossOrigin
    @PostMapping("/add/{username}/{password}/{email}")
    public void addUser(@PathVariable String username, @PathVariable String password, @PathVariable String email) {
        userService.addUser(new UserDto(new ArrayList<>(), username, password, email));
    }

    @CrossOrigin
    @GetMapping("/login/{login}/{password}")
    public ResponseEntity<UserDto> loginUser(@PathVariable String login, @PathVariable String password) {
        User user = userService.isUserExists(new UserDto(new ArrayList<>(), null, password, login));
        if (user != null) {
            return ResponseEntity.ok(userConverter.toDto(user));
        }

        throw new ResponseStatusException(NOT_FOUND, "Login failed");
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        if (userDto == null) {
            return;
        }
        userService.deleteUser(id);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<UserDto> getUser(@PathVariable String email) {
        UserDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/update/{id}/name/{username}")
    public void updateUsername(@PathVariable Long id, @PathVariable String username) {
        User user = userConverter.toEntity(userService.getUserById(id));
        if (user == null) {
            return;
        }
        user.setUsername(username);
    }

    @PostMapping("/update/{id}/password/{password}")
    public void updatePassword(@PathVariable Long id, @PathVariable String password) {
        User user = userConverter.toEntity(userService.getUserById(id));
        if (user == null) {
            return;
        }
        user.setPassword(password);
    }

    @PostMapping("/update/{id}/email/{email}")
    public void updateEmail(@PathVariable Long id, @PathVariable String email) {
        User user = userConverter.toEntity(userService.getUserById(id));
        if (user == null) {
            return;
        }
        user.setEmail(email);
    }

    @PostMapping("update/{id}/add-story/{storyId}")
    public void addStory(@PathVariable Long id, @PathVariable Long storyId) {
        Story story = storyConverter.toEntity(storyService.getStoryById(storyId));
        if (story == null) {
            return;
        }
        User user = userConverter.toEntity(userService.getUserById(id));
        if (user == null) {
            return;
        }
        user.getStories().add(story);
    }

    @PostMapping("update/{id}/delete-story/{storyId}")
    public void deleteStory(@PathVariable Long id, @PathVariable Long storyId) {
        Story story = storyConverter.toEntity(storyService.getStoryById(storyId));
        if (story == null) {
            return;
        }
        User user = userConverter.toEntity(userService.getUserById(id));
        if (user == null) {
            return;
        }
        user.getStories().remove(story);
    }

    @GetMapping("/get/{id}/all-stories")
    public ResponseEntity<List<StoryDto>> getUserStoriesById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        if (userDto == null) {
            return null;
        }
        List<StoryDto> userStories = userService.getAllStoriesByUser(userDto);
        return ResponseEntity.ok(userStories);
    }

//    @GetMapping("/get/{id}/completed-stories")
//    public ResponseEntity<List<StoryDto>> getCompletedUserStoriesById(@PathVariable Long id) {
//        UserDto userDto = userService.getUserById(id);
//        if (userDto == null) {
//            return null;
//        }
//        List<StoryDto> completedUserStories = userService.getCompletedStoriesByUser(userDto);
//        return ResponseEntity.ok(completedUserStories);
//    }
}
