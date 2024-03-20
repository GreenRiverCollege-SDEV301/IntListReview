import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        System.out.println();
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

        //arrays in Java are fixed size
        int[] arrayOfNumbers = new int[10];

        IntList list1 = new ArrayIntList();
        IntList listA = new ArrayIntList();
        IntList list2 = new LinkedIntList();

        list1.addBack(11);
        list1.addBack(12);
        list1.addBack(13);
        list1.addBack(14);
        list1.addBack(15);
        list1.addBack(16);
        list1.addBack(17);
        list1.addBack(18);
        list1.addBack(19);
        list1.addBack(20);
        list1.addBack(21);
        list1.addBack(22);
        list1.addBack(23);
        System.out.println(list1);

        list1.addFront(24);
        System.out.println(list1);

        list1.removeBack();
        System.out.println(list1);

        list1.removeFront();
        System.out.println(list1);

        list1.add(3, 99);
        System.out.println(list1);

//        for (int value : list1)
//            System.out.println(value);

        System.out.println(listA.isEmpty());

        list1.remove(3);
        System.out.println(list1);

        System.out.println(list1.contains(13));

        System.out.println(list1.indexOf(10));

        list1.clear();
        System.out.println(list1);

        list2.addFront(9);
        list2.addBack(7);
        list2.addBack(4);

        list2.add(3,8);

        System.out.println(list2.toString());

        System.out.println( list2.isEmpty());

        System.out.println(list2.toString());

        System.out.println(list2.indexOf(7));

        System.out.println();

//        for (int value : list2) {
//            System.out.println(value);
//        }
//
        Iterator<Integer> itr2 = list2.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

    }
}