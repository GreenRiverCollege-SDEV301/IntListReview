import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        System.out.println("------------------ArrayIntList-------------------");
        System.out.println(list1.indexOf(97));

        // Add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);


        list1.addFront(99);

        System.out.println(list1);

        list1.add(6, 20);

        System.out.println(list1);


        System.out.println(list1.indexOf(88));

        System.out.println(list1);


        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext()){
            int value = itr.next();
            System.out.println(value);
        }

        // -----------------------
        // Linked List Short Test
        // -----------------------



        System.out.println("------------------LinkedIntList-------------------");

        System.out.println(list2.contains(22));

        list2.removeBack();
        System.out.println(list2);

        list2.addFront(42);
        System.out.println(list2);

        list2.removeBack();
        System.out.println(list2);

        list2.addFront(82);
        list2.addFront(97);

        list2.addBack(50);
        list2.addBack(23);

        list2.addFront(30);

        System.out.println(list2);

        for(int value: list2){
            System.out.println(value);
        }

        list2.removeBack();
        System.out.println(list2);

        list2.removeFront();
        System.out.println(list2);
        list2.removeFront();
        System.out.println(list2);
        list2.removeFront();
        System.out.println(list2);
        list2.removeFront();
        System.out.println(list2);

        list2 = new LinkedIntList();

        list2.add(0, 10);
        System.out.println(list2);

        list2.addFront(2);
        list2.addFront(5);
        list2.addFront(30);
        list2.addFront(92);
        System.out.println("94: " + list2);
        list2.add(3, 55);
        System.out.println("96: " + list2);
        list2.add(5, 75);
        System.out.println("98: " + list2);
        System.out.println(list2.size()-1);
        list2.add(list2.size(), 33);
        System.out.println("100: " + list2);

        //System.out.println(list2.contains(22));
        //System.out.println(list2.get(0));

        System.out.println("-------------------");
        System.out.println(list2);
        System.out.println(list2.remove(4));

        System.out.println("-------------------");
        System.out.println(list2);
        System.out.println(list2.indexOf(1));

        //list2.add(1, 20);
        //System.out.println(list2);
    }
}