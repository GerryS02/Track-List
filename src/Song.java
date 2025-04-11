package src;

// src/Song.java
public class Song {
    private String title;
    private String artist;
    private String genre;
    private String album;
    private int year;

    // Constructor
    public Song(String title, String artist, String genre, String album, int year) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.year = year;
    }

    // Getters
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public String getAlbum() { return album; }
    public int getYear() { return year; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAlbum(String album) { this.album = album; }
    public void setYear(int year) { this.year = year; }

    // Method to display song details
    public void displaySongDetails() {
        System.out.println("Title: " + title + "; Artist: " + artist + "; Genre: " + genre +
                           "; Album: " + album + "; Year: " + year);
    }
}

    

