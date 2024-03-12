import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements  IntList
{
    //internal (private) representation
    private int[] buffer;
    private int size;

    private static  final  int INITIAL_CAPACITY = 10;   //constant for initial array size

    //constructor to initialize the variables on the top
    public ArrayIntList()
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
    public void addFront(int value) //completed
    {
        if(size == buffer.length)
        {
            resize(2* buffer.length);
        }

        for (int i = size; i > 0 ; i--) //start from the back
        {

            buffer[i] = buffer[i -1]; //shifting all values one index back

        }

        buffer[0] = value; //put value in position [0]

        size++;

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)  //completed
    {

        //Tddd: check to see if we still have room (capacity) to handle index out of bound exception
        if(size == buffer.length)
        {
            //if the size matches the capacity, then resize (create a new larger buffer and copy)
            // switch the values over from the older smaller buffer

            //make a new array with length twice as long
            resize(2 * buffer.length);

        }

        buffer[size] = value;
        size++;
    }

    private void resize (int newSize)       //completed
    {
        //create a new array that is of the new size
        int[] temp = new int[newSize];


        //copy over values from the existing buffer
        for (int i = 0; i < size; i++)
        {
            temp[i] = buffer[i];
        }

        //make the switchover
        buffer = temp;
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
    public void add(int index, int value)   //completed
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if(index == 0)
        {
            addFront(value);
        }
        else if (index > size-1)
        {
            addBack(value);
        }
        else
        {
            for (int i = buffer.length - 1; i > index; i--)
            {
                    buffer[i] = buffer[i - 1];
            }
            buffer[index] = value;
        }
        size++;

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()   //completed
    {
        if(size == 0)
        {
            throw new IllegalStateException("already empty!");
        }

        buffer[0] = 0;
        for (int i = 0; i < size; i++)
        {
            buffer[i] = buffer[i + 1];
        }
        size--;


    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
//    ??
    public void removeBack()    //completed
    {
        if(size == 0)
        {
            throw new IllegalStateException("already empty!");
        }

        buffer[size] = 0;
        size --;        //to get the last index, because size is last index.next



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
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if (size == 0)
        {
            throw new IllegalStateException("already empty!");
        }

        int temp = buffer[index];

        for (int i = index; i <size ; i++)
        {
            buffer[i] = buffer[i + 1];
        }

        size--;
        return temp;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)   //complete
    {
        if(index < 0 || index > size-1)
        {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        int temp = buffer[index];

        return temp;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)  //completed
    {
        for (int i = 0; i < size ; i++)
        {
            if(buffer[i] == value) return true;

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
    public int indexOf(int value)   //completed
    {
        int index = -1;

        for (int i = 0; i < size ; i++)
        {
            if(buffer[i] == value) index = i;

        }
        return index;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()    //completed
    {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()   //completed
    {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() //completed
    {
        size =0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        //return a new instance of the helper iterator class (below)
        return new ArrayIntListIterator();
    }

    @Override //Meaning this toString method is overwriting the toString method in the parents class
    public String toString()
    {
        if(size == 0)
        {
            return "[]";
        }
        //prints out the list using stringbuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buffer[0]);

        for (int i = 1; i < size; i++)
        {
            sb.append(", ");
            sb.append(buffer[i]);

        }

        sb.append("]");
        return sb.toString();
    }

    //nested or inner class (helper class)
    public class ArrayIntListIterator implements Iterator<Integer>
    {
        private int currentPosition;

        public ArrayIntListIterator()
        {
            currentPosition = 0;
        }

        public boolean hasNext()
        {
            return (currentPosition < size());  //if < return true, else return false
        }

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
