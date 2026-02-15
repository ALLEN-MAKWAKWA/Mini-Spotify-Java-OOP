public class Song extends MusicItem {
    private String genre;
    private int duration; // in seconds
    private boolean favorite;

    public Song(int id, String title, String artist, String genre, int duration) {
        super(id, title, artist);
        this.genre = genre;
        this.duration = duration;
        this.favorite = false;
    }

    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public boolean isFavorite() { return favorite; }

    public void setGenre(String genre) { this.genre = genre; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    @Override
    public void display() {
        System.out.println(getId() + ": " + getTitle() + " by " + getArtist() +
                           " [" + genre + ", " + duration + "s]" +
                           (favorite ? " ❤️" : ""));
    }

    @Override
    public void play() {
        System.out.println("Playing " + getTitle() + " by " + getArtist() +
                           (favorite ? " ❤️" : "") + "...");
    }

    public String toFileString() {
        return getId() + "," + getTitle() + "," + getArtist() + "," + genre + "," + duration + "," + favorite;
    }

    public static Song fromFileString(String line) {
        String[] parts = line.split(",");
        Song s = new Song(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            parts[3],
            Integer.parseInt(parts[4])
        );
        s.setFavorite(Boolean.parseBoolean(parts[5]));
        return s;
    }
}
