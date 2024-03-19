import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        IntList list2 = new LinkedIntList();

        // -------------------------------
        // Linked List Short Test
        // -------------------------------
        list2.addBack(92);
        list2.addBack(24);
        list2.addBack(56);
        list2.addBack(61);
        list2.addBack(756);
        list2.addBack(777);
        list2.addBack(723);
        list2.addBack(947);
        list2.addBack(724);
        list2.addBack(986);
        list2.addBack(1235);
        list2.addBack(3453);
        list2.addBack(8766);
        list2.addBack(3554);
        list2.addBack(1251);

        System.out.println(list2.toString());

        System.out.println("Add front");
        list2.addFront(2);
        System.out.println("Added 2 to front: --->" + list2.toString());
        System.out.println();

        System.out.println("Add back");
        list2.addBack(2);
        System.out.println("Added 2 to back: --->" + list2.toString());
        System.out.println();

        System.out.println("Add to index 5");
        list2.add(5, 2);
        System.out.println("Added 2 to index 5: --->" + list2.toString());
        System.out.println();

        System.out.println("Remove front");
        list2.removeFront();
        System.out.println("Removed front: --->" + list2.toString());
        System.out.println();

        System.out.println("Remove back");
        list2.removeBack();
        System.out.println("Removed back: --->" + list2.toString());
        System.out.println();

        System.out.println("Remove index of 4");
        list2.remove(4);
        System.out.println("Removed back: --->" + list2.toString());
        System.out.println();

        System.out.println("Gets value of index 5");
        System.out.println("Result: " + list2.get(5));
        System.out.println();

        System.out.println("Contains value 777");
        System.out.println("Result: " + list2.contains(777));
        System.out.println();

        System.out.println("Index of value 777");
        System.out.println("Result: " + list2.indexOf(777));
        System.out.println();

        System.out.println("Is empty: " + list2.isEmpty());
        System.out.println("Size: " + list2.size());
        list2.clear();
        System.out.println("Cleared list: -->" + list2.toString());

//        Iterator<Integer> iterator = list2.iterator();
//        while (iterator.hasNext()) {
//            int value = iterator.next();
//            System.out.println(value);
//        }

    }
}