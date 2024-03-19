import com.sun.source.tree.BreakTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Array implements IntList {

    private int[] buffer;
    private int size;
    private final static int INITIAL_CAPACITY = 10;

    public Array() {
        buffer = new int[10];
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
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i - 1];
        }


        buffer[0] = value;


        size++;

    }


    private void resize(int newSize) {

        //create new array
        int[] temp = new int[newSize];
        // copy values from buffer
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        //make the switchover
        buffer = temp;
    }

    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            //create new array and uses buffer to increase size
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
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("This index does not exist");
        }
        if (size == buffer.length) {
            resize(buffer.length * 2);
        }

        for (int i = size; i > index; i--) {
            buffer[i] = buffer[i - 1];
        }

        buffer[index] = value;

        size++;
    }


    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // Move everything to the left
        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i + 1];
        }
        // take away front
        size--;
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("No index");
        }
        int remove = buffer[index];

        for (int i = index; i < size; i++) {
            //shifting left
            buffer[i] = buffer[i + 1];
        }

        size--;

        return remove;
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("This index doesint exist");
        }

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return buffer[index];
            }
        }

        return -1;
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
            if (get(i) != value) {
                return false;
            }
        }
        return true;
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
        for (int i = 0; i < size; i++) {
            if (buffer[i] == value) {
                return i;
            }
        }
        // return -1, I dont really understand that standard...
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        // not 0 not empty
        return true;
    }

    /**
     * Returns the number of values in this list.
     * <p>
     * Speed: O(1)
     * just returns a value
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
        // new empty list
        buffer = new int[INITIAL_CAPACITY];
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        IntList.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return IntList.super.spliterator();
    }


    public class ArrayIntListIterator implements Iterator<Integer> {
        private int Position;

        // constructor
        public ArrayIntListIterator(){
            Position = 0;
        }


        @Override
        public boolean hasNext() {
            if (Position < size()){
                return true;
            } else {
                return false;
            }

        }

        @Override
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException("You have the end");
            }
            int value = get(Position);
            Position++;
            return value;
        }
    }
}