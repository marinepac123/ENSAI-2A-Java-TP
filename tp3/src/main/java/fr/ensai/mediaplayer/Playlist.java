package fr.ensai.mediaplayer;

import java.util.List;

public class Playlist {
    private String name;
    private List<Media> mediaList;
    private int totalDuration;

    public Playlist(String name, int totalDuration, List<Media> mediaList) {
        this.name = name;
        this.mediaList = mediaList;
        this.totalDuration = totalDuration;
    }

    public void addMedia(Media media) {
        this.mediaList.add(media);
        this.totalDuration += media.duration;
    }

    public void removeMedia(Media media){
        this.mediaList.remove(media);
        this.totalDuration =- media.duration;

    }

    public void removeMedia(int index){ 
        this.mediaList.remove(index);
    }

    public void play(boolean random){ 
        if (random == false){
            for (Media media : this.mediaList){
                media.play();
            }
        }
        else{
            Playlist playlistcopy = new Playlist(this.name, this.totalDuration, this.mediaList);
            int nombre = 1
            playlistcopy.removeMedia(nombre);
        }
    }
}
