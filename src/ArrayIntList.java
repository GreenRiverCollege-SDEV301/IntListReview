import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {

    // internal (private) representation
    private int[] buffer;
    private int size; // number of "spots used" in the buffer
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
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {

        // check if empty
        if (size == 0) {
            resize(size + 1);
            buffer[0] = value;
            size++;
        } else {
            // check if full
            if (size == buffer.length) {
                resize(size + 1);
            }

            // open a spot at index 0 where value will be saved
            // shift everything over to the right by 1 position

            // put value in position [0]
            for (int i = size; i >= 1; i--) {
                buffer[i] = buffer[i-1];
            }
            buffer[0] = value;
        }
    }

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
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            // if the size matches the capacity, then I know I'm "full"
            // and I need to resize (create a new larger buffer and copy
            // the values over from the older smaller buffer)

            // makes the newSize up by 1 each time it's called
            resize(size+1);

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
    public void add(int index, int value) {

        // if the size is 0, resize the array and add the value to the 0 position
        if (size == 0) {
            resize(size + 1);
            buffer[0] = value;
            size++;

        // if the selected index is greater than the size, it'll just add it to the back
        } else if (index > size){
            addBack(value);

        // if all upper cases aren't true, we'll add the value to the index
        } else {
            resize(size + 1);
            for (int i = size; i > 1; i--) {
                if (i >= index) {
                    buffer[i] = buffer[i-1];
                }
            }

            if (index == 0) {
                addFront(value);
            } else {
                buffer[index] = value;
                size++;
            }
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        buffer[0] = 0;
        size--;
        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i+1];
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
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
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        int removed = buffer[index];
        for (int i = 0; i < size; i++) {
            if (i >= index) {
                if (i < size - 1) {
                    buffer[i] = buffer[i + 1];
                }
            }
        }

        removeBack();

        return removed;
    }

    /**
     * Returns the value at the specified position in the list.
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
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == value) {
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
    public int indexOf(int value) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (buffer[i] == value) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (buffer.length == 0 || size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of values in this list.
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
        int[] list = new int[0];
        size = 0;
        buffer = list;
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
            // just to be safe - make sure there is a next
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < buffer.length - 1; i++) {
            sb.append(buffer[i]);
            sb.append(", ");
        }
        sb.append(buffer[buffer.length - 1]);
        sb.append("]");


        return sb.toString();
    }
}
