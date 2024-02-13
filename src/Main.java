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
    }
}