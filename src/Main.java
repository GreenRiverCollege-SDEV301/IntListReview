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

        System.out.println(list1.toString());

        System.out.println("After remove back");
        list1.removeBack();
        System.out.println(list1.toString());



    }
}