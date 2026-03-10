package fr.ensai.library;

import java.util.List;

public abstract class Item {
    // Attributes
    protected String title;
    protected int year;
    protected int pageCount;

    // Constructor
    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }
}

