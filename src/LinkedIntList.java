import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList  implements IntList
{
    int size;
    IntNode headNode;
    IntNode tailNode;
    public LinkedIntList()
    {
        size = 0;
    }
    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     * This is a fast function. O(1), no loops required.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value)
    {
        if(size == 0)
        {
            headNode = new IntNode(value);
            tailNode = headNode;
        }
        else
        {
            headNode = new IntNode(value, headNode);
        }
        size++;
    }

    @Override
    public void addBack(int value)
    {
        if(size == 0)
        {
            headNode = new IntNode(value);
            tailNode = headNode;
        }
        else
        {
            tailNode.setNext(new IntNode(value));
            tailNode = tailNode.nextNode();
        }
        size++;
    }

    @Override
    public void add(int index, int value) throws IndexOutOfBoundsException
    {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException(index + " is outside Array.");
        }
        if(index == 0)
        {
            addFront(value);
        }
        else if(index == size-2)
        {
            addBack(value);
        }
        else
        {
            IntNode tempNode = headNode;
            for (int i = 0; i < index -1; i ++)
            {
                tempNode = tempNode.nextNode();
            }
            tempNode.setNext(new IntNode(value, tempNode.nextNode()));
            size++;
        }
    }

    @Override
    public void removeFront()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Attempt to remove from empty arrayList.");
        }
        if(size == 1)
        {
            clear();
        }
        else {
            headNode = headNode.nextNode();
            size--;
        }
    }

    @Override
    public void removeBack()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Attempt to remove from empty arrayList.");
        }
        if(size == 1)
        {
            clear();
        }
        else
        {
            remove(size - 1);
        }
    }

    @Override
    public int remove(int index)
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Attempt to remove from empty arrayList.");
        }
        checkIndex(index);
        if(size == 1)
        {
            int returnValue = headNode.innerValue;
            clear();
            return returnValue;
        }
        if(index == 0)
        {
            int returnValue = headNode.innerValue;
            removeFront();
            return returnValue;
        }
        else
        {
            IntNode tempNode = headNode;
            int returnValue;
            for (int i = 0; i < index - 1; i++)
            {
                tempNode = tempNode.nextNode();
            }
            returnValue = tempNode.nextNode().innerValue;
            if (index == size - 1)
            {
                tailNode = tempNode;
            }
            tempNode.setNext(tempNode.nextNode().nextNode());
            size--;
            return returnValue;
        }
    }

    @Override
    public int get(int index)
    {
        checkIndex(index);
        if(index == size-1)
        {
            return tailNode.innerValue;
        }
        else
        {
            IntNode tempNode = headNode;
            for(int i = 0; i < index; i++)
            {
                tempNode = tempNode.nextNode();
            }
            return tempNode.innerValue;
        }
    }

    @Override
    public boolean contains(int value)
    {
        IntNode tempNode = headNode;
        for(int i = 0; i < size; i++)
        {
            if(tempNode.innerValue == value)
            {
                return true;
            }
            tempNode = tempNode.nextNode();
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        IntNode tempNode = headNode;
        for(int i = 0; i < size; i++)
        {
            if(tempNode.innerValue == value)
            {
                return i;
            }
            tempNode = tempNode.nextNode();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear()
    {
        headNode = null;
        tailNode = null;
        size = 0;
    }

    @Override
    public String toString()
    {
        StringBuilder outputString = new StringBuilder("[");
        if(headNode!= null)
        {
            outputString.append(headNode.innerValue);
            IntNode tempNode = headNode;

            while (tempNode.nextNode() != null) {
                tempNode = tempNode.nextNode();
                outputString.append(", ").append(tempNode.innerValue);
            }
        }
        outputString.append("]");
        return outputString.toString();
    }
    private void checkIndex(int index) throws IndexOutOfBoundsException
    {
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException(index + " is outside Array.");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIntListIterator();
    }
    private class LinkedIntListIterator implements Iterator<Integer>
    {
        private IntNode position;

        public LinkedIntListIterator()
        {
            position = headNode;
        }

        public boolean hasNext()
        {
            return position != null;
        }

        public Integer next()
        {
            if(position != null)
            {
                Integer output = position.innerValue;
                position = position.nextNode();
                return output;
            }
            throw new NoSuchElementException("No elements left.");
        }
    }
    private static class IntNode
    {
        public int innerValue;
        private IntNode nodePointer;

        public IntNode( int x )
        {
            this(x, null);
        }
        public IntNode ( int x, IntNode connect)
        {
            innerValue = x;
            nodePointer = connect;
        }
        public IntNode nextNode()
        {
            return nodePointer;
        }
        public void setNext(IntNode x)
        {
            nodePointer = x;
        }
        public boolean hasNext()
        {
            return nodePointer != null;
        }
    }
}
