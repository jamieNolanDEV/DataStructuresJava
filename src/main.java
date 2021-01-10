import java.util.Iterator;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        LinkedList<String> countries = new LinkedList<String>();
        countries.add("Ireland");
        countries.add("USA");
        countries.add("Sweden");
        countries.add("France");
        countries.add("Spain");

        printList(countries);
        countries.add("Germany");
        printList(countries);

    }

    private static void printList(LinkedList<String> myList){
    Iterator<String> i= myList.iterator();
    while(i.hasNext()){
        System.out.println("Country: " + i.next());
    }
        System.out.println("================================");
    }
}
