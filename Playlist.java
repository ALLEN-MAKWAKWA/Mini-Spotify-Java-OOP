import java.util.*;

public class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Song> getSongs() { return songs; }

    public void addSong(Song song) { songs.add(song); }
    public void removeSong(int id) { songs.removeIf(s -> s.getId() == id); }

    public void shuffle() {
        Collections.shuffle(songs);
        System.out.println("Playlist shuffled!");
    }

    public void sortBy(String field) {
        switch(field.toLowerCase()) {
            case "genre":
                songs.sort(Comparator.comparing(Song::getGenre));
                break;
            case "artist":
                songs.sort(Comparator.comparing(Song::getArtist));
                break;
            case "duration":
                songs.sort(Comparator.comparingInt(Song::getDuration));
                break;
            default:
                System.out.println("Invalid sort field!");
                return;
        }
        System.out.println("Playlist sorted by " + field + "!");
    }

    public void display() {
        System.out.println("\nPlaylist: " + name);
        for (Song s : songs) s.display();
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder(name + ":");
        for(Song s : songs) sb.append(s.getId()).append(";");
        return sb.toString();
    }
}
