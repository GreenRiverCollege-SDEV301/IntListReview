import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        //Noted. arrays in java are fixed sized
        int[] arrayOfNumbers = new int[10];

        IntList list1= new ArrayIntList();
        IntList list2 = new LinkedIntList();

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);




        System.out.println(list1);

//        list1.removeBack();
//        System.out.println("removeBack"+list1);

        list1.addFront(77);
        System.out.println("addFront"+list1);

        list1.add(2, 11);
        System.out.println("add "+list1);

        list1.removeFront();
        System.out.println("removeFront "+ list1);

        System.out.println("index 0 is "+list1.get(0));
        System.out.println("contain value 42: " + list1.contains(42));
        System.out.println("contain value 38 " + list1.contains(38));

        System.out.println("Index of 42: "+ list1.indexOf(42));
        System.out.println("Index of 38: "+ list1.indexOf(38));

        System.out.println("check if empty: "+list1.isEmpty());

        System.out.println("size is :"+ list1.size());

//        list1.clear();
//        System.out.println(list1);

        Iterator<Integer> it = list1.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
    }
}