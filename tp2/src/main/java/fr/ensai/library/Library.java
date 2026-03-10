package fr.ensai.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Library {
    // Attributes
    private String name; 
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;

    // Constructor
    public Library(String name, List<Item> items, List<Loan> activeLoans, List<Loan> completedLoans) {
        this.name = name;
        this.items = items;
        this.activeLoans = activeLoans;
        this.completedLoans = completedLoans;
    }

    // Method
    public void addItem(Item item){
        this.items.add(item);
    }

    public String displayItems() {
        String chaine = ""; 
        if (this.items.isEmpty()) {
            System.out.println("Il n'y a aucun livre dans la library");
        }
        else {
            for (Item item : this.items){
            chaine += item.toString();
            chaine += " \n ";
            }
        }
        return chaine;
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        //System.out.println(String.format("Create %s", author));
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
}
