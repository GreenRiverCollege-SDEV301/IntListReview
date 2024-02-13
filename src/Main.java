
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        // arrays in Java are fixed size
        int[] arrayOfNumbers = new int[10];

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        // add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.removeBack();

        System.out.println(list1);


    }
}