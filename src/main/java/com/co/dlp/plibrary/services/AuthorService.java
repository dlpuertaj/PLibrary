package com.co.dlp.plibrary.services;

import com.co.dlp.plibrary.entities.Author;
import com.co.dlp.plibrary.exception.AuthorNotFoundException;
import com.co.dlp.plibrary.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author updateAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author findById(Integer id){
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
    }

    public void deleteAuthor(Integer id){
        authorRepository.deleteById(id);
    }
}
