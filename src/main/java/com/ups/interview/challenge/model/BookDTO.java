package com.ups.interview.challenge.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class to refer the book object
 */
@Data
@Entity
public class BookDTO implements Serializable {

    private @Id @GeneratedValue Long id;

    private String name;

    private String editorial;

    private int numOfPages;

    private String author;

    private boolean inEnglish;


    public BookDTO(String name, String editorial, int numOfPages, String author, boolean inEnglish) {
        this.name = name;
        this.editorial = editorial;
        this.numOfPages = numOfPages;
        this.author = author;
        this.inEnglish = inEnglish;
    }

    public BookDTO() {
    }
}
