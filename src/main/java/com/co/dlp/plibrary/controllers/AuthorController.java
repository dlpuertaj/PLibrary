package com.co.dlp.plibrary.controllers;

import com.co.dlp.plibrary.entities.Author;
import com.co.dlp.plibrary.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.findAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Integer id){
        Author author = authorService.findById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author newAuthor = authorService.addAuthor(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        Author updatedAuthor = authorService.updateAuthor(author);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Integer id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
