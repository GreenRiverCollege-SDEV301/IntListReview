import java.util.Iterator;

public class LinkedIntList implements IntList
{
    //helper inner/nested class for Nodes
    public class Node
    {
        int data;
        Node next;

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
    }
    //end of class Node
    private Node head;
    private int size;

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
        //this works due to if the list is null then we will simply assign next as null
        Node temp = new Node(value, head);
        head = temp;
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
        //check if head is null
        if(head == null)
        {
            head = new Node(value, null);
        }
        //move through the list and add back value
        else
        {
            Node temp = head;
            //go through list until find the end
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new Node(value, null);
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
    @Override //MUST BE FIXED
    public void add(int index, int value)
    {
        try
        {
            if (index == 0)
            {
                addFront(value);
            }
            else
            {
                Node temp = head;
                for (int i = 0; i < index; i++)
                {
                    temp = temp.next;
                }
                Node insert = new Node(value, temp.next);
                temp.next = insert;
            }

            size++;
        }
        catch (NullPointerException e)
        {
            throw new NullPointerException("Index out of bounds");
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
        if (head.next != null)
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
        //check if empty
        if (head != null)
        {
            Node temp = head;
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
            size--;
        }
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
    public int remove(int index)
    {
        Node temp = head;
        for (int i = 0; i < index; i++)
        {
            if (temp.next != null)
            {
                temp = temp.next;
            }
        }

        //store removed data in order to return
        int removedData = temp.next.data;
        if (temp.next.next != null)
        {

            temp.next = temp.next.next;
        }
        size--;
        return removedData;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)
    {
        try
        {
            Node temp = head;
            for (int i = 0; i < index; i++)
            {
                temp = temp.next;
            }
            return temp.data;
        }
        catch (NullPointerException e)
        {
            throw new NullPointerException("Index out of bounds");
            //System.out.println("Null Pointer Exception Error");
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
        Boolean found = false;
        if (head != null)
        {
            Node temp = head;

            while (temp != null)
            {
                if (temp.data == value)
                {
                    found = true;
                    break;
                }
                temp = temp.next;
            }
        }
        return found;
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
    public int indexOf(int value)
    {
        Node temp = head;
        int index = 0;
        while(temp != null)
        {
            if (temp.data == value)
            {
                return index;
            }
            temp = temp.next;
            index++;
        }
        throw new IllegalStateException("Index out of bounds");
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        if (head == null)
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
        size = 0;
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

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Head -> ");
        Node temp = head;
        while(temp != null)
        {
            sb.append(" [" + temp.data + "]");
            temp = temp.next;
        }
        return sb.toString();
    }

    //helper method not required but nice to have as reference
    public void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public class LinkedIterator implements Iterator<Integer>
    {
        //keep track of current position
        private Node current;

        public LinkedIterator()
        {
            //construct iterator at first Node.
            current = head;
        }

        @Override
        public boolean hasNext()
        {
            if(current == null)
            {
                return false;
            }
            return true;
        }

        @Override
        public Integer next()
        {
            int result = current.data;
            current = current.next;
            return result;
        }
    }
}
