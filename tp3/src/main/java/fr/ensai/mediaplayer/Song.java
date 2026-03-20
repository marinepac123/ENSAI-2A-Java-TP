package fr.ensai.mediaplayer;

import java.util.Objects;
import java.util.List;

/**
 * Represents a song with essential attributes.
 */
public class Song extends Media{
    private Artist singer;
    private String lyrics;
    private Artist author;
    private Artist composer;
    private List<Genre> genres;

    /**
     * Constructs a new Song object.
     *
     * @param title    The title of the song.
     * @param singer   The singer of the song.
     * @param title    The title of the song.
     * @param year     The year the song was released.
     * @param duration The duration of the song in seconds.
     * @param lyrics   The lyrics of the song.
     * @param author   The author of the song.
     * @param composer The composer of the song.
     * @param genres   The genre of the song 
     */
    
    public Song(String title, Artist singer, int year, int duration, String phrase, Artist author, Artist composer, List<Genre> genres) {
        super(title, year, duration, phrase);
        this.singer = singer;
        this.lyrics = phrase;
        this.author = author;
        this.composer = composer;
        this.genres = genres;
    }

    /**
     * String representation of the Song.
     */
    @Override
    public String toString() {
        return String.format("Song %s by %s",this.title, this.singer);
    }
    
    /**
     * Indicates whether some other object is "equal to" this one. Two Song
     * objects are considered equal if they have the same title, singer, and year.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Song otherSong = (Song) o;
        return this.year == otherSong.year &&
                Objects.equals(this.title, otherSong.title) &&
                Objects.equals(this.singer, otherSong.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.singer, this.year);
    }


}