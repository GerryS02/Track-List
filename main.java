// file for main source code
// package Track-List;
import java.util.Scanner;
import java.io.*;

public class main {
    public static void main(String[] args){
        Library collection = new Library();
        Scanner sc = new Scanner(System.in);

        // load songs from txt file
        loadSongsFromFile("songs.txt", collection);

        System.out.println("Welcome to the Track-List!");

        while(true){
            System.out.println("\n1. Search by Title");
            System.out.println("2. Search by Artist");
            System.out.println("3. Search by Genre");
            System.out.println("4. List all songs by Artist");
            System.out.println("5. List all songs by Genre");
            System.out.println("6. Add a new song");
            System.out.println("7. Exit");
            System.out.println("\nChose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); //consume newline

            switch (choice){
                case 1:
                    System.out.println("Enter the song title to search: ");
                    String title = sc.nextLine();
                    collection.searchByTitle(title);
                    break;

                case 2:
                    System.out.println("Enter the artist name to search: ");
                    String artist = sc.nextLine();
                    collection.searchByArtist(artist);
                    break;

                case 3:
                    System.out.println("Enter genre to search: ");
                    String genre = sc.nextLine();
                    collection.searchByGenre(genre);
                    break;

                case 4:
                    System.out.println("Enter the artist to list songs: ");
                    artist  = sc.nextLine();
                    collection.listSongsByArtist(artist);
                    break;

                case 5:
                    System.out.println("Enter genre to list songs: ");
                    genre = sc.nextLine();
                    collection.listSongsByGenre(genre);
                    break;

                case 6:
                    System.out.println("** Add a new song **");
                    System.out.println("Enter the title: ");
                    String newTitle = sc.nextLine();

                    System.out.println("Enter the artist: ");
                    String newArtist = sc.nextLine();

                    System.out.println("Enter the genre: ");
                    String newGenre = sc.nextLine();

                    System.out.println("Enter the album: ");
                    String newAlbum = sc.nextLine();

                    System.out.print("Enter release year: ");
                    int newYear = sc.nextInt();

                    sc.nextLine();  // Consume newline

                    Song newSong = new Song(newTitle, newArtist, newGenre, newAlbum, newYear);
                    collection.addSong(newSong);
                    saveSongToFile("songs.txt", newSong);
                    System.out.println("Song added and saved successfully!");
                    break;
            }


        }
        
    }

    // Load songs from songs.txt
    public static void loadSongsFromFile(String fileName, Library collection){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // Use 'fileName' here
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue; // skip empty/comments
    
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    String genre = parts[2].trim();
                    String album = parts[3].trim();
                    int year = Integer.parseInt(parts[4].trim());
    
                    Song song = new Song(title, artist, genre, album, year);
                    collection.addSong(song);
                } else {
                    System.out.println("Invalid line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage()); // Use 'fileName' here as well
        }
    }
    
    // Append new song to songs.txt
    private static void saveSongToFile(String filename, Song song) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(String.format("%s,%s,%s,%s,%d\n",
                    song.getTitle(),
                    song.getArtist(),
                    song.getGenre(),
                    song.getAlbum(),
                    song.getYear()));
        } catch (IOException e) {
            System.out.println("Error writing to " + filename + ": " + e.getMessage());
        }
    }
}

