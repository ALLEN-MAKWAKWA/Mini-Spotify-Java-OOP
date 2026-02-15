import java.io.*;
import java.util.*;

public class MusicManager {
    private List<Song> songs = new ArrayList<>();
    private List<Playlist> playlists = new ArrayList<>();

    private final String SONG_FILE = "songs.txt";
    private final String PLAYLIST_FILE = "playlists.txt";

    public MusicManager() {
        loadSongs();
        loadPlaylists();
    }

    // Songs CRUD
    public void addSong(Song s) { songs.add(s); saveSongs(); }
    public void viewSongs() { for(Song s : songs) s.display(); }
    public void searchSong(int id) {
        for(Song s : songs) {
            if(s.getId() == id) { s.display(); return; }
        }
        System.out.println("Song not found!");
    }
    public void updateSong(int id, String title, String artist, String genre, int duration) {
        for(Song s : songs) {
            if(s.getId() == id) {
                s.setTitle(title);
                s.setArtist(artist);
                s.setGenre(genre);
                s.setDuration(duration);
                saveSongs();
                return;
            }
        }
        System.out.println("Song not found!");
    }
    public void deleteSong(int id) {
        songs.removeIf(s -> s.getId() == id);
        saveSongs();
    }

    public void markFavorite(int id, boolean fav) {
        for(Song s : songs) {
            if(s.getId() == id) { s.setFavorite(fav); saveSongs();
                System.out.println((fav?"Marked":"Unmarked")+" favorite: "+s.getTitle()); return;}
        }
        System.out.println("Song not found!");
    }

    // Playlists CRUD
    public void createPlaylist(String name) {
        playlists.add(new Playlist(name));
        savePlaylists();
    }

    public void addSongToPlaylist(String playlistName, int songId) {
        Playlist pl = getPlaylist(playlistName);
        Song s = getSong(songId);
        if(pl != null && s != null) { pl.addSong(s); savePlaylists(); }
        else System.out.println("Playlist or song not found!");
    }

    public void viewPlaylists() { for(Playlist p : playlists) p.display(); }

    public void shufflePlaylist(String playlistName) {
        Playlist pl = getPlaylist(playlistName);
        if(pl != null) { pl.shuffle(); savePlaylists(); }
        else System.out.println("Playlist not found!");
    }

    public void sortPlaylist(String playlistName, String field) {
        Playlist pl = getPlaylist(playlistName);
        if(pl != null) { pl.sortBy(field); savePlaylists(); }
        else System.out.println("Playlist not found!");
    }

    private Playlist getPlaylist(String name) {
        for(Playlist p : playlists) if(p.getName().equalsIgnoreCase(name)) return p;
        return null;
    }
    public Song getSong(int id)
{
    for(Song s : songs)
        if(s.getId() == id)
            return s;

    return null;
}

    

    // FILE HANDLING
    private void saveSongs() {
        try(PrintWriter pw=new PrintWriter(SONG_FILE)) {
            for(Song s : songs) pw.println(s.toFileString());
        } catch(Exception e){System.out.println("Error saving songs");}
    }
    private void loadSongs() {
        try {
            File f = new File(SONG_FILE);
            if(!f.exists()) return;
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) songs.add(Song.fromFileString(sc.nextLine()));
            sc.close();
        } catch(Exception e){System.out.println("Error loading songs");}
    }

    private void savePlaylists() {
        try(PrintWriter pw=new PrintWriter(PLAYLIST_FILE)) {
            for(Playlist p : playlists) pw.println(p.toFileString());
        } catch(Exception e){System.out.println("Error saving playlists");}
    }
    private void loadPlaylists() {
        try {
            File f = new File(PLAYLIST_FILE);
            if(!f.exists()) return;
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                Playlist pl = new Playlist(parts[0]);
                String[] songIds = parts[1].split(";");
                for(String id : songIds) {
                    if(id.isEmpty()) continue;
                    Song s = getSong(Integer.parseInt(id));
                    if(s!=null) pl.addSong(s);
                }
                playlists.add(pl);
            }
            sc.close();
        } catch(Exception e){System.out.println("Error loading playlists");}
    }
}
