import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList{
    private int[] buffer;
    private int size;

    public ArrayIntList() {
        buffer = new int[10];
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     * Time complexity: O(n)
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        if(size==buffer.length){
            resize(2*buffer.length);
        }
        // open spot at index 0 where value will be saved
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i-1];
        }
        buffer[0] = value;
        size++;
    }

    /**
     * Creates a larger array and copies over the information from the original to the temp array.
     * Then buffer will overwrite itself with a bigger copy from temp.
     * Time complexity: O(n)
     *
     * @param newSize new array size
     * */
    private void resize(int newSize){
        int[] temp = new int[newSize];
        for (int i = 0; i < size; i++) {
            temp[i]=buffer[i];
        }
        buffer=temp;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     * Time complexity: O(n)
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // if the capacity is full
        if(size == buffer.length){
            resize(2*buffer.length);
        }

        buffer[size] = value;
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     * Time complexity: O(n)
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (size == buffer.length) {
            resize(2 * buffer.length);
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
     * Time complexity: O(n)
     *
     */
    @Override
    public void removeFront() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        for (int i = 0; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }

        buffer[--size] = 0;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     * Time complexity: O(n)
     *
     */
    @Override
    public void removeBack() {
        if(size==0){
            throw new IllegalStateException();
        }
        buffer[--size]=0;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     * Time complexity: O(n)
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        int removedValue = buffer[index];

        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }

        buffer[--size] = 0;

        return removedValue;
    }

    /**
     * Returns the value at the specified position in the list.
     * Time complexity: O(n)
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     * Time complexity: O(n)
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
     * Time complexity: O(n)
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
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     * Time complexity: O(n)
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Returns the number of values in this list.
     * Time complexity: O(n)
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
     * Time complexity: O(n);
     */
    @Override
    public void clear() {
        size = 0;
        buffer = new int[10]; // reset buffer to initial capacity
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
     * Visits every index of the array, costly depending on the size.
     * Time complexity: O(n)
     * */
    @Override
    public String toString(){
        if (size ==0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size-1; i++) {
            sb.append(buffer[i]);
            sb.append(", ");
        }
        sb.append(buffer[size-1]);
        sb.append("]");
        return sb.toString();
    }

    // nested inner class (helper class)
    public class ArrayIntListIterator implements Iterator<Integer> {
        private int currentPosition;
        public ArrayIntListIterator(){
            currentPosition = 0;
        }
        @Override
        public boolean hasNext(){
            return (currentPosition < size);
        }
        @Override
        public Integer next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int value = get(currentPosition);
            currentPosition++;
            return value;

        }
    }
}
