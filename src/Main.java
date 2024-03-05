import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.add(1, 500);

        System.out.println("for each loop");
        for(int value : list1){
            System.out.println(value);
        }

        System.out.println("iterator");
        Iterator<Integer> itr = list1.iterator();
        while(itr.hasNext()){
            int value = itr.next();
            System.out.println(value);
        }

        ///-----------------------------
        // Linked list test
        ///----------------------
        System.out.println("-----------------------");

//        list2.addBack(9);
//        list2.addBack(7);
//        list2.addBack(3);
//        list2.addBack(5);

        list2.addFront(9);
        list2.addFront(7);
        list2.addFront(3);
        list2.addFront(5);
        System.out.println(list2.toString());
    }
}