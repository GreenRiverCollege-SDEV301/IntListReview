import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        /*
        Below is an example of array and it has a fixed size
        int[] array = new int[10];
        */


        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList(20);




//        TESTING CODES FOR ARRAYLIST

        //add 6 int to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.addBack(33);
        list1.addBack(24);
        list1.addBack(67);

        System.out.println(list1.toString());

        list1.removeBack();
        System.out.println("After remove back");
        System.out.println(list1.toString());
        System.out.println();

        list1.addFront(30);
        System.out.println("After adding front");
        System.out.println(list1.toString());
        System.out.println();

        list1.add(0, 20);
        System.out.println("After adding 20 at index 1");
        System.out.println(list1.toString());
        System.out.println();

//        list1.removeFront();
//        System.out.println("After removing front");
//        System.out.println(list1.toString());
//        System.out.println();
//
//        list1.remove(1);
//        System.out.println("After removing index 1");
//        System.out.println(list1.toString());
//        System.out.println();
//
//        System.out.println("Index (1) = " + list1.get(1));
//        System.out.println();
//
//        System.out.println("Does the array contain 82? = " + list1.contains(82));
//        System.out.println("Does the array contain 90? = " + list1.contains(90));
//        System.out.println();
//
//        System.out.println("The index of 97 = " + list1.indexOf(97));
//        System.out.println("The index of 40 = " + list1.indexOf(40));
//        System.out.println();
//
//        System.out.println("Is the list empty? = " + list1.isEmpty());
//        System.out.println();
//
//        System.out.println("The number of values in the list = " + list1.size());
//        System.out.println();
//
//        list1.clear();
//        System.out.println("The list after clearing");
//        System.out.println(list1.toString());
//
//
//        //convenience code using a for each loop
//        //only possible if class provides an iterator
//        for(int value : list1)
//        {
//            System.out.println(value);
//        }
//
//        //on manual, behind the scene
//        Iterator<Integer> itr = list1.iterator();
//        while(itr.hasNext())
//        {
//            int value = itr.next();
//            System.out.println(value);
//        }



        //TESTING CODES FOR LINKED LIST
//        System.out.println("Current linked list : " + list2.toString());
//        System.out.println();
//
//        list2.addFront(36);
//        System.out.println("Added 36 to the front");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.addBack(15);
//        System.out.println("Added 15 to the back");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.addBack(66);
//        System.out.println("Added 66 to the back");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.addBack(45);
//        System.out.println("Added 45 to the back");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.addBack(3);
//        System.out.println("Added 3 to the back");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        System.out.println("Value of Index 1 = " + list2.get(1));
//        System.out.println();
//
//        list2.add(1, 82);
//        System.out.println("Added 82 at index of 1");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.removeFront();
//        System.out.println("Removed front");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.removeBack();
//        System.out.println("Removed back");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        list2.remove(2);
//        System.out.println("Removed at index of 2");
//        System.out.println(list2.toString());
//        System.out.println();
//
//        System.out.println("Does the list contain 20 ? = " + list2.contains(20));
//        System.out.println("Does the list contain 10 ? = " + list2.contains(10));
//        System.out.println();
//
//        System.out.println("The index of 20 = " + list2.indexOf(82));
//        System.out.println("The index of 10 = " + list2.indexOf(10));
//        System.out.println();
//
//        System.out.println("Is the list empty? = " + list2.isEmpty());
//        System.out.println();
//
//        System.out.println("The length of list is " + list2.size());
//        System.out.println();
//
//        list2.clear();
//        System.out.println("Removed all list values");
//        System.out.println(list2.toString());


    }
}