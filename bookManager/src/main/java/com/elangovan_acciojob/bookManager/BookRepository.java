package com.elangovan_acciojob.bookManager;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    BookRepository()
    {
        System.out.println("Bookrrepository created");
    }

    private Map<Integer,Book> bookData=new HashMap<>();

    public void add(Book book)
    {
        bookData.put(book.getId(),book);
    }
    public Optional<Book> getBookId(Integer Id)
    {
        //Optional<Book> returnbook=bookData.get(Id);
        if(bookData.containsKey(Id))
        {

            Book bookreturn=bookData.get(Id);
            return Optional.of(bookreturn);
        }
        return Optional.empty();


    }
    public List<Book> getBookall()
    {
        return new ArrayList<>(bookData.values());
    }

    public void update(Book b)
    {
        bookData.put(b.getId(),b);
    }
    public void delete(Integer id)
    {
        bookData.remove(id);
    }
}
