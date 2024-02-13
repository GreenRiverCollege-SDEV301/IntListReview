//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        IntList list1 = new ArrayIntList();
        //IntList list2 = new LinkedIntList();

        list1.addBack(1);
        list1.addBack(2);
        list1.addBack(3);
        list1.addBack(4);
        list1.add(2, 5);
        list1.addFront(9);
        list1.removeBack();
        list1.removeFront();
        list1.clear();
        list1.addBack(1);
        list1.addBack(2);
        list1.addBack(3);
        list1.addBack(1);
        list1.addBack(2);
        list1.addBack(3);
        list1.addBack(1);
        list1.addBack(2);
        list1.addBack(3);
        list1.addBack(1);
        list1.addBack(2);
        list1.addBack(3);

        System.out.println(list1);

        System.out.println(list1.contains(2));
        System.out.println(list1.indexOf(2));
        System.out.println(list1.contains(4));
        System.out.println(list1.indexOf(4));
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        list1.clear();
        System.out.println(list1.isEmpty());
        list1.addBack(5);
        System.out.println(list1.isEmpty());
        list1.removeFront();
        System.out.println(list1.isEmpty());

        list1.addBack(1);
        list1.addBack(2);
        list1.addBack(3);
        list1.addBack(4);
        list1.add(2, 5);
        list1.addFront(9);
        System.out.println(list1);
        System.out.println(list1.get(2));
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);


    }
}