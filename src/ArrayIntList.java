import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayIntList implements IntList
{

    private static int INITIAL_CAPACITY = 10;
    private int[] buffer;
    private int size;

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
    //slow 1(n)
    @Override
    public void addFront(int value)
    {
        //backwards for loop that ends at 1 instead of 0 this way the list is incremented by 1
        size++;
        for (int i = size; i > 0; i--)
        {
            buffer[i] = buffer[i - 1];
        }
        buffer[0] = value;
    }
    //slow, linear time, 0(size)
    private void resize(int newSize)
    {
        int[] temp = new int[newSize];
        for (int i = 0; i < size; i++)
        {
            temp[i] = buffer[i];
        }
        buffer = temp;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    //fast 0(1)
    @Override
    public void addBack(int value)
    {
        //set the value then increment size
        if (size == buffer.length)
        {
            //resize the buffer
            resize(size * 2);
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

    //the run time can be as good as addBack or as slow as addFront.
    //worst case 0(n). best case 0(1)
    //average case -0(1/2n)
    @Override
    public void add(int index, int value)
    {
        //ensure the index isnt out of range
        if (index < size + 2)
        {
            int[] temp = new int[size+1];
            //fill the first half of the array
            for (int i = 0; i < index; i++)
            {
                temp[i] = buffer[i];
            }
            //fill desired value
            temp[index] = value;
            //fill last half of array
            for (int i = index; i < size; i++)
            {
                temp[i+1] = buffer[i];

            }
            buffer = temp;
            size++;
        }
        else
        {
            throw new IllegalStateException("Index out of range please be between 0 and " + size+1);
        }


    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    // Relatively slow, linear time. 0(size) shift size items to the right
    @Override
    public void removeFront()
    {
        if(size == 0)
        {
            throw new IllegalStateException("Already Empty");
        }
        //note to self maybe do this without making another list. perhaps set 0 to index+1
        // and then index = index+1 throughout??
        int[] temp = new int[size];
        for (int i = 0; i < size-1; i++)
        {
            temp[i] = buffer[i+1];
        }
        size--;
        buffer = temp;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    //fast operation. constant time. 1(1)
    @Override
    public void removeBack()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Already Empty");
        }
        //size--;
        buffer[--size] = 0;
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
    //best case remove back 0(1). worst case remove front 0(n)
    @Override
    public int remove(int index)
    {
        if (index <= size)
        {
            //go to array index position
            int[] temp = new int[size];
            //fill the first half of the array
            for (int i = 0; i <= index; i++)
            {
                temp[i] = buffer[i];
                //System.out.print(temp[i]);
            }
            int removed = buffer[index];
            index++;
            //fill last half of array
            for (int i = index; i < size; i++)
            {
                temp[i-1] = buffer[i];

            }
            buffer = temp;
            size--;
            return removed;
        }
        else
        {
            throw new IllegalStateException("Index out of bounds");
        }

    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    //Fast, constant time 0(1)
    @Override
    public int get(int index)
    {
        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    //best case value is at the first index. worst case is at the end of the loop or not there
    //0(size)
    @Override
    public boolean contains(int value)
    {
        for (int i = 0; i < size; i++)
        {
            if (buffer[i] == value)
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
    //best case value is at the first index. worst case is at the end of the loop or not there
    //0(size)
    @Override
    public int indexOf(int value)
    {
        for (int i = 0; i < size; i++)
        {
            if (buffer[i] == value)
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
    //fast 0(1)
    @Override
    public boolean isEmpty()
    {
        if (size == 0)
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
    //fast 0(1)
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    //fast 0(1)
    @Override
    public void clear()
    {
        size = 0;
        buffer = new int[size];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        //return new instance of the helper class
        return new ArrayIntListIterator();
    }
    //0(n)
    public String toString()
    {
        if (size ==0)
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buffer[0]);
        for (int i = 1; i < size; i++)
        {
            sb.append(",");
            sb.append(buffer[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public class ArrayIntListIterator implements Iterator<Integer>
    {
        private int current = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            return (current < size);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws /NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next()
        {
            int value = get(current);
            current++;
            return value;
        }
    }
}
