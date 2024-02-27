import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
       int[] arrayOfNumbers = new int[10];
       IntList list1 = new ArrayIntList();
       IntList list2 = new LinkedIntList();

       list1.addBack(42);
       list1.addBack(82);
       list1.addBack(97);
       list1.addBack(42);
       list1.addBack(82);
       list1.addBack(97);
       list1.addBack(42);
       list1.addBack(82);
       list1.addBack(97);
       list1.addBack(42);
       list1.addBack(82);
       list1.addBack(97);

        System.out.println(list1.toString());

        list1.removeBack();
        System.out.println(list1.toString());
        System.out.println("adding to front");
        list1.addFront(100);
        list1.addFront(101);
        System.out.println(list1.toString());
        list1.removeFront();
        System.out.println(list1.toString());
        list1.add(4,99);
        System.out.println(list1.toString());
        System.out.println("Contains 99: "+list1.contains(99));
        list1.remove(4);
        System.out.println(list1.toString());
        System.out.println("Contains 99: "+list1.contains(99));
        System.out.println(list1.get(4));

        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

        list2.addBack(100);
        list2.addBack(101);
        list2.addBack(102);
        System.out.println(list2.toString());
        System.out.println("list2 size: " + list2.size());
        list2.removeBack();
        System.out.println(list2.toString());
        System.out.println("List2 size" + list2.size());
        list2.addBack(102);
        list2.addBack(103);
        list2.addBack(104);
        System.out.println(list2.contains(9));
        System.out.println(list2.contains(102));


    }
}