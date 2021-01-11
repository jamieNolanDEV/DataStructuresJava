import java.util.*;

public class main2 {
    private static ArrayList<Album> albums= new ArrayList<Album>();
    public static void main(String[] args) {


        Album album = new Album("Floyed", "Emiemn");
        album.addSong("Abc", 56.5);
        album.addSong("aa", 32);
        album.addSong("vxc", 1);
        album.addSong("OLD", 3);
        album.addSong("ads", 22);
        album.addSong("terw", 523);
        album.addSong("fa", 4231);
        albums.add(album);
        album = new Album("Abc", "Simple");

        album.addSong("zx", 56.5);
        album.addSong("df", 32);
        album.addSong("fas", 1);
        album.addSong("NEW", 3);
        album.addSong("ads", 22);
        album.addSong("terw", 523);
        album.addSong("fa", 4231);
        albums.add(album);


        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("fa", playList);
        albums.get(0).addToPlaylist("ads", playList);
        albums.get(0).addToPlaylist("NEW", playList);
        albums.get(0).addToPlaylist("OLD", playList);
        searchSong("NEW", playList);
        searchSong("asasas", playList);
    }

    private static void printList(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        while(listIterator.hasNext()){
            System.out.println("Song: " +listIterator.next().toString());
        }
    }
    private static void searchSong(String title, LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        while(listIterator.hasNext()){
            if(title == listIterator.next().getTitle()){
                System.out.println("Found!" + listIterator.next().toString());
            }else{
                System.out.println("not here!");
            }
        }


    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean head = true;
        System.out.println("1 = Next, 2 = previous, 4 = Full Playliust? ");
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs to play");
        }else{
            System.out.println("Playing" + listIterator.next().toString());
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Finsihed");
                    quit = true;
                    break;
                case 1:
                    if(!head){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        head = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Song" + listIterator.next().toString());
                    }else {
                        System.out.println("End");
                        head = false;
                    }
                    break;
                case 2:
                    if(head){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        head = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Song" + listIterator.previous().toString());
                    }else{
                        System.out.println("Nothing");
                        head = true;
                    }
                    break;
                case 3:
                    if(head){
                        if(listIterator.hasPrevious()){
                            System.out.println("Replaying" +listIterator.previous().toString());
                            head = false;
                        }else{
                            System.out.println("Start of list!");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Replaying" + listIterator.next().toString());
                            head = true;
                        }else{
                            System.out.println("End of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
            }
        }
    }

}
