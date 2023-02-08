package com.ups.interview.challenge.config;

import com.ups.interview.challenge.model.BookDTO;
import com.ups.interview.challenge.repository.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadLibraryStock {

    @Bean
    CommandLineRunner initializingDB(LibraryRepository stock){
        return args -> {
            log.info("Loading Book {}", stock.save(new BookDTO("Revival","Plaza Janes",415,"Stephen King",true)));
            log.info("Loading Book {}", stock.save(new BookDTO("Pedro Paramo","RM & Fundacion Juan Rulfo",132,"Juan Rulfo",false)));
            log.info("Loading Book {}", stock.save(new BookDTO("El club de las 5 am","Grijalbo",391,"Robin Sharma",false)));
        };
    }

}
