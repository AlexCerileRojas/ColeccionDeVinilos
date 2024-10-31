package org.example;


public class Vinilo {
    private String author;
    private String name;
    private int year;

    public Vinilo(String author, String name, int year) {
        this.author = author;
        this.name = name;
        this.year = year;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
