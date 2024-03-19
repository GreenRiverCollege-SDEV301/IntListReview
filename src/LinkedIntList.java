import java.util.Iterator;

public class LinkedIntList implements IntList
{

    // helper inner/nested class
    public class Node
    {
        int date;   // holds the data value
        Node next;  // holds address of next node

        public Node()
        {
            date = 0;
            next = null;
        }

        // T = 2 is O(1) constant time
        public Node(int date, Node next)
        {
            this.date = date;
            this.next = next;
        }

        // rnd of class Node
    }

    // fields for LinkedIntLis class

    private Node head;  // address of first node in list
    private int size;   // number of nodes/items in list


    /**
     *
     * T = 2 is O(1) constant
     */
    public LinkedIntList()
    {
        head = null;
        size = 0;

    }

    /**
     *
     * T = 7 is O(1) constant time
     */
    @Override
    public void addFront(int value)
    {

//        // if the list is empty
//        if (head == null)
//        {
//            head = new Node(value, null);
//
//        }
//        else
//        {
//            // if the list is not empty
//            head = new Node(value, head);
//        }

        head = new Node(value, head);

//        Node temp = new Node((value, head);
//        head = temp;
        size++;

    }


    /**
     *
     * if list is empty (go into if), T = 5 which is O(1) constant time
     * if list is not empty (go into else), T = 2 * size + 6, which is O(n) linear
     *                                      T = 2n +6, which is O(n) linear
     * @param value value to be inserted
     */

    @Override
    public void addBack(int value)
    {
        // if the list is empty
        if (head == null)
        {
            head = new Node(value, null);

        }

        else
        {
            // if the list is not empty
            Node current = head;

            // loop and stop on last node in list
            // (but not all the way to null)
            while (current.next != null)
            {
                // move current forward:
                current = current.next;
            }

            // when I am here - current is referring the last node
            current.next = new Node(value,null);
        }

        size++;

    }

    @Override
    public void add(int index, int value)
    {

        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0)
        {
            addFront(value);
        }
        else
        {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            current.next = new Node(value, current.next);
            size++;
        }

    }

    @Override
    public void removeFront()
    {
        if (head != null)
        {
            head = head.next;
            size--;
        }

    }

    @Override
    public void removeBack()
    {
        if (head == null) return;
        if (head.next == null)
        {
            head = null;
        }
        else
        {
            Node current = head;
            while (current.next.next != null)
            {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    @Override
    public int remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0)
        {
            int value = head.date;
            removeFront();
            return value;
        }
        else
        {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            int value = current.next.date;
            current.next = current.next.next;
            size--;
            return value;
        }
    }

    @Override
    public int get(int index)
    {

        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current.date;
    }

    @Override
    public boolean contains(int value)
    {
        Node current = head;
        while (current != null)
        {
            if (current.date == value)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(int value)
    {
        Node current = head;
        int index = 0;
        while (current != null)
        {
            if (current.date == value)
            {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<Integer> iterator()
    {
//        LinkedIterator iterator = new LinkedIterator();
//        return iterator;
        return new LinkedIterator();
    }

    // helper method (not required, but nice example to reference)
    public void print()
    {
        // create a temp variable (almost an index i)
        // copy in the address from head and save it
        Node current = head;

//        // print the value inside the node
//        System.out.println(current.date);
//
//        // go to the next node
//        current = current.next;

        while (current != null)
        {

            // print the value inside the node
            System.out.println(current.date);

            // go to the next node
            current = current.next;
        }

    }

    @Override
    public String toString()
    {
        if (head == null)
        {
            // if list is empty, indicate with []
            return "[]";
        }

        // if I get here, the list is not empty for sure
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;

        // stop one before the last node
        while (current.next != null)
        {
            sb.append(current.date);
            sb.append(", ");

            current = current.next;
        }

        // add in the last node
        sb.append(current.date);

        sb.append("]");
        return sb.toString();

    }

    // helper class
    public class LinkedIterator implements Iterator<Integer>
    {

        // keep  track of my current position
        private Node current;   //holds address of current node

        public LinkedIterator()
        {
            // start the current position at the first node in list
            current = head;
        }
        @Override
        public boolean hasNext()
        {


            return (current !=null);
//            if (current == null)
//            {
//                return false;
//            }
//            else
//            {
//                return true;
//            }

        }

        @Override
        public Integer next()
        {
            int result = current.date;
            current = current.next;
            return null;
        }
    }
}
