package edu.phystech.inspiration.service.dto;

import edu.phystech.inspiration.data.Story;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private List<Story> stories;
    private String username;
    private String password;
    private String email;
}
