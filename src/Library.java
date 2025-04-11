package src;

// src/Library.java
import java.util.*;
import java.io.*;

public class Library {
    private Map<String, List<Song>> songsByTitle;
    private Map<String, List<Song>> songsByArtist;
    private Map<String, List<Song>> songsByGenre;

    public Library() {
        songsByTitle = new HashMap<>();
        songsByArtist = new HashMap<>();
        songsByGenre = new HashMap<>();
    }

    // Method to add a song to the library
    public void addSong(Song song) {
        // Normalize keys to lowercase
        String titleKey = song.getTitle().toLowerCase();
        String artistKey = song.getArtist().toLowerCase();
        String genreKey = song.getGenre().toLowerCase();

        // Add by title
        songsByTitle.putIfAbsent(titleKey, new ArrayList<>());
        songsByTitle.get(titleKey).add(song);

        // Add by artist
        songsByArtist.putIfAbsent(artistKey, new ArrayList<>());
        songsByArtist.get(artistKey).add(song);

        // Add by genre
        songsByGenre.putIfAbsent(genreKey, new ArrayList<>());
        songsByGenre.get(genreKey).add(song);
    }

    // Method to load songs from a file
    public void loadSongsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    String genre = parts[2].trim();
                    String album = parts[3].trim();
                    int year = Integer.parseInt(parts[4].trim());

                    Song song = new Song(title, artist, genre, album, year);
                    addSong(song);
                } else {
                    System.out.println("Invalid line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage());
        }
    }

    // Method to search songs by title
    public void searchByTitle(String title) {
        title = title.toLowerCase();
        if (songsByTitle.containsKey(title)) {
            for (Song song : songsByTitle.get(title)) {
                song.displaySongDetails();
            }
        } else {
            System.out.println("No songs found with the title: " + title);
        }
    }

    // Method to search songs by artist
    public void searchByArtist(String artist) {
        artist = artist.toLowerCase();
        if (songsByArtist.containsKey(artist)) {
            for (Song song : songsByArtist.get(artist)) {
                song.displaySongDetails();
            }
        } else {
            System.out.println("No songs found by the artist: " + artist);
        }
    }

    // Method to search songs by genre
    public void searchByGenre(String genre) {
        genre = genre.toLowerCase();
        if (songsByGenre.containsKey(genre)) {
            for (Song song : songsByGenre.get(genre)) {
                song.displaySongDetails();
            }
        } else {
            System.out.println("No songs found in the genre: " + genre);
        }
    }
}

