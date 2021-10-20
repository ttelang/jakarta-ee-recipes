package com.jakartaee10recipes.chapter04;

import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named(value="authorController")
public class AuthorController {

    Book currentBook;

    public AuthorController(){
        populateAuthors();
    }

    public void populateAuthors(){
        currentBook = new Book("Java 9 Recipes", "book.png");
        addChapters();
    }


    private void addChapters(){
        Chapter chapter1 = new Chapter(1, "Getting Started with Java 7", null);
        Chapter chapter2 = new Chapter(2, "Strings", null);
        Chapter chapter3 = new Chapter(3, "Numbers and Dates", null);
        Chapter chapter4 = new Chapter(4, "Data Structures, Conditionals, and Iteration", null);
        Chapter chapter5 = new Chapter(5, "Input and Output", null);
        Chapter chapter6 = new Chapter(6, "Exceptions, Logging, and Debugging", null);
        Chapter chapter7 = new Chapter(7, "Object Oriented Java", null);
        Chapter chapter8 = new Chapter(8, "Concurrency", null);
        Chapter chapter9 = new Chapter(9, "Debugging and Unit Testing", null);
        Chapter chapter10 = new Chapter(10, "Unicode, Internationalization, and Currency Codes", null);
        Chapter chapter11 = new Chapter(11, "Working with Databases (JDBC)", null);
        Chapter chapter12 = new Chapter(12, "Java 2D Graphics and Media", null);
        Chapter chapter13 = new Chapter(13, "Java 3D", null);
        Chapter chapter14 = new Chapter(14, "Swing API", null);
        Chapter chapter15 = new Chapter(15, "JavaFX Fundamentals", null);
        Chapter chapter16 = new Chapter(16, "Graphics with JavaFX", null);
        Chapter chapter17 = new Chapter(17, "Media with JavaFX", null);
        Chapter chapter18 = new Chapter(18, "Working with Servlets", null);
        Chapter chapter19 = new Chapter(19, "Applets", null);
        Chapter chapter20 = new Chapter(20, "JavaFX on the Web", null);
        Chapter chapter21 = new Chapter(21, "Email", null);
        Chapter chapter22 = new Chapter(22, "XML and Web Services", null);
        Chapter chapter23 = new Chapter(23, "Networking", null);
        List<Chapter> chapterList = new ArrayList();
        chapterList.add(chapter1);
        chapterList.add(chapter2);
        chapterList.add(chapter3);
        chapterList.add(chapter4);
        chapterList.add(chapter5);
        chapterList.add(chapter6);
        chapterList.add(chapter7);
        chapterList.add(chapter8);
        chapterList.add(chapter9);
        chapterList.add(chapter10);
        chapterList.add(chapter11);
        chapterList.add(chapter12);
        chapterList.add(chapter13);
        chapterList.add(chapter14);
        chapterList.add(chapter15);
        chapterList.add(chapter16);
        chapterList.add(chapter17);
        chapterList.add(chapter18);
        chapterList.add(chapter19);
        chapterList.add(chapter20);
        chapterList.add(chapter21);
        chapterList.add(chapter22);
        chapterList.add(chapter23);
        currentBook.setChapters(chapterList);
    }
}
