import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        // add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.removeBack();
        list1.addFront(1);

        System.out.println(list1);

        // convenience code for using foreach code which is
        // only possible if class provides an Iterator:
        for (int value : list1) {
            System.out.println(value);
        }
        // on manual, behind the scenes:
        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext()) {
            int value = itr.next();
            System.out.println(value);
        }

        list2.addFront(9);
        list2.addFront(7);
        list2.addFront(4);
        list2.addBack(18);
        System.out.println(list2.toString());
        }
    }
