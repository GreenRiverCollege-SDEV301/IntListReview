import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        //Arrays in Java are fixed sized
        //Almost a primitive type
        int[] arrayOfNumbers = new int[10];

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        System.out.println("------------------------------------------------");
        System.out.println("Testing addBack(int 42), addBack(int 82), addBack(int 97):");
        //Add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing addFront(int 1):");
        list1.addFront(1);
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing add(int 0, int 0) - insert in the beginning of the array:");
        list1.add(0, 0);
        System.out.println(list1);
        System.out.println("Testing add(int 3, int 100) - insert in the middle of the array:");
        list1.add(3, 100);
        System.out.println(list1);
        System.out.println("Testing add(int 5, int 6) - outside of current max index:");
        list1.add(11, 6);
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing removeFront():");
        list1.removeFront();
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing removeBack():");
        list1.removeBack();
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing remove(int 0):");
        System.out.println(list1.remove(0));
        System.out.println(list1);
        System.out.println("Testing remove(int 2):");
        System.out.println(list1.remove(2));
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing get(int 2):");
        System.out.println(list1.get(2));
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing contains(int 1) - should be false:");
        System.out.println(list1.contains(1));
        System.out.println(list1);
        System.out.println("Testing contains(int 100) - should be true:");
        System.out.println(list1.contains(100));
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing indexOf(int 97) - should be 2:");
        System.out.println(list1.indexOf(97));
        System.out.println(list1);
        System.out.println("Testing indexOf(int 50) - should be -1:");
        System.out.println(list1.indexOf(50));
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing isEmpty() - should be false:");
        System.out.println(list1.isEmpty());
        System.out.println(list1);
        list1.removeBack();
        list1.removeBack();
        list1.removeBack();
        list1.removeBack();
        list1.removeBack();
        list1.removeBack();
        list1.removeBack();
        list1.removeBack();
        System.out.println("Testing isEmpty() - should be true:");
        System.out.println(list1.isEmpty());
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing size() - should be 0:");
        System.out.println(list1.size());
        System.out.println(list1);
        System.out.println("Testing size() - should be 3:");
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        System.out.println(list1.size());
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing clear():");
        list1.clear();
        System.out.println(list1);

        System.out.println("------------------------------------------------");
        System.out.println("Testing iterator() - should be false:");
        Iterator<Integer> list = list1.iterator();
        System.out.println(list.hasNext());
        System.out.println(list1);
        System.out.println("Testing iterator() - should be true:");
        list1.addBack(3);
        list1.addBack(20);
        list = list1.iterator();
        System.out.println(list.hasNext());
        System.out.println(list1);
        System.out.println("Testing iterator() - next() - should be 20:");
        System.out.println(list.next());
    }
}