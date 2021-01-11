import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AlbumList {
    public static void main(String[] args) {
        LinkedList<Album> playlist = new LinkedList<Album>();



    }

    private static void printList(LinkedList<String> myList) {
        Iterator<String> i = myList.iterator();
        while (i.hasNext()) {
            System.out.println("Song: " + i.next());
        }
        System.out.println("================================");
    }

    private static void addSong(LinkedList<Album> albumList){
        ListIterator<Album> albumIterator = albumList.listIterator();
        while(albumIterator.hasNext()){
            int compare = 0;
        }
    }

}
