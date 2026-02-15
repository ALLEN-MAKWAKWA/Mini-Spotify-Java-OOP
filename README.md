# 🎵 Mini Spotify Console App (Java OOP + File Handling)

A **Spotify-inspired console application** built using **Java**, demonstrating real-world **Object-Oriented Programming (OOP)** principles and **file handling**.

This project allows users to manage their own **music library and playlists**, just like a simplified version of Spotify — including **favorites, shuffle, sorting, search, and persistent storage**.

---

# Features

## 🎶 Song Management

* Add new songs
*  View all songs
* Search songs by ID
* Update song details
* Delete songs
* Play songs
* Mark / Unmark favorite songs ❤️

---

## Playlist Management

* Create playlists
* Add songs to playlists
* View playlists
* Shuffle playlists 
* Sort playlists by:

  * Artist
  * Genre
  * Duration

---

## File Handling

* Songs saved in `songs.txt`
* Playlists saved in `playlists.txt`
* Data loads automatically when the program starts
* Persistent storage (data is not lost)

---

# OOP Concepts Used

This project demonstrates all major OOP principles:

---

## Encapsulation

Private variables with getters and setters

```java
private String title;

public String getTitle()
```

---

## Inheritance

Song inherits from MusicItem

```java
public class Song extends MusicItem
```

---

## Polymorphism

Method overriding

```java
@Override
public void play()
```

---

## Abstraction

Abstract base class

```java
public abstract class MusicItem
```


# Author

**Allen Makwakwa**

📧 [mulatiallen@gmail.com](mailto:mulatiallen@gmail.com)
🌐 https://github.com/ALLEN-MAKWAKWA

