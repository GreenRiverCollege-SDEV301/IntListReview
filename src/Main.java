//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        IntList list1 = new ArrayIntList();
       IntList list2 = new LinkedIntList();



        list1.addBack(11);
        list1.addBack(22);


        System.out.println(list1);
        list1.removeBack();
        System.out.println(list1);
        list1.addBack(88);
        System.out.println(list1);
        list1.removeFront();
        System.out.println(list1);
        list1.addFront(12);
        System.out.println(list1);
        list1.add(1,88);
        System.out.println(list1);
        list1.addBack(222);
        list1.addBack(333);
        System.out.println(list1);


        list1.remove(2);
        System.out.println(list1);

        System.out.println(list1.contains(11));

     System.out.println(list1.indexOf(11));

     System.out.println(list1.isEmpty());

//     list1.clear();
//     System.out.println(list1);


     list1.add(3, 69);
     System.out.println(list1);










    }
}