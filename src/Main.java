import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        System.out.println(list1);
    }
}