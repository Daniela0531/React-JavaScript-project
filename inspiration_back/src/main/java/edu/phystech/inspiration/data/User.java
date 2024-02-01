package edu.phystech.inspiration.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "user")
    private List<Story> stories;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
}
