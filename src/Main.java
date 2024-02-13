import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arrayofNumbers = new int[10];

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

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
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.removeBack();
        list1.addFront(21);

        System.out.println(list1.toString());
    }
}