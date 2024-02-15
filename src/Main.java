import java.util.Arrays;

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
        IntList list2 = new LinkedIntList();

        //add 3 int to the back of the list
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

        list1.add(1, 20);
        System.out.println("After adding 20 at index 1");
        System.out.println(list1.toString());
        System.out.println();

        list1.removeFront();
        System.out.println("After removing front");
        System.out.println(list1.toString());
        System.out.println();

        list1.remove(1);
        System.out.println("After removing index 1");
        System.out.println(list1.toString());
        System.out.println();

        System.out.println("Index (1) = " + list1.get(1));
        System.out.println();

        System.out.println("Does the array contain 82? = " + list1.contains(82));
        System.out.println("Does the array contain 90? = " + list1.contains(90));
        System.out.println();

        System.out.println("The index of 97 = " + list1.indexOf(97));
        System.out.println("The index of 40 = " + list1.indexOf(40));
        System.out.println();

        System.out.println("Is the list empty? = " + list1.isEmpty());
        System.out.println();

        System.out.println("The number of values in the list = " + list1.size());
        System.out.println();

        list1.clear();
        System.out.println("The list after clearing");
        System.out.println(list1.toString());




    }
}