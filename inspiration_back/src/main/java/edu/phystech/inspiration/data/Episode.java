package edu.phystech.inspiration.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "episodes")
@Getter
@Setter

public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Picture idPicture;
    @Column
    private Long num;
    @Column
    private Boolean isComplete;
    @Column
    private String text;
    @ManyToOne
    private Chapter chapter;
}

