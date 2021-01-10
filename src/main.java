import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        LinkedList<String> countries = new LinkedList<String>();
        addInOrder(countries, "Ireland");
        addInOrder(countries, "Spain");
        addInOrder(countries, "Germany");
        addInOrder(countries, "Italy");
        addInOrder(countries, "France");
        addInOrder(countries, "United States of America");


        visitCountry(countries);

    }

    private static void printList(LinkedList<String> myList) {
        Iterator<String> i = myList.iterator();
        while (i.hasNext()) {
            System.out.println("Country: " + i.next());
        }
        System.out.println("================================");
    }

    private static boolean addInOrder(LinkedList<String> list, String newCountry) {
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            int compare = stringListIterator.next().compareTo(newCountry);
            if (compare == 0) {
                System.out.println("Country " + newCountry + "is already here");
                return false;
            } else if (compare > 0) {
                stringListIterator.previous(); //C++ this would be tail!
                stringListIterator.add(newCountry);
                return true;
            } else if (compare < 0) {

            }

        }
        stringListIterator.add(newCountry);
        return true;
    }

    private static void visitCountry(LinkedList listCountry) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean head = true;
        ListIterator<String> listIterator = listCountry.listIterator();
        if (listCountry.isEmpty()) {
            System.out.println("Nothing in the List ");
            return;
        } else {
            System.out.println("Next up?" + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Countries Over");
                    quit = true;
                    break;
                case 1:
                    if(!head){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        head = true; ///This is to fix a problem with the listIterator itself.
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Next? " + listIterator.next());
                    } else {
                        System.out.println("no countries left to visit!");
                    }
                    break;
                case 2:
                    if(head){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        head = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting" + listIterator.previous());
                    } else {
                        System.out.println("At the start");

                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("Select an Action \n");
        System.out.println("0 to quit\n 1 Go to Next Country \n 2 Go to Previous Country Item \n Go to menu");
    }
}
