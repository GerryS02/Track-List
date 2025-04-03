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

    // Method to serch a songs by title
    public void searchByTitle(String title){
        if(songsByTitle.containsKey(title)){
            // Iterate throgh the list of Songs with that title and display the details
            for(Song song : songsByTitle.get(title)){
                song.displaySongDetails();
            }
        } else{
            System.out.println("No songs found with the title: " + title);
        }
    }

    // Method to search songs by artist

    public void searchByArtist(String artist){
        if(songsByArtist.containsKey(artist)){
            // Iterate through the list of songs by that artist and display the deatils
            for(Song song : songsByArtist.get(artist)){
                song.displaySongDetails();
            }
        } else {
            System.out.println("No songs found by "+ artist);
        }
    }

    // Method to search by Genre

    public void searchByGenre(String genre){
        if(songsByGenre.containsKey(genre)){
            // Iterate through the list of songs associated with that genre and display the details
            for(Song song : songsByGenre.get(genre)){
                song.displaySongDetails();
            }
        } else {
            System.out.println("No songs found with the genre: " + genre);
        }
    }

    // Method to display all the songs by a specific artist
    public void listSongsByArtist(String artist){
        if(songsByArtist.containsKey(artist)){
            System.out.println("Songs by "+ artist + ":");
            for(Song song: songsByArtist.get(artist)){
                // Display the title of the songs
                System.out.println("- "+ song.getTitle());
            }
        } else{
            System.out.println("No songs found by "+ artist);
        }
    }

    //Method to list all the songs by one genre
    public void listSongsByGenre(String genre){
        if(songsByGenre.containsKey(genre)){
            System.out.println("Songs with the "+ genre + " genre: ");
            for(Song song: songsByGenre.get(genre)){
                // display only the title
                System.out.println("- " + song.getTitle());
            }
        }
    }

}