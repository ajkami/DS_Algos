import java.util.Iterator;
import java.util.LinkedList;

public class Linked {

    public static void main(String[] args) {
        LinkedList<String> linky = new LinkedList<String>();

        // adding values ot the linked list
        linky.add("AJ");
        linky.add("Bob");
        linky.add("Roy");


        // Creating an iterator to iterate through the linked list to find a specific value if idk know where it is
        Iterator<String> it = linky.iterator();

        // Setting a count so we can see what index Bob is at
        int count = 0;

        while(it.hasNext()) {
            if (it.next().equals("Bob")) {
                System.out.format("We found Bob! He was at index %s", count);
            }
            count++;
        }

    }

}
