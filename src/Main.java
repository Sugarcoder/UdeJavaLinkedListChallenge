import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Sugarcoder on 9/27/2015.
 */

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();


    public static void main(String[] args) {

        Album album = new Album("Lady Gaga", "The Fame");

        album.addSong("Just Dance", 3.40);
        album.addSong("Love Game", 3.33);
        album.addSong("Paparazzi", 3.29);
        album.addSong("Poker Face", 3.48);
        album.addSong("Boys Boys Boys", 3.21);
        album.addSong("The Fame", 3.43);

        albums.add(album);

        album = new Album("Kyary Pamyu Pamyu", "Pamyu Pamyu Revolution");
        album.addSong("Pon Pon Pon", 4.06);
        album.addSong("Candy Candy", 3.50);
        album.addSong("Drinker", 4.17);
        album.addSong("Giri Giri Safe", 3.13);
        album.addSong("Chan Chaka Chan Chan", 4.46);

        albums.add(album);


        LinkedList<Song> playlist = new LinkedList<Song>();

        albums.get(0).addToPlaylist("Poker Face", playlist);
        albums.get(0).addToPlaylist("The Fames", playlist);
        albums.get(0).addToPlaylist("Paparazzi", playlist);
        albums.get(0).addToPlayList(3, playlist);
        albums.get(1).addToPlayList(5, playlist);
        albums.get(1).addToPlayList(2, playlist);

        play(playlist);


    }


    private static void play(LinkedList<Song> playlist) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;

            }
        }
    }

}


