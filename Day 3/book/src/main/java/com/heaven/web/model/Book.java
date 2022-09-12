package com.heaven.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String isbn;
    private String title;
    private List<String> authors = new ArrayList<>();
    public Book(String isbn,String title,String ...authors){
        this.isbn=isbn;
        this.title=title;
        this.authors.addAll(Arrays.asList(authors));
    }
}
