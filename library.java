// file for storing songs

import java.util.*;

public class Library{
    private Map<String , List<Song>> songsByTitle;
    private Map<String, List<Song>> songsByArtist;
    private Map<String, List<Song>> songsByGenre;

    public Library (){
        songsByTitle = new HashMap<>();
        songsByArtist = new HashMap<>();
        songsByGenre = new HashMap<>();
    }

    // Method to add a song to the library

    public void addSong(Song song){
        // Add by title
        songsByTitle.putIfAbsent(song.getTitle(), new ArrayList<>());
        songsByTitle.get(song.getTitle()).add(song);

        // Add by Artist
        songsByArtist.putIfAbsent(song.getArtist(), new ArrayList<>());
        songsByArtist.get(song.getArtist()).add(song);

        // Add by Genre
        songsByGenre.putIfAbsent(song.getGenre(), new ArrayList<>());
        songsByGenre.get(song.getGenre()).add(song);
    }

    // Method to serch a song

    

}