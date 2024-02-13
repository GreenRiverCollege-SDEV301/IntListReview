import java.util.Iterator;

public class ArrayIntList  implements  IntList
{
    private int[] buffer;
    private int size;
    public ArrayIntList()
    {
        buffer = new int[10];
        size = 0;
    }

    @Override
    public void addFront(int value)
    {
        checkSize();
        buffer[size] = value;
        size++;
    }

    @Override
    public void addBack(int value)
    {
        checkSize();
        add(0, value);
    }

    @Override
    public void add(int index, int value)
    {
        checkSize();
        for(int i = size; i > index;  i--)
        {
            buffer[i] = buffer[i-1];
        }
        buffer[index] = value;
        size ++;
    }

    @Override
    public void removeFront()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Attempt to remove from empty arrayList.");
        }
        size--;
    }

    @Override
    public void removeBack()
    {
        remove(0);
    }

    @Override
    public int remove(int index)
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Attempt to remove from empty arrayList.");
        }
        checkIndex(index);
        int returnInt = buffer[index];
        for(int i = index; i < size;  i++)
        {
            buffer[i] = buffer[i + 1];
        }
        size --;
        return returnInt;
    }

    @Override
    public int get(int index)
    {
        checkIndex(index);
        return buffer[index];
    }

    @Override
    public boolean contains(int value)
    {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(int value)
    {
        for (int i = 0; i < size; i++)
        {
           if(buffer[i] == value) {
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
        buffer = new int[10];
        size = 0;
    }
    private void checkIndex(int index) throws IndexOutOfBoundsException
    {
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException(index + " is outside Array.");
        }
    }

    public String toString()
    {
        if(size == 0)
        {
            return "[]";
        }
        else
        {
            StringBuilder returnString = new StringBuilder();
            returnString.append("[").append(buffer[0]);
            for(int i = 1; i < size; i++)
            {
                returnString.append(", ").append(buffer[i]);
            }
            returnString.append("]");
            return returnString.toString();
        }
    }
    private void checkSize()
    {
        if(size > buffer.length - 2)
        {
            buffer = resize();
        }
    }

    private int[] resize() {
        int[] returnInt = new int[buffer.length * 2];

        for (int i = 0; i < size; i++)
        {
            returnInt[i] = buffer[i];
        }
        return returnInt;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
