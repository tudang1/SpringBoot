package com.example.lesson_01_0908_doc_file_json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poiji.bind.Poiji;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
@Service
public class BookRepository {
    private ArrayList<Book> book = new ArrayList<>();
    // nhiệm vụ của constructor này là đọc dữ liệu file Json vào một Arraylist<Car>
    public BookRepository(){
        try {
            File file = ResourceUtils.getFile("classpath:static/book.json");
            ObjectMapper mapper = new ObjectMapper();
            book.addAll(mapper.readValue(file, new TypeReference<List<Book>>() {}));
            book.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Book> getAllBook() {
        return book;
    }
    //đọc dữ liệu từ file excel
    public List<Book> getAllBookExcel() {
        try {
            File file = ResourceUtils.getFile("classpath:static/book_excel.xlsx");
            List<Book> bookListExcel = Poiji.fromExcel(file,Book.class);
            return bookListExcel;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

}
