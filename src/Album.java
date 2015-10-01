import java.util.*;


public class Album {


    private String name;
    private String artist;
    private ArrayList<Song> songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    // check if the song exist or not before adding
    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song checkedSong: this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    // add a song to playlist according to the track number
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber -1;

        if((index > 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track" + trackNumber);
        return false;
    }



    // another way to add song to playlist
    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);

        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    // you can also add the addToPlaylist into the Song object itself





/*
    public static void printSongList(LinkedList<String> songLists) {
        Iterator<String> i = songLists.iterator();

        while(i.hasNext()) {
            System.out.println("Now playing song: " + i.next());
        }
        System.out.println("=============");

    }

    // This method allows new songs to be added and ordered in the list,
    // after being compared to songs already in the list.


    private static boolean addInOrder(LinkedList<String> songList, String newSong) {
        ListIterator<String> stringListIterator = songList.listIterator();

        while(stringListIterator.hasNext()) {

            int comparison = stringListIterator.next().compareTo(newSong);

            if(comparison == 0) {
                System.out.println(newSong + "is already on the playlist");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newSong);
            } else if (comparison < 0){
                stringListIterator.add(newSong);
            }
        }
        return true;
    }



    public static void playSong(LinkedList<String> songs) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goForward = true;
        ListIterator<String> listIterator = songs.listIterator();

        if(songs.isEmpty()) {
            System.out.println("There are no songs on the playlist");
            return;
        } else {
            System.out.println("Now playing " + songs.iterator().next());
            printMenu();
        }


        while(!quit) {

            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Song ended");
                    quit = true;
                    break;

                case 1:
                    if(!goForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        } else {
                            goForward = true;
                        }
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing the song, " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goForward = false;
                    }
                    break;

                case 2:
                    if(listIterator.hasPrevious()) {
                        listIterator.previous();
                    } else {
                        goForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing the song, " + listIterator.previous());
                    } else {
                        System.out.println("Reached the start of the playlist");
                        goForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;

            }
        }



    }


    public static void printMenu() {
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - Go to the next song\n" +
                "2 - Go to the previous song\n" +
                "3 - Replay the song\n");
    }

    */


}
