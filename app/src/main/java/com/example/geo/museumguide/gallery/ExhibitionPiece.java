package com.example.geo.museumguide.gallery;

/**
 * Created by Geo on 2/1/2017.
 */

public class ExhibitionPiece {
    private String name;
    private String author;
    private int year;
    private int thumbnail;

    public ExhibitionPiece() {

    }

    public ExhibitionPiece(String name, String author, int year, int thumbnail) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
