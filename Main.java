import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicManager manager = new MusicManager();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n--- Mini Spotify Menu ---");
            System.out.println("1. Add Song\n2. View Songs\n3. Search Song\n4. Play Song\n5. Update Song\n6. Delete Song\n7. Mark/Unmark Favorite");
            System.out.println("8. Create Playlist\n9. Add Song to Playlist\n10. View Playlists\n11. Shuffle Playlist\n12. Sort Playlist\n13. Exit");
            System.out.print("Choice: "); int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice){
                case 1:
                    System.out.print("ID: "); int id=sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String title=sc.nextLine();
                    System.out.print("Artist: "); String artist=sc.nextLine();
                    System.out.print("Genre: "); String genre=sc.nextLine();
                    System.out.print("Duration(sec): "); int dur=sc.nextInt(); sc.nextLine();
                    manager.addSong(new Song(id,title,artist,genre,dur));
                    break;
                case 2: manager.viewSongs(); break;
                case 3:
                    System.out.print("Song ID: "); manager.searchSong(sc.nextInt()); break;
                case 4:
                    System.out.print("Song ID: "); Song s = manager.getSong(sc.nextInt());
                    if(s!=null) s.play(); else System.out.println("Song not found!"); break;
                case 5:
                    System.out.print("Song ID: "); int uid=sc.nextInt(); sc.nextLine();
                    System.out.print("New Title: "); String nt=sc.nextLine();
                    System.out.print("New Artist: "); String na=sc.nextLine();
                    System.out.print("New Genre: "); String ng=sc.nextLine();
                    System.out.print("New Duration: "); int nd=sc.nextInt(); sc.nextLine();
                    manager.updateSong(uid,nt,na,ng,nd); break;
                case 6:
                    System.out.print("Song ID: "); manager.deleteSong(sc.nextInt()); break;
                case 7:
                    System.out.print("Song ID: "); int fid=sc.nextInt(); sc.nextLine();
                    System.out.print("Favorite(true/false): "); boolean fav=sc.nextBoolean();
                    manager.markFavorite(fid,fav); break;
                case 8:
                    System.out.print("Playlist Name: "); String pname=sc.nextLine();
                    manager.createPlaylist(pname); break;
                case 9:
                    System.out.print("Playlist Name: "); String pln=sc.nextLine();
                    System.out.print("Song ID: "); int sid=sc.nextInt(); sc.nextLine();
                    manager.addSongToPlaylist(pln,sid); break;
                case 10: manager.viewPlaylists(); break;
                case 11:
                    System.out.print("Playlist Name: "); manager.shufflePlaylist(sc.nextLine()); break;
                case 12:
                    System.out.print("Playlist Name: "); String pln2=sc.nextLine();
                    System.out.print("Sort by(genre/artist/duration): "); String field=sc.nextLine();
                    manager.sortPlaylist(pln2,field); break;
                case 13: System.out.println("Goodbye!"); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
