package edu.phystech.inspiration.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "stories")
@Getter
@Setter
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Chapter> chapters;
    @ManyToOne
    private User user;
    @Column
    private String name;
}
