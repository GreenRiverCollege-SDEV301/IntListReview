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
    }
}