package com.co.dlp.plibrary.entities;

import com.co.dlp.plibrary.entities.Book;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private String born;
    private Year yearOfbirth;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
