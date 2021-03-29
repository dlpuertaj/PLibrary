package com.co.dlp.plibrary.services;

import com.co.dlp.plibrary.entities.Book;
import com.co.dlp.plibrary.exception.BookNotFoundException;
import com.co.dlp.plibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book updateBook(Book book){
        return bookRepository.save(book) ;
    }

    public Book findById(Integer id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    public  void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }
}
