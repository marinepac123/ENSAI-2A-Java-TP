package fr.ensai.library;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

public class Loan {// Attributes
    protected Student student;
    protected Item item;
    protected Date startDate;
    protected Instant returnDate;

    // Constructor
    public Loan(Student student, Item item, Date startDate) {
        this.student = student;
        this.item = item;
        this.startDate = startDate;
        this.returnDate = null;
    }
    // Method
    public void setReturnDate(){
        this.returnDate = returnDate.now();
    }
     
    public String toString() {
        return String.format("Item %s borrowed by %s.", this.item, this.student);
    }
}
