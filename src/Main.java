import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // instance of ArrayIntList
        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        // test add method
        list1.add(0, 44);
        list1.add(1, 77);
        list1.add(2, 84);

        // add 3 ints to the front of the list
        list1.addFront(67);
        list1.addFront(33);
        list1.addFront(26);

        // add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        // print the list
        System.out.println("List after adding elements: " + list1);

        // test remove back
        list1.removeBack();

        // test remove front
        list1.removeFront();

        // test remove int at index specified
        list1.remove(2);
        list1.remove(0);
        list1.remove(1);

        // print the list
        System.out.println("List after removing elements: " + list1);

        // test get method
        int valueAtIndex1 = list1.get(1);
        System.out.println("Value at Index 1: " + valueAtIndex1);

        // test contains method
        boolean contains97 = list1.contains(97);
        System.out.println("Contains 97? " + contains97);

        // test indexOf method
        int indexOf26 = list1.indexOf(26);
        System.out.println("Index of 26? " + indexOf26);

        // test isEmpty method
        boolean isEmpty = list1.isEmpty();
        System.out.println("Is the list empty? " +isEmpty);

        // test size method
        int listSize = list1.size();
        System.out.println("Size of the list: " + listSize);

        // test clear method
        list1.clear();
        System.out.println("List after clearing: " + list1);


        for (int value : list1) {
            System.out.println(value);
        }

        System.out.println("-----------");

        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext()){
            int value = itr.next();
            System.out.println(value);
        }


        // Linked List short test

        System.out.println("------------------------");

        list2.addFront(9);
        list2.addFront(7);
        list2.addFront(4);
        list2.addBack(18);

        System.out.println(list2);

        // short way:
        for (int value : list2){
            System.out.println(value);
        }

        // long way
        Iterator<Integer> itr2 = list2.iterator();
        while (itr2.hasNext()){
            System.out.println(itr2.next());
        }


    }
}