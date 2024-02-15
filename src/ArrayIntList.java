import java.util.Iterator;

public class ArrayIntList implements IntList
{
    // internal (private) representation
    private int[] buffer;
    private int size; //number of "spots used" in the buffer
    private final static int INITIAL_CAPACITY = 10;

    public ArrayIntList(){
        buffer = new int[INITIAL_CAPACITY];
        size  = 0 ;
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
        resize(2*buffer.length);
        for (int i = size; i >= 1; i--)
        {
            buffer[i]=buffer[i-1];
        }
        buffer[0]=value;
        size++;

//        if(size == buffer.length){
//            //if the size meathces the capacity then i know
//            //I need to resize the size of the buffer
//            //
//            resize(2*buffer.length);
//        }
//        for (int i = size; i >=1; i--)
//        {
//            buffer[i]= buffer[i-1];
//        }
//        //but value in position [0]
//        buffer[0]= value;
//        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        if(size == buffer.length){
            //if the size meathces the capacity then i know
            //I need to resize the size of the buffer
            //
            resize(2*buffer.length);
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        resize(2*buffer.length);
        for (int i = size; i >=index+1 ; i--)
        {
            if(size<index)
            {
                System.out.println("index is out of range");
                break;
            }
            buffer[i] = buffer[i-1];
        }
        buffer[index]=value;
        size++;

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        for (int i = 0; i < size; i++)
        {
            buffer[i]=buffer[i+1];
        }
        buffer[size-1]= 0;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if(size==0){
     throw new IllegalArgumentException("already empty!");
    }
        size--;
        buffer[size] = 0; // 这一行需要保留。 否则buffer里的数据依然会保存。
        //总体来说是安全原因，

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
        return 0;
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
        if(index <0 || index>=size) {
            throw new IndexOutOfBoundsException("index is out of range");
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
        for (int i = 0; i < size; i++)
        {
            if(buffer[i] == value)
                return true;
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
        for (int i = 0; i < size; i++)
        {
            if(buffer[i] == value){
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
        if (size<1) return true;
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
        for (int i = 0; i < size; i++)
        {
            buffer[i] = 0;
        }
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
        return new Iterator<Integer>()
        {
            @Override
            public boolean hasNext()
            {
                return false;
            }

            @Override
            public Integer next()
            {
                return null;
            }
        };
    }

    @Override
    public String toString(){
        if(size == 0){
            return"[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        sb.append(buffer[0]); // we know there is at least a value at[0]
        // then start at [1];
        for (int i = 1; i < size; i++)
        {

            sb.append(", " );
            sb.append(buffer[i]);
        }

        sb.append("]");
        return sb.toString();
    }

    private void resize(int newSize){
        // crete a new array that is of the new size
        int [] temp = new int[newSize];


        // copy over values form the exiting buffer
        for (int i = 0; i < size; i++)
        {
            temp[i] = buffer[i];
        }

        // make the switchover
        buffer = temp;
    }
}
