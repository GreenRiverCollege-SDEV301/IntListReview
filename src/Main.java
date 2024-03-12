import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        IntList list = new LinkedIntList();
        System.out.println(list);
        list.addFront(9);
        list.addFront(3);
        list.addFront(10);
        list.addFront(12);
        System.out.println(list);

        // short way
        for(int value:list){
            System.out.println(value);
        }

        // long way
        /*
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        */


    }
}