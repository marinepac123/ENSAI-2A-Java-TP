package fr.ensai.library;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        Magazine mag1 = new Magazine(
                "978-0-618-26025-7",
                "mag1",
                123,
                1955,
                424);

        Magazine mag2 = new Magazine(
                "978-0-618-26025-8",
                "mag2",
                234,
                1956,
                425);

        List<Item> books = new ArrayList<>();
        books.add(fellowshipOfTheRing);

        Library libraryA = new Library("libraryA", books);

        libraryA.loadBooksFromCSV("books.csv");
        libraryA.addItem(mag1);
        libraryA.addItem(mag2);

        System.out.println(libraryA.displayItems());

        System.out.println(fellowshipOfTheRing);

    }
}