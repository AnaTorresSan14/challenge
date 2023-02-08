package com.ups.interview.challenge.controller;

import com.ups.interview.challenge.model.BookDTO;
import com.ups.interview.challenge.repository.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private final LibraryRepository libraryRepository;

    LibraryController(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }


    @RequestMapping(value = "/newBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseEntity<List<BookDTO>> addingABook(@RequestBody BookDTO newBook) {

        //iLibraryService.addingBook(newBook);
        libraryRepository.save(newBook);
        return ResponseEntity.status(HttpStatus.OK).body(libraryRepository.findAll());
    }

    @RequestMapping(value = "/bookList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity<List<BookDTO>> stock() {

        return ResponseEntity.status(HttpStatus.OK).body(libraryRepository.findAll());
    }

}
