package src;

// src/Main.java
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Library collection = new Library();
        Scanner sc = new Scanner(System.in);

        // Load songs from songs.txt
        collection.loadSongsFromFile("songs.txt");

        System.out.println("\n🎵 Welcome to the Track-List! 🎵");

        while (true) {
            System.out.println("\n1. Search by Title");
            System.out.println("2. Search by Artist");
            System.out.println("3. Search by Genre");
            System.out.println("4. Add a new song");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the song title to search: ");
                    String title = sc.nextLine();
                    collection.searchByTitle(title);
                    break;

                case 2:
                    System.out.print("Enter the artist name to search: ");
                    String artist = sc.nextLine();
                    collection.searchByArtist(artist);
                    break;

                case 3:
                    System.out.print("Enter the genre to search: ");
                    String genre = sc.nextLine();
                    collection.searchByGenre(genre);
                    break;

                case 4:
                    System.out.println("** Add a New Song **");
                    System.out.print("Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Artist: ");
                    String newArtist = sc.nextLine();
                    System.out.print("Genre: ");
                    String newGenre = sc.nextLine();
                    System.out.print("Album: ");
                    String newAlbum = sc.nextLine();
                    System.out.print("Release Year: ");
                    int newYear = Integer.parseInt(sc.nextLine());

                    Song newSong = new Song(newTitle, newArtist, newGenre, newAlbum, newYear);
                    collection.addSong(newSong);
                    saveSongToFile("songs.txt", newSong);
                    System.out.println("✅ Song added and saved successfully!");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

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

