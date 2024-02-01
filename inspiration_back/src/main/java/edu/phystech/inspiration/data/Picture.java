package edu.phystech.inspiration.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pictures")
@Getter
@Setter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "idPicture")
    private List<Episode> episodes;
    @Column
    private String imageURI;
}
