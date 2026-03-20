package fr.ensai.mediaplayer;

public class Artist {
    // Attributes
    private String firstName;
    private String lastName;
    private String nationality;

    // Constructor
    public Artist(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    // Method
    public String toString() {
        return String.format("Author %s %s", this.firstName, this.lastName);
        }
    }
