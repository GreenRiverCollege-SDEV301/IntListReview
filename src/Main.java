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
    }
}