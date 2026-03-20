package fr.ensai.mediaplayer;

public class Podcast extends Media{
    private String host;
    private String topic;
    private String subtitles;


    public Podcast(String title, int year, int duration, String host, String topic, String phrase) {
        super(title, year, duration, phrase);
        this.host = host;
        this.topic = topic;
        this.subtitles = phrase;
    }
    /**
    * String representation of the Podcast.
    */
    @Override
    public String toString() {
        return String.format("Podcast %s on %s",this.title, this.host);
    }

}
