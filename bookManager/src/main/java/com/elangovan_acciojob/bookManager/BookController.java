package com.elangovan_acciojob.bookManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class BookController {

    BookController()
    {
        System.out.println("Bookcontroller created");
    }

    @Autowired
    private BookService bookservice;
    @PostMapping("/add-new-book")
    public ResponseEntity<String> addBook(@RequestBody Book book)
    {
        String s=bookservice.addbook(book);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping("/get-book")//localhost:8080/get-book?id=1
    public ResponseEntity<?> getBook(@RequestParam Integer id)
    {
        try {
            Book b= bookservice.getbook(id);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        catch (RuntimeException ex)
        {
            return new ResponseEntity<>("Book not fount"+id,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        return new ResponseEntity<>(bookservice.getall(),HttpStatus.OK);
    }

@GetMapping("/get-book-by-name/{name}")
    public ResponseEntity<Book> getBookName(@PathVariable String name)
    {
        try {
            return new ResponseEntity<>(bookservice.getbookname(name),HttpStatus.OK);
        }
        catch(RuntimeException ex)
        {
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

//        for(Integer k: bookData.keySet())
//        {
//            Book book=bookData.get(k);
//            if(book.getTitle().equals(name)) return book;
//
//        }
//        return null;
    }
@PutMapping("/update-book")
    public ResponseEntity<Book> updatebookpages(@RequestParam Integer id,@RequestParam Integer pages)
    {
        try {
            Book r = bookservice.updatebook(id, pages);
            return new ResponseEntity<>(r,HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
//        Book b=bookData.get(id);
//        b.setPages(pages);
//        bookData.put(id,b);
//        return bookData.get(id);
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<String> removeBook(@PathVariable Integer id)
    {
        bookservice.remove(id);
        return new ResponseEntity<>("Book removed",HttpStatus.OK);
    }
}
