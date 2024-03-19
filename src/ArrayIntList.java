import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList
{

    // internal (private) representation
    private int [] buffer;
    private int size;  // num of "spots used" in the buffer


    private final static int INITIAL_CAPACITY = 10;
    public ArrayIntList()
    {
        buffer = new int[INITIAL_CAPACITY];
        size = 0;
    }



    @Override
    public void addFront(int value)
    {

        //check if full
        if (size == buffer.length)
        {
            resize(2 * buffer.length);
        }

        // open a spot at index 0  where value will be saved
        // shift everything over to the right by 1 position
        for (int i = size; i >= 1; i--)
        {
            buffer[i] = buffer[i - 1];
        }

        // put value in position [0]
        buffer[0] = value;
        size++;
    }

    private void resize(int newSize)
    {
        // create a new array that is of the new size

        int [] temp = new int[newSize];

        // copy over values from existing buffer

        for (int i = 0; i <size ; i++)
        {
            temp[i] = buffer[i];

        }
        //make the switchover

        buffer = temp;


    }

    @Override
    public void addBack(int value)
    {

        // TODO: check to see if we still have room (capacity)

        if (size == buffer.length)
        {
            // if the size matches the capacity, then I know I'm "full"
            // and I need to resize (create a new larger buffer and copy
            // the values over from the older smaller buffer)

            resize(2 * buffer.length);

        }
        buffer[size] = value;
        size++;

        // test

    }

    @Override
    public void add(int index, int value)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        if (size == buffer.length)
        {
            resize(2 * buffer.length);
        }

        // Shift elements to the right
        for (int i = size; i > index; i--)
        {
            buffer[i] = buffer[i - 1];
        }
        buffer[index] = value;
        size++;
    }

    @Override
    public void removeFront()
    {
        if (size > 0)
        {
            remove(0);
        }
    }

    @Override
    public void removeBack()
    {

        if (size == 0)
        {
            throw new IllegalStateException("Already empty");
        }


        size--;
        buffer[size] = 0;
//        buffer[--size] = 0;

    }

    @Override
    public int remove(int index)
    {
        if (index < 0 || index >= size)
        {
//            throw new IndexOutOfBoundsException();

            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        int removedElement = buffer[index];
        for (int i = index; i < size - 1; i++)
        {
            buffer[i] = buffer[i + 1];
        }
        size--;
        return removedElement;
    }

    @Override
    public int get(int index)
    {
        return buffer[index];
    }

    @Override
    public boolean contains(int value)
    {
        return indexOf(value) != -1;
    }

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
        size = 0;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        // return a new instance of the helper iterator (below)

        return new ArrayIntListIterator();
    }

    @Override
    public String toString()
    {
        if (size == 0)
        {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buffer[0]);

        for (int i = 1; i <size ; i++)
        {
            sb.append(", ");
            sb.append(buffer[i]);

        }

        sb.append("]");
        return sb.toString();
    }

    // nested or inner class (helper class)
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
            return (currentPosition < size);
        }

        @Override
        public Integer next()
        {
            // Just to be safe - make sure there is a next
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            int value = get(currentPosition);

            currentPosition++;
            return value;
        }
    }


    // end of ArrayIntList
}
