import java.util.*;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Piya", "Atif");
        album1.addSongToAlbum("Song 1", 5.3);
        album1.addSongToAlbum("Song 2", 4.3);
        album1.addSongToAlbum("Song 3", 2.0);

        Album album2 = new Album("Stebin", "Stebin");
        album2.addSongToAlbum("Ek Tu Hi", 4.6);
        album2.addSongToAlbum("Thoda Thoda", 4.5);
        album2.addSongToAlbum("Pyaar", 5.5);

        List<Song> myPlayList = new LinkedList<>();
        System.out.println(album2.addSongToPlayListFromAlbum("Ek Tu Hi", myPlayList));
        System.out.println(album1.addSongToPlayListFromAlbum(2, myPlayList));
        System.out.println(album2.addSongToPlayListFromAlbum(2, myPlayList));

        play(myPlayList);
    }

    public static void play(List<Song> playList) {
        ListIterator<Song> itr = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("Playlist is Empty");
            return;
        }
        boolean isNext;

        System.out.println("Currently playing: ");
        System.out.println(itr.next());
        isNext = true;

        Scanner sc = new Scanner(System.in);

        printMenu();
        while (true) {
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (!isNext) {
                        itr.next();
                        isNext = true;
                    }
                    if (itr.hasNext()) {
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                    } else {
                        System.out.println("You have reached the end of the list");
                    }
                    break;
                case 2:
                    if (isNext) {
                        itr.previous();
                        isNext = false;
                    }
                    if (itr.hasPrevious()) {
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                    } else {
                        System.out.println("You have reached the start of the list");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    printAllSongs(playList);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7: // exit
                    return;
            }
        }
    }

    static void printAllSongs(List<Song> playList) {
        for (Song song : playList) {
            System.out.println(song);
            return;
        }
    }

    static void printMenu() {
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song");
        System.out.println("4. Delete current song");
        System.out.println("5. Show all songs");
        System.out.println("6. Show menu again");
        System.out.println("7. Exit");
    }
}