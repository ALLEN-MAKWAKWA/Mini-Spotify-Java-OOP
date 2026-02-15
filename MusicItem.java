public abstract class MusicItem {
    private int id;
    private String title;
    private String artist;

    public MusicItem(int id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    // Encapsulation
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }

    // Polymorphism
    public abstract void display();
    public abstract void play();
}
