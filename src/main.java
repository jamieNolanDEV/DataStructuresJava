import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class main {
    public static void main(String[] args) {
        LinkedList<String> countries = new LinkedList<String>();
        addInOrder(countries, "Ireland");
        addInOrder(countries, "Spain");
        addInOrder(countries, "Germany");
        addInOrder(countries, "Italy");
        addInOrder(countries, "France");
        addInOrder(countries, "United States of America");

        printList(countries);

    }

    private static void printList(LinkedList<String> myList){
    Iterator<String> i= myList.iterator();
    while(i.hasNext()){
        System.out.println("Country: " + i.next());
    }
        System.out.println("================================");
    }

    private static boolean addInOrder(LinkedList<String> list, String newCountry){
        ListIterator<String> stringListIterator = list.listIterator();
        while(stringListIterator.hasNext()){
            int compare = stringListIterator.next().compareTo(newCountry);
            if(compare == 0){
                System.out.println("Country " + newCountry + "is already here");
                return false;
            }else if(compare > 0){
                stringListIterator.previous(); //C++ this would be tail!
                stringListIterator.add(newCountry);
                return true;
            }else if(compare < 0){

            }

        }
        stringListIterator.add(newCountry);
        return true;
    }

    private static void visitCountry(LinkedList listCountry){

    }
}
