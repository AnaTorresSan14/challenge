package com.ups.interview.challenge.repository;

import com.ups.interview.challenge.model.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<BookDTO, Long> {
}
