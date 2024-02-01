package edu.phystech.inspiration.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "chapters")
@Getter
@Setter
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Story story;
    @Column
    private Long num;
    @OneToMany(mappedBy = "chapter")
    private List<Episode> episodes;
}
