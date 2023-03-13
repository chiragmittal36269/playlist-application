import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;

        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> song) {
        this.songs = song;
    }


    // find songs helps to find the song present on the album or not.
    boolean findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }


    // create a new song and then add new song to album
    String addSongToAlbum(String title, double duration) {
        if (!findSong(title)) {
            Song s = new Song(title, duration);
            this.songs.add(s);
            return "Song added to the album";
        }
        return "Song already exists in the album";
    }


    // find the song present on the album using title and then add song from album to playlist
    String addSongToPlayListFromAlbum(String title, List<Song> playList) {
        if (findSong(title)) {
            for (Song s : this.songs) {
                if (s.getTitle().equals(title)) {
                    playList.add(s);
                    return "Song has been added to the playlist using title";
                }
            }
        }
        return "Song not present in album";
    }


    // find the song present on the album using track no. and then add song from album to playlist
    String addSongToPlayListFromAlbum(int trackNo, List<Song> playList) {
        int index = trackNo - 1;
        if (index >= 0 && index < this.songs.size()) {
            playList.add(this.songs.get(index));
            return "Song has been added to the playlist using trackNo";
        }
        return "Invalid Position of song";
    }
}