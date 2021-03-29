package com.co.dlp.plibrary.entities;

import com.co.dlp.plibrary.entities.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Book  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String title;
    private String isbn;
    private Integer pages;
    @Column(length = 4)
    private String published;

    private String author;
    private Genre genre;

    private String imageUrl;
}
