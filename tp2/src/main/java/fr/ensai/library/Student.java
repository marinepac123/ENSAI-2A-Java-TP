package fr.ensai.library;

public class Student {
    // Attributes
    protected String name;
    protected int age;
    protected int academicYear;
    protected Boolean isClassDelegate;

    // Constructor
    public Student(String name, int age, int academicYear, Boolean isClassDelegate) {
        this.name = name;
        this.age = age;
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }
}
