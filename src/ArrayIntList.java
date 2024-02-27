import java.util.Iterator;
import java.util.NoSuchElementException;

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
    // Normally fast (constant time unless you have to resize)
    public void addBack(int value)
    {
        checkSize();
        buffer[size] = value;
        size++;
    }

    @Override
    //Slow must move every element in array O(N)
    public void addFront(int value)
    {
        checkSize();
        add(0, value);
    }

    @Override
    //Slow, must move every element in array located above entry index O(N)
    public void add(int index, int value)
    {
        checkSize();
        size ++;
        checkIndex(index);
        for(int i = size; i > index;  i--)
        {
            buffer[i] = buffer[i-1];
        }
        buffer[index] = value;
    }

    @Override
    // Fast, constant time.
    public void removeBack()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Attempt to remove from empty arrayList.");
        }
        size--;
    }

    @Override
    //Slow must move every element in array O(N)
    public void removeFront()
    {
        remove(0);
    }

    @Override
    //Slow, must move every element in array located above entry index O(N)
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
    //Very fast operation. O(1) constant time
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
    // Slow because you must "touch" every element in array to copy to new array O(N)
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
        return new ArrayIntListIterator();
    }

    private class ArrayIntListIterator implements Iterator<Integer>
    {
      private int position;

      public ArrayIntListIterator()
      {
          position = 0;
      }

      public boolean hasNext()
      {
          return position != size;
      }

      public Integer next()
      {
          if(hasNext())
          {
              Integer output = buffer[position];
              position++;
              return output;
          }
          throw new NoSuchElementException("No elements left.");
      }
    }
}
