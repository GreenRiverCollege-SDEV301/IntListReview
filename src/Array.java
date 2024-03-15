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
            //create new array and copy the old array over
            resize(2 * buffer.length);
            //making new array twice as large
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

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {

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
    public int get(int index) {
        return buffer.length;
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
            if (get(i) == value) {
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
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return 0;
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
//    @Override
//    public Iterator<Integer> iterator() {
//        return new ArrayIntListIterator();
//
//
//    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";

        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        sb.append(buffer[0]);
        for (int i = 1; i < size; i++) {

            sb.append(", ");
            sb.append(buffer[i]);
        }

        sb.append("]");
        return sb.toString();

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

    //nested class
//    public class ArrayIntListIterator extends Iterator<Integer> {
//        private int currentPosition;
//
//        public ArrayIntListIterator() {
//            currentPosition = 0;
//
//        }
//
//        public boolean hasNext() {
//        }
//
//        @Override
//        public Integer next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//
//            int value = get(currentPosition);
//            currentPosition++;
//            return value;
//        }

//    @Override
//    public void remove() {
//        Iterator.super.remove();
//    }
//
//    @Override
//    public void forEachRemaining(Consumer<? super Integer> action) {
//        Iterator.super.forEachRemaining(action);
//    }
//        if (currentPosition < size){
//            return true;
//    }else {
//            return false;
//         }
//    }


    }

