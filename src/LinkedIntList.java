import org.w3c.dom.Node;

import java.util.Iterator;

public class LinkedIntList implements IntList
{
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        Node next;
        int value;
        Node(int value)
        {
            this.value = value;
        }
    }


        public LinkedIntList (int value)
    {
        Node newNode = new Node (value);
        head = newNode;
        length = 1;
    }


    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value)     //completed
    {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)      //completed
    {
        Node newNode = new Node(value);
        Node current = head;

        if(head == null) head = tail = newNode;

        while(current.next != null)
        {
            current = current.next;
        }
//        tail.next = newNode;
//        tail = newNode;
        current.next = newNode;
        length++;

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
    public void add(int index, int value)       //completed
    {
        if(index < 0 || index > length)
        {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if(index == 0)
        {
            addFront(value);
        }

        else if(index == length)
        {
            addBack(value);
        }

        else
        {
            Node current = head;
            Node newNode = new Node(value);
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            Node after = current.next;
            current.next = newNode;
            newNode.next = after;

        }
        length++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        head = head.next;
        length--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()        //completed
    {
        Node current = head;
        while(current.next.next != null)
        {
            current = current.next;
        }

//        tail = current;
//        tail.next = null;
        current.next = null;
        length--;
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
    public int remove(int index)    //completed
    {
        if(index < 0 || index > length)
        {
            throw new IndexOutOfBoundsException("Index out of bound");
        }


        if(index == 0)
        {
            removeFront();
            length--;
        }

        if (index == length-1)
        {
            removeBack();
            length--;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++)
        {
            current = current.next;
        }
        Node temp = current.next;
        Node after = current.next.next;

        current.next = after;
        temp.next = null;

        length--;

        return temp.value;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)       //completed
    {
        if(index < 0 || index > length)
        {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        Node current = head;

        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }


        return current.value;
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
        while (current.next != null )
        {
            if(current.value == value)
            {
                return true;
            }
            current = current.next;
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
    public int indexOf(int value)       //completed
    {
        for (int i = 0; i < length; i++)
        {
            if (get(i) == value)
                return i;
        }

        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return length==0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()   //complete
    {
        return length;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() //completed
    {
        head = null;
        length = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return null;
    }

    @Override
    public String toString()
    {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(head == null)
        {
            sb.append("");
        }

        else
        {
            sb.append(current.value);
            while (current.next != null)    //why .next ??
            {
                current = current.next;
                sb.append(", ");
                sb.append(current.value);
            }
        }

            sb.append("]");
            return sb.toString();


    }
}
