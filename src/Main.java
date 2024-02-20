import java.util.Arrays;
import java.util.Iterator;

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
        list1.addBack(52);
        list1.addBack(97);
        System.out.println(list1.indexOf(52));

        System.out.println(list1.toString());

        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext()) {
            int value = itr.next();
            System.out.println(value);
        }
    }
}