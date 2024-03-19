import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {


        System.out.println("Hello and welcome!");

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();


        // add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);


        list1.removeBack();
        list1.addFront(1000);
        System.out.println(list1);

        for (int value : list1)
        {
            System.out.println(value);
        }

        System.out.println("-------------");
        // on Manual, behind the scene
        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext())
        {
            int value = itr.next();
            System.out.println(value);
        }


        // ---------------
        // Linked List short test
        // ----------------

        System.out.println("-------------------");
        list2.addFront(9);
        list2.addFront(7);
        list2.addFront(4);
        list2.addBack(18);

        System.out.println(list2);


        // short wat:
        for (int value : list2)
        {
            System.out.println(value);
        }

        // long way
        Iterator<Integer> itr2 = list2.iterator();
        while (itr2.hasNext())
        {
            System.out.println(itr2.next());
        }


        System.out.println("****************\n");

        // Test adding elements
        list1.addFront(1); // List: 1
        list1.addBack(3); // List: 1, 3
        list1.add(1, 2); // List: 1, 2, 3
        assert list1.size() == 3 : "Size should be 3 after additions.";

        // Test contains and indexOf
        assert list1.contains(2) : "List should contain 2.";
        assert list1.indexOf(3) == 2 : "Index of 3 should be 2.";

        // Test removing elements
        list1.removeFront(); // List: 2, 3
        list1.remove(1); // List: 2
        assert list1.size() == 1 : "Size should be 1 after removals.";

        // Test isEmpty
        assert !list1.isEmpty() : "List should not be empty.";

        // Test clear
        list1.clear();
        assert list1.isEmpty() : "List should be empty after clearing.";


        System.out.println("\n***********\nLinkedInt List Test:\n");

        // Adding elements
        list2.addFront(1); // List: 1
        list2.addBack(5); // List: 1, 5
        list2.add(1, 3); // List: 1, 3, 5
        list2.add(2, 4); // List: 1, 3, 4, 5
        assert list2.size() == 4 : "Size should be 4 after additions.";

        // Access and search
        assert list2.get(1) == 3 : "Element at index 1 should be 3.";
        assert list2.contains(4) : "List should contain 4.";
        assert list2.indexOf(5) == 3 : "Index of 5 should be 3.";

        // Removing elements
        list2.removeFront(); // List: 3, 4, 5
        list2.removeBack(); // List: 3, 4
        list2.remove(1); // List: 3
        assert list2.size() == 1 : "Size should be 1 after removals.";

        // Check if list is empty
        assert !list2.isEmpty() : "List should not be empty.";

        // Clearing the list
        list2.clear();
        assert list2.isEmpty() : "List should be empty after clearing.";

        // Final size check
        assert list2.size() == 0 : "Size should be 0 after clearing.";

        System.out.println("All tests passed!");


    }
}