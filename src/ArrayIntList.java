import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList{
    // Internal private representation
    private int[] buffer;
    private int size;   // Num of positions used in the buffer
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
     * Speed = Relatively SLow, Linear Time O(size), has to shift size items right
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        // check if full
        if (size == buffer.length){
            resize(2 * buffer.length);
        }
        // Open a spot at index 0 where value will be saved
        // Shift everything over to the right by 1 position
        for(int i = size; i > 0; i--){
            buffer[i] = buffer[i-1];
        }

        // Put the value at position [0]
        buffer[0] = value;
        size++;
    }


    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * Speed = Fast, Constant Time if no Resize 0(1)
     * Can be Slow if resize is involved
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // Check to see if we still have the capacity in buffer
        if (size == buffer.length) {
            // If the size matches the capacity, then I know I'm "full" and I need to resize
            // ( create a new larger buffer and copy the values over from the older smaller buffer)

            // Make the newSize twice the existing capacity
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
     * Speed = Depends on index. Can be as slow as add front or as fast as add back.
     * Worst case speed = add at index 0 (Linear) and resize is needed
     * Best case speed = add at index (size) (Constant) and no resize needed
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        if (index > size){
            throw new IndexOutOfBoundsException("Index is longer than the length!");
        }

        // check if full
        if (size == buffer.length){
            resize(2 * buffer.length);
        }

        for (int i = size; i > index; i--){
            buffer[i] = buffer[i-1];
        }

        buffer[index] = value;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     *
     * Speed = Slow, Linear Time O(size) / O(n)
     */
    @Override
    public void removeFront() {
        if (size == 0){
            throw new IllegalStateException("Array is empty!");
        }
        for(int i = 0; i < size; i++){
            buffer[i] = buffer[i+1];
        }
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     *
     * Speed = fast and Constant O(1)
     */
    @Override
    public void removeBack() {
        if (size == 0){
            throw new IllegalStateException("Already empty!");
        }
        buffer[--size] = 0;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * Speed = Depends on index. Can be as slow as remove front or as fast as remove back.
     * Worst case speed = remove at index 0 (Linear) with a shift of numbers left
     * Best case speed = remove at index (size) (Constant)
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if (index > size){
            throw new IndexOutOfBoundsException("Index must be in range");
        }

        int r = buffer[index];
        for(int i = 0; i < size; i++){
            if (i >= index){
                buffer[i] = buffer[i+1];
            }
        }
        size--;
        return r;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * Speed = Fast, Constant Time 0(1)
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (index < size){
            return buffer[index];
        }else{
            throw new IndexOutOfBoundsException("Index is out of Range!");
        }
    }


    /**
     * Returns true if this list contains the specified value.
     *
     * Speed = depends on if value exists or not.
     * Worst case = Linear time O(size) and value is not in list or the last index
     * Best case = value = index 0
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        for(int i = 0; i < size; i++){
            if (buffer[i] == value){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * Speed = depends on if value exists or not.
     * Worst case = Linear time O(size) and value is not in list or the last index
     * Best case = value = index 0
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        for(int i = 0; i < size; i++){
            if (buffer[i] == value){
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
    public boolean isEmpty() {
        return size == 0;
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
        // Shrink the list back down to the original creation size
        buffer = new int[INITIAL_CAPACITY];
        size = 0;
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


    // Speed = O(n) or O(size) - Linear Time because you have to visit every item
    @Override
    public String toString() {
        if ( size == 0 ){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++){
            sb.append(buffer[i]);
            sb.append(i == size-1 ? "" : ", "); // Only append the comma if it's not the last index
        }

        sb.append("]");
        return sb.toString();
    }

    // Speed = "Slow", Linear Time O(n)
    // Depends on size of array because it copies old array into new array
    private void resize(int newSize) {
        // create a new array that is of the new size
        int[] temp = new int[newSize];

        // copy over values from the existing buffer
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }

        // Make the switchover
        buffer = temp;
    }

    // Nested or inner class (helper class)
    public class ArrayIntListIterator implements Iterator<Integer>{
        private int currentPosition;

        public ArrayIntListIterator(){
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size();
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

} // End of ArrayIntList
