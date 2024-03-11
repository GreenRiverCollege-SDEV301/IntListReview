import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        // arrays in java are fixed sized
        int[] arrayOfNumbers = new int[10];

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        // add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        list1.removeBack();
        list1.addFront(12);

        System.out.println(list1);

//        // convenience code using a for each loop
//        // only possible if class provides an iterator
//        for (int value : list1) {
//            System.out.println(value);
//        }
//
//        System.out.println("------------");
//
//        // on manual, behind the scenes
//        Iterator<Integer> itr = list1.iterator();
//        while (itr.hasNext()) {
//            int value = itr.next();
//            System.out.println(value);
//        }

        // ----------------------
        // Linked list short test
        // ----------------------
        System.out.println("------------------------");

        list2.addFront(4);
        list2.addFront(7);
        list2.addFront(9);

        System.out.println(list2);

        list2.add(0, 5);

        System.out.println(list2);


        // short way
//        for (int value : list2) {
//            System.out.println(value);
//        }

        // long way
//        Iterator<Integer> itr = list2.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
    }
}