public class Main {
    public static void main(String[] args) {

        IntList list1 = new ArrayIntList();

        list1.addBack(42);
        list1.addBack(82);
        list1.addBack(97);
        list1.addBack(10);
        list1.addFront(30);

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0, 4);
//        System.out.println(list);
//        list1.remove(10);

        System.out.println(list1);
    }
}