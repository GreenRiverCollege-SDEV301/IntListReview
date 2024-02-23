import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {
    // internal (private) representation
    private int[] buffer;
    private int size;       // num of "spots used" in the buffer
    private final static int INITIAL_CAPACITY = 10;

    public ArrayIntList() {
        buffer = new int[INITIAL_CAPACITY];
        size = 0;
    }


    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * This is a relatively slow operation. Linear time - O(size) or O(n)
     * because we have to shift every item in the buffer to the right to
     * make room at the front for the new item
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        // check full
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }
        // open a spot at index 0 where value will be saved
        // shift everything over to the right by 1 position
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i - 1];
        }

        // put value in position [0]
        buffer[0] = value;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * This is usually a fast operation. Constant time O(1) unless
     * the ArrayList needs to be resized. Then it will be Linear time O(size)
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            // if the size matches the capacity, then I know I'm "full"
            // and I need to resize (create a new larger buffer and copy
            // the values over from the older smaller buffer)

            // make the newSize twice the existing capacity
            resize(2 * buffer.length);
        }

        buffer[size] = value;
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * The speed of this operation depends on the index.
     * Best case: index = size | Constant time O(1)
     * Worst case: index = 0 | Linear time O(size)
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            // check empty
            if (size == 0) {
                addFront(value);
            }
            else {
                // check full
                if (size == buffer.length) {
                    resize(2 * buffer.length);
                }
                for (int i = size; i > index; i--) {
                    buffer[i] = buffer[i - 1];
                }
                // put value in position [index]
                buffer[index] = value;
                size++;
            }

        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     *
     * This operation is slow. The shifting of values to
     * the left results in a linear time of O(size)
     */
    @Override
    public void removeFront() {
        // check to see if list either contains 1 element or is empty
        if (size == 1 || size == 0) {
            size = 0;
        }
        else {
            for (int i = 0; i < size - 1; i++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     *
     * This is a fast operation which runs at constant time O(1)
     */
    @Override
    public void removeBack() {
        if (size == 0) {
            throw new IllegalStateException("already empty");
        }
        size--;
        buffer[size] = 0;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * The speed of this operation depends on the index.
     * Best case: index = size | Constant time O(1)
     * Worst case: index = 0 | Linear time O(size)
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if (index > size || size == 0) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        int removed = buffer[index];
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        size--;
        return removed;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * This is a fast operation which runs at constant time O(1)
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (index > size || size == 0) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * The speed of this operation depends on the index.
     * Best case: value = 0 | Constant time O(1)
     * Worst case: value = size | Linear time O(size)
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if (size < 1) {
            return false;
        }
        else {
            for (int num : buffer) {
                if (num == value) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * The speed of this operation depends on the index.
     * Best case: value = 0 | Constant time O(1)
     * Worst case: value = size or not present | Linear time O(size)
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        if (size < 1) {
            return -1;
        }
        else {
            for (int i = 0; i < size; i++) {
                if (buffer[i] == value) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * Returns true if this list contains no values.
     *
     * This is a very fast operation. O(1)
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * This is a very fast operation. O(1)
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
     *
     * This is a very fast operation. O(1)
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        // return a new instance of the helper iterator class (below)
        return new ArrayIntListIterator();
    }

    /**
     * Returns a String representation of the ArrayIntList.
     *
     * This is a slow operation, O(size)
     *
     * @return a String.
     */
    @Override
    public String toString() { // slow
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size - 1; i++) {
            sb.append(buffer[i]);
            sb.append(", ");
        }

        sb.append(buffer[size - 1]);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns a String representation of the ArrayIntList.
     *
     * This is a slow operation, O(size)
     */
    private void resize(int newSize) {
        // create a new array that is of the new size
        int[] temp  = new int[newSize];

        // copy over values from the existing buffer
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }

        // make the switchover
        buffer = temp;
    }
    // nested or inner class (helper class)
    public class ArrayIntListIterator implements Iterator<Integer> {
        private int currentPosition;

        public ArrayIntListIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return (currentPosition < size);
        }

        @Override
        public Integer next() {
            // Just to be safe - make sure there is a next
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }

} // end of ArrayIntList
