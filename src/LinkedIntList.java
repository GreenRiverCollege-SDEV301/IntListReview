import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    //helper inner / nested class
    public class Node
    {
        int data;  //holds data for current node
        Node next; //holds address for next node

        public Node()
        {
            data = 0;
            next = null;
        }

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

    }//end of class node

    //fields for LinkedIntList class
    private Node head; // address for first node in list
    private int size; // number of nodes in list

    public LinkedIntList()
    {
        head = null;
        size = 0;
    }




    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value)
    {
        if(head == null)
        {
            //if the list is empty
            Node temp = new Node(value, head);
            head = temp;
        }
        else
        {
            //if the list is not empty
            head = new Node(value, head); // performs code on right side of equals sign first, so this works.
        }

        size++;

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        //check if list is empty
        if(head==null)
        {
            Node temp = new Node(value, head);
            head = temp;
        }
        else //if the list is not empty
        {
            Node current = head;

            //loop and stop on last node, but not all the way to null
            while (current.next != null) {
                //move current forward in the list
                current = current.next;
            }

            //when I get here - current is referencing the last node
            current.next = new Node(value, null);
        }
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value)
    {
        if(size<index)
        {
            //not enough elements in list
            throw new NoSuchElementException();
        }
        else if(index == 0)
        {
            addFront(value);
        }
        else
        {
            Node current = head;
            Node newNode = new Node(value,current.next);

            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            Node nextNode = current.next;
            current.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        if(head != null)
        {
            head = head.next;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        Node current = head;
        int count = 0;
        //loop and stop on last node, but not all the way to null
        while (current.next != null) {
            //move current forward in the list
            current = current.next;
            count++;
        }
        current = head;
        for (int i = 0; i < count-1; i++)
        {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if(size<index)
        {
            //not enough elements in list
            throw new NoSuchElementException();
        }
        else if(index == 0)
        {
            int removed = head.data;
            removeFront();
            return removed;
        }
        else
        {
            Node current = head;

            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            Node nextNode = current.next;
            int removed = current.next.data;
            current.next = nextNode.next;
            size--;
            return removed;
        }
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if(size<index)
        {
            //not enough elements in list
            throw new NoSuchElementException();
        }
        else if(index == 0)
        {
            return head.data;
        }
        else
        {
            Node current = head;

            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }
            return current.data;
        }
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)
    {
        Node current = head;
        int count = 0;
        //loop and stop on last node, but not all the way to null
        while (current != null) {
            if(current.data==value)
            {
                return true;
            }
            //move current forward in the list
            current = current.next;
            count++;
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        Node current = head;
        int count = 0;
        //loop and stop on last node, but not all the way to null
        while (current != null) {
            if(current.data==value)
            {
                return count;
            }
            //move current forward in the list
            current = current.next;
            count++;
        }
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if(size==0)
        {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        head = null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new LinkedIterator();
    }

    //helper method (not required, but nice to have)
    public void print()
    {
        // create a temporary variable (almost like an index i)
        // copy in the address from head and save it
        Node current = head;

        while(current!=null)
        {
            //print value inside of node
            System.out.println(current.data);

            //go to the next node
            current = current.next;
        }
    }

    @Override
    public String toString()
    {
        if(head==null)
        {
            //if list is empty
            return "[]";
        }

        //if it made it to this point, list is not empty
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;

        //stops one before the last node
        while(current.next != null)
        {
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }
        //manually adds the last node as to avoid having an extra comma in the string
        sb.append(current.data);


        sb.append("]");
        return sb.toString();
    }


    //helper class
    public class LinkedIterator implements Iterator<Integer>
    {

        private Node current;       //holds address of current node


        public LinkedIterator()
        {
            //start the current position at the first node in list
            current = head;
        }


        @Override
        public boolean hasNext() {
            if(current == null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        @Override
        public Integer next() {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            int result = current.data;
            current = current.next;
            return result;
        }
    }


}
