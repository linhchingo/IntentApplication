package com.intent.letha.intentapplication;

import java.io.Serializable;

public class Book implements Serializable {
    private String maBook,tenBook;
    private int namSX;

    public Book(String maBook, String tenBook, int namSX) {
        this.maBook = maBook;
        this.tenBook = tenBook;
        this.namSX = namSX;
    }

    public Book() {
    }

    public String getMaBook() {
        return maBook;
    }

    public void setMaBook(String maBook) {
        this.maBook = maBook;
    }

    public String getTenBook() {
        return tenBook;
    }

    public void setTenBook(String tenBook) {
        this.tenBook = tenBook;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }
}
