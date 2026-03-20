package fr.ensai.mediaplayer;

import java.util.List;

public abstract class Media {
    protected String title;
    protected int year;
    protected int duration;
    protected String phrase;

    protected Media(String title, int year, int duration, String phrase) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.phrase = phrase;
    }

    public void play() {
        String[] words = this.phrase.split(" ");
        for (String word : words) { 
            System.out.println(word);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted");
            }       
        }
    }
}
