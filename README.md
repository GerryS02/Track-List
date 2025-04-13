# Track-List
<br>
Author: Gerry S.
<hr>

This is a simple Java console-based application that allows users to manage a personal music library. Users can search for songs by title, artist, or genre, and add new songs to the collection.

The song data is stored in a text file (`songs.txt`) which the application reads from and writes to using file handling techniques.

---

**Features**

- Search songs by: Title, Artist, and Genre.
- Add new songs to the library  
- Automatically saves new entries to a `.txt` file  
- Loads songs from the file on program start  

---

**Technologies and Concepts Used**

---

**1. Object-Oriented Programming (OOP)**

The application is built using OOP principles for modular, maintainable code.

- `Song` class stores song attributes (title, artist, genre, album, year)  
- `Library` class manages song collections and organizes search logic  
- `Main` class acts as the entry point and handles user interaction  

---

**2. File Handling**

- Uses `BufferedReader` to read song data from `songs.txt` during startup  
- Uses `BufferedWriter` to append newly added songs to the file  
- Ensures persistent data storage between sessions  
- Includes exception handling for safe file operations  

---

**3. Data Structures**

- Implements `HashMap<String, List<Song>>` to efficiently group songs by:  
  - Title  
  - Artist  
  - Genre  
- Keys are stored in lowercase for case-insensitive search  
- Hash map usage enables fast lookup and reduces unnecessary iterations  

---

**4. Searching Algorithm**

- User input is normalized (converted to lowercase)  
- The program performs direct map lookups instead of iterating through all songs  
- If a match is found, the related list of songs is displayed  
- This approach ensures quick and optimized search operations  

---

**5. Error Handling**

- Utilizes `try-catch` blocks to catch and handle runtime exceptions:  
  - `NumberFormatException` when parsing user input (e.g., menu selection, year)  
  - `IOException` for file read/write operations  
- Provides informative error messages when invalid input or file issues occur  

---
![Image](https://github.com/user-attachments/assets/246aa0f4-19ee-4ce1-903d-3b8f65303735) 

