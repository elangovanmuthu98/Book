package com.elangovan_acciojob.bookManager;

import lombok.Getter;
import lombok.Setter;

@Getter//lambok dependency
@Setter// lambok dependency
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer pages;
    public Book()
    {

    }
   public Book(int id,String title,String author,int pages)
    {
        this.id=id;
        this.author=author;
        this.title=title;
        this.pages=pages;
    }

}
