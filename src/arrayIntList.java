import java.util.Iterator;
import java.util.NoSuchElementException;

public class arrayIntList implements IntList {
    //internal (private) representation
    private int[] buffer;
    private int size;
    private final static int INITIAL_CAPACITY = 10;
    public arrayIntList()
    {
        buffer = new int[INITIAL_CAPACITY];
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
        //check to see if we still have room (capacity)
        if(size == buffer.length)
        {
            //if size matches capacity, then I know that it is full and I need to resize (create new larger buffer and
            //copy  values from older smaller buffer

            // make newSize double existing capacity
            resize(buffer.length*2);


        }
        int[] temp = new int[buffer.length+1];
        temp[0] = value;
        for (int i = 1; i < buffer.length+1; i++)
        {
            temp[i] = buffer[i-1];
        }
        size++;
        buffer = temp;
    }

    private void resize(int newSize)
    {
        //create new array that is of the new size
        int[] temp = new int[newSize];

        //copy over values from old buffer
        for (int i = 0; i < buffer.length; i++)
        {
            temp[i] = buffer[i];
        }

        //make the switchover
        buffer = temp;

        //buffer and temp are the same
        /*
        buffer[2] = 88;
        System.out.println(temp[2]); will print 88 as well
         */
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */

    @Override
    public void addBack(int value)
    {
        //check to see if we still have room (capacity)
        if(size == buffer.length)
        {
            //if size matches capacity, then I know that it is full and I need to resize (create new larger buffer and
            //copy  values from older smaller buffer

            // make newSize double existing capacity
            resize(buffer.length*2);


        }

        buffer[size] = value;
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
        if(size == buffer.length)
        {
            //if size matches capacity, then I know that it is full and I need to resize (create new larger buffer and
            //copy  values from older smaller buffer

            // make newSize double existing capacity
            resize(buffer.length*2);

        }
        if(index > buffer.length||index<0)
        {
            throw new IndexOutOfBoundsException("Index out of bounds, please select a valid index");
        }
        int[] temp = new int[buffer.length+1];
        temp[index] = value;
        for (int i = 0; i < buffer.length; i++)
        {
            if(i!=index)
            {
                temp[i] = buffer[i];
            }
        }
        size++;
        buffer = temp;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        if(size==0)
        {
            throw new IllegalStateException("already empty!");
        }
        int[] temp = new int[buffer.length-1];
        for (int i = 1; i < buffer.length; i++)
        {
            temp[i-1] = buffer[i];
        }
        size--;
        buffer = temp;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if(size==0)
        {
            throw new IllegalStateException("already empty!");
        }
        size--;
        buffer[size] = 0;
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
        if(size==0)
        {
            throw new IllegalStateException("already empty!");
        }
        if(index > buffer.length||index<0)
        {
            throw new IndexOutOfBoundsException("Index out of bounds, please select a valid index");
        }
        int oldValue = buffer[index];
        int[] temp = new int[buffer.length-1];
        for (int i = 0; i < buffer.length; i++)
        {
            if(i<index)
            {
                temp[i] = buffer[i];
            }
            else if(i>index)
            {
                temp[i-1] = buffer[i];
            }
        }
        size--;
        buffer = temp;
        return oldValue;
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
        if(index > buffer.length||index<0)
        {
            throw new IndexOutOfBoundsException("Index out of bounds, please select a valid index");
        }
        return buffer[index];
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
        for (int i = 0; i < buffer.length; i++)
        {
            if(buffer[i]==value)
            {
                return true;
            }
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
    public int indexOf(int value)
    {
        for (int i = 0; i < buffer.length; i++)
        {
            if(buffer[i]==value)
            {
                return i;
            }
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
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public String toString()
    {
        if(size==0)
        {
            return "[]";
        }


        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++)
        {
            sb.append(buffer[i]);
            if(i<size-1)
            {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }



    public class ArrayIntListIterator implements Iterator<Integer>
    {
        private int currentPosition;

        public ArrayIntListIterator()
        {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext()
        {
            if(currentPosition < size)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        @Override
        public Integer next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }
}
