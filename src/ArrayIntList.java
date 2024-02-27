import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList{
    //internal (private) representation
    private int[] buffer;
    private int size;              // number of "spots used" in the int buffer
    private final int INITIAL_CAPACITY = 10;
    public ArrayIntList() {
        buffer = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     * <p>
     * Slow, linear time O(size) - shifts size items right
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        // check if full
        if (size == buffer.length) {
            resize(2*buffer.length);
        }

        // open a spot at index 0 where value will be saved
        // shift everything over to the right by 1 position
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i-1];
        }

        //put value in position[0]
        buffer[0] = value;
        size++;
    }

    // slow method, linear time O(n)
    private void resize(int newSize) {
        // create a new array that is of the new size
        int[] temp = new int[newSize];

        // copy over values from the existing buffer
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }

        // make the switchover
        buffer = temp;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     * <p>
     * Fast, constant time if no resize, O(1)
     * can be slow if resize is needed
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            // if the size matches the capacity, then I know I'm "full"
            // and I need to resize (create a new larger buffer and copy
            // the values over from the older smaller buffer)

            // make the resize twice the existing capacity
            resize(2*buffer.length);
        }

        buffer[size] = value;
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     * <p>
     * worst case add at index and resize - O(n) - linear <p>
     * best case add at index size  - - - - O(1) - constant <p>
     * average case - - - - - - - - - - - - O(1/2n)
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * <p>
     * Shifts any subsequent values to the left.
     * slow, constant time, O(size)/O(n)
     */
    @Override
    public void removeFront() {
        // shift everything to the left by 1
        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i+1];
        }

        // lower size
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     * <p>
     * fast, constant time, O(1)
     */
    @Override
    public void removeBack() {
        if(size==0) {
            throw new IllegalStateException("ArrayList is empty!");
        }
        buffer[--size] = 0;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     * <p>
     * worst case remove at index 0 and resize - O(n) - linear <p>
     * best case remove at index size  - - - - - O(1) - constant <p>
     * average case  - - - - - - - - - - - - - - O(1/2n)
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        return 0;
    }

    /**
     * Returns the value at the specified position in the list.
     * This method is fast, constant time or also known as, O(1).
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     * <p>
     * W.C. when return false or at end of list - linear time O(n)
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     * <p>
     * Fast, constant time, O(1)
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     * <p>
     * Fast, constant time, O(1)
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    /**
     * Returns the number of values in this list.
     * <p>
     * This is a fast method, constant time, O(1)
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIntListIterator();
    }

    /**
     * Transfers the array into a string value
     * <p>
     * O(n) linear time b/c visits every item
     *
     * @return string
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(buffer[i]);
            sb.append(i == size-1 ? "" : ", ");
        }

        sb.append("]");
        return sb.toString();
    }

    // nested or inner class (helper class)
    public class ArrayIntListIterator implements Iterator<Integer>{
        private int currenPosition;
        public ArrayIntListIterator() {
            currenPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currenPosition < size();
        }

        @Override
        public Integer next() {
            //just to be safe - make sure there is a next
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int value = get(currenPosition);
            currenPosition++;
            return value;
        }
    }

} // end of ArrayIntList
