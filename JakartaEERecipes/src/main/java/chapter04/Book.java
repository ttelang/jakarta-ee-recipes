package com.jakartaee10recipes.chapter04;

import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author juneau, ttelang
 */
@Named(value = "book")
public class Book {
    private String image;
    private List<Chapter> chapters;
    private String title;

    public Book(String title, String image){
        this.setTitle(title);
        this.image = image;
    }

    public Book(){
        image = "book.png";
        chapters = new ArrayList<>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setChapters(List<Chapter> chapterList) {
        this.chapters = chapterList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
