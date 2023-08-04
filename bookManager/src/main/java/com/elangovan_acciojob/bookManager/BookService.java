package com.elangovan_acciojob.bookManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookService()
    {
        System.out.println("Bookservice created");
    }
    @Autowired
    private BookRepository bookrepository;

    public String addbook(Book book)
    {

        bookrepository.add(book);
        return "Book added"+book.getId();
    }
    public Book getbook(Integer id)
    {
        Optional<Book> bookOptional=bookrepository.getBookId(id);

        if(bookOptional.isEmpty())
        {
             throw new RuntimeException("This Book is not present"+id);
        }
        return bookOptional.get();
    }
    public List<Book> getall()
    {
        return bookrepository.getBookall();
    }
    public Book getbookname(String name)
    {
        List<Book> l=bookrepository.getBookall();

        for(Book b:l)
        {
            if(b.getTitle().equals(name))
            {
                return b;
            }
        }
        throw  new RuntimeException("book not found");
    }
    public Book updatebook(Integer id,Integer pages)
    {
        Book b=getbook(id);
        b.setPages(pages);
        bookrepository.update(b);
        return b;

    }
    public void remove(Integer id)
    {
        bookrepository.delete(id);
    }
}
