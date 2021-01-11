import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song checkSongs : this.songs) {
            if (checkSongs.getTitle().equals(title)) {
                return checkSongs;
            }
        }
        return null;

    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        Song checkSong = findSong(title);
        if (checkSong != null) {
            playList.add(checkSong);
            return true;
        }
        return false;
    }
}



