import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        IntList list2 = new LinkedIntList();

        // -------------------------------
        // Linked List Short Test
        // -------------------------------
        list2.addBack(2);
        list2.addBack(4);
        list2.addBack(5);
        list2.addBack(6);
        list2.addBack(7);
        list2.remove(2);
        System.out.println(list2.toString());

//        Iterator<Integer> iterator = list2.iterator();
//        while (iterator.hasNext()) {
//            int value = iterator.next();
//            System.out.println(value);
//        }

    }
}