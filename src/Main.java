import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int[] arrayOfNumbers = new int[10];

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        //adds 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        System.out.println(list1);

        list1.removeBack();
        list1.addFront(32);

        System.out.println(list1);

        // iterator short way
        for(int value : list1) {
            System.out.println(value);
        }

        list1.removeFront();

        System.out.println(list1);


        // --------------------
        // Linked List short test
        // --------------------

        System.out.println("----------------------------");

        list2.addFront(9);
        list2.addFront(7);
        list2.addFront(4);
        list2.addBack(18);

        System.out.println(list2);

        // iterator long way
        Iterator<Integer> itr = list2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Contains 9?: " + list2.contains(9));
        System.out.println("Contains 22?: " + list2.contains(22));

        System.out.println("Index of 9: " + list2.indexOf(9));
        System.out.println("Index of 22: " + list2.indexOf(22));

        System.out.println("Get value of index 2: " + list2.get(2));
        System.out.println("Get value of index 0: " + list2.get(0));

        System.out.println("Show me value of removed index 2: " + list2.remove(2));
        System.out.println(list2);

        System.out.println(list2.remove(0));
        System.out.println(list2);

        list2.removeFront();
        System.out.println(list2);

        list2.removeBack();
        System.out.println(list2);

        list2.removeFront();
        System.out.println(list2);

        list2.removeFront();
        System.out.println(list2);

        System.out.println(list2.size());
        System.out.println(list2.isEmpty());


        list2.clear();

        System.out.println(list2);
        System.out.println(list2.isEmpty());

    }
}