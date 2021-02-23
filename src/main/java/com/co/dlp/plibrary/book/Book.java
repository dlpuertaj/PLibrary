package com.co.dlp.plibrary.book;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Year;

@Entity
public class Book {

    @Id
    private Integer id;
    private String title;
    private String isbn;
    private String imgUrl;
    private Integer pages;
    private Year published;
    private Author author;
    private Genre genre;
}
