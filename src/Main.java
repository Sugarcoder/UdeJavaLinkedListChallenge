import java.util.*;

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

        albums.get(0).addToPlaylist("Just Dance", playlist);
        albums.get(0).addToPlaylist("Bad Romance", playlist);
        albums.get(0).addToPlaylist("Telephone", playlist);
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
            printMenu();
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
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We've reached the end of the playlist.");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;

                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playlist.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.hasPrevious());
                        }
                    }
                    break;
            }
        }
    }



    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - To Quit\n" +
                            "1 - Play next song\n" +
                            "2 - Play previous song\n" +
                            "3 - Replay current song\n" +
                            "4 - List songs in the playlist\n" +
                            "5 - Print available options\n" +
                            "6 - Delete current song from the playlist");
    }



    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================");

        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("===================");
    }




}


