package com.ups.interview.challenge;

import com.ups.interview.challenge.controller.LibraryController;
import com.ups.interview.challenge.model.BookDTO;
import com.ups.interview.challenge.repository.LibraryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LibraryControllerTest {

    @InjectMocks
    LibraryController libraryController;

    @Mock
    LibraryRepository libraryRepository;

    @Test
    public void getting_list_of_books(){

        List<BookDTO> books = new ArrayList<>();

        books.add(new BookDTO("El club de las 5 am","Grijalbo",391,"Robin Sharma",false));
        books.add(new BookDTO("Pedro Paramo","RM & Fundacion Juan Rulfo",132,"Juan Rulfo",false));

        when(libraryRepository.findAll()).thenReturn(books);

        List<BookDTO> response = libraryController.stock().getBody();
        assertThat(response.get(1).getName()).isEqualTo("Pedro Paramo");
        assertThat(response.size()).isEqualTo(2);
    }

    @Test
    public void adding_book(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<BookDTO> books = new ArrayList<>();

        BookDTO newBook = new BookDTO("Revival","Plaza Janes",415,"Stephen King",true);

        when(libraryRepository.save(any(BookDTO.class))).thenReturn(newBook);

        ResponseEntity<List<BookDTO>> responseEntity = libraryController.addingABook(newBook);

        System.out.println(">>> " + responseEntity.getBody());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

}
