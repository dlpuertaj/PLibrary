package com.co.dlp.plibrary.entities;

import com.co.dlp.plibrary.entities.enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;

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
    @Column(nullable = false, updatable = false)
    private String isbn;
    private String imgUrl;
    private Integer pages;
    private Year published;

    @OneToOne(mappedBy = "author")
    private Author author;
    private Genre genre;
}
