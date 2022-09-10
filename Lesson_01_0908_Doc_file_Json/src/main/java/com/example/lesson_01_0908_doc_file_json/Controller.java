package com.example.lesson_01_0908_doc_file_json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/book")
public class Controller {
    @Autowired
    private BookRepository bookRepo;
    @GetMapping("/json")
    public ResponseEntity<List<Book>> getAllBook(){
       BookRepository bookRepository = new BookRepository();
       ArrayList<BookRepository> arr = new ArrayList<>();

        return ResponseEntity.ok().body(bookRepo.getAllBook());
    }
    @Autowired
    private BookRepository bookRepoExcel;
    @GetMapping("/excel")
    public ResponseEntity<List<Book>> getAllBookByExcel(){
        List<Book> readExcel = bookRepoExcel.getAllBookExcel();
        System.out.println(readExcel);
        return ResponseEntity.ok().body(readExcel);
    }


//    @GetMapping("/author")
//    public ArrayList<Book> sortByAuthor(){
//        BookRepository carRepository = new BookRepository();
//        ArrayList<Book> list = carRepository.getAllBook();
//
//        Collections.sort(list, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getAuthor().compareTo(o2.getAuthor());
//            }
//        });
//        return list;
//    }

    @GetMapping("/author")
    public ResponseEntity<List<Book>> sortByAuthor(){
        BookRepository bookRepository = new BookRepository();
        List<Book> list = bookRepository.getAllBook();
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/title")
    public ResponseEntity<List<Book>> sortByTitle(){
        BookRepository bookRepository = new BookRepository();
        List<Book> list = bookRepository.getAllBook();
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/year")
    public ResponseEntity<List<Book>> sortByYear(){
        BookRepository bookRepository = new BookRepository();
        List<Book> list = bookRepository.getAllBook();
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getYear() - o2.getYear();
            }
        });
        return ResponseEntity.ok().body(list);
    }

}
