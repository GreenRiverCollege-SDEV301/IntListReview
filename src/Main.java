import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        IntList list1 = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        // add 3 ints to the back of the list
        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);

        list1.removeBack();
        list1.addFront(1000);

        System.out.println(list1);

        // convenience code using a for each loop
        // only possible if class provides an iterator
        for (int value : list1)
        {
            System.out.println(value);
        }

        System.out.println("-----------");

        // on manual, behind the scenes
        Iterator<Integer> itr = list1.iterator();
        while(itr.hasNext())
        {
            int value = itr.next();
            System.out.println(value);
        }

        System.out.println("------------------------------------------------");

        //------------------------------
        // Linked List short test
        //------------------------------

        list2.addFront(9);
        list2.addFront(7);
        list2.addFront(4);
        list2.addBack(18);

        System.out.println(list2);

        /// short way
        for(int value : list2)
        {
            System.out.println(value);
        }

        // long way
        Iterator<Integer> itr2 = list2.iterator();
        while(itr2.hasNext())
        {
            System.out.println(itr2.next());
        }

    }
}