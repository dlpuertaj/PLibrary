package com.co.dlp.plibrary.repositories;

import com.co.dlp.plibrary.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Optional<Author> findById(Integer id);
}
