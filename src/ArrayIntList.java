import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ArrayIntList implements IntList {
    // relationship between interface and class is a contract
    // implement without the blueprint methods is violating that contract
    // auto methods intellij inserts are called stubs - just enough to compile

    // internal (private) representation
    private int[] buffer;
    // size is the number of indices actually being used, not the size of the list itself
    private int size;
    // easy to change constant for buffer start size
    private final static int INITIAL_CAPACITY = 10;

    ArrayIntList() {
        buffer = new int[INITIAL_CAPACITY];
        size = 0;
    }

    private void resize(int newSize){
        // create new array that's larger
        int[] temp = new int[newSize];

        // copy values from existing buffer
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }

        // make the switch
        buffer = temp;
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
        // check if full
        if (size == buffer.length){
            resize(buffer.length * 2);
        }

        for (int i = size; i > 0; i--) {
            // shift everything over to open a spot at the front (move them to the right)
            buffer[i] = buffer[i-1];
        }
        // set the first value to the added one
        buffer[0] = value;
        // change size since we added to the list
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (size == buffer.length){
            // if size matches the capacity then it's full and resize is required
            // create a new larger buffer/array and copy the values over
            // make new size twice existing capacity/length
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
        // check index vs size for out of bounds
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("This index does not exist");
        }
        // check if full
        if (size == buffer.length){
            resize(buffer.length * 2);
        }

        // move everything to the right up to the index point
        for (int i = size; i > index; i--) {
            // shift everything over to open a spot at the front (move them to the right)
            buffer[i] = buffer[i-1];
        }
        // put the value in the newly cleared spot
        buffer[index] = value;
        // change size since we added to the list
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // place every item on the list to the left
        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i+1];
        }
        // decrease size
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size == 0){
            // don't allow size to be lowered to a negative
            // could also just check if size is greater than zero
            // that way avoids the error, but then it just does nothing with no statement
            throw new IllegalStateException("There is nothing in this list to remove");
        }
        // subtract one from size
        size--;
        // set size index to zero since it will be the index beyond the new length
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
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("This index does not exist");
        }

        // set the number to return
        int remove = buffer[index];
        // move everything to the left starting at the index
        for (int i = index; i < size; i++) {
            // shift everything over to remove the value
            buffer[i] = buffer[i+1];
        }
        // change size since we removed from the list
        size--;
        // return the removed number
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
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("This index does not exist");
        }
        for (int i = 0; i <= index; i++) {
            if (i == index){
                return buffer[index];
            }
        }
        // return -1 to signal error if it makes it passed the for loop
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
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == value){
                return i;
            }
        }
        // return -1 to show it wasn't in the list
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return false;
        }
        // if size isn't 0 then it is not empty
        return true;
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
        // create new empty list for buffer
        buffer = new int[INITIAL_CAPACITY];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        // provides next + hasNext methods and foreach capabilities
        // we could create a seperate class for ArrayListIterator
        // but we could also just nest a class since this won't be used outside ArrayIntList

        // return new instance of the inner class containing our iterator
        return new ArrayIntListIterator();
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super Integer> action) {
        IntList.super.forEach(action);
    }

    /**
     * This returns the list as a String
     * @return String
     */
    @Override
    public String toString() {
        if (size == 0){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buffer[0]);
        for (int i = 1; i < size; i++) {
            sb.append(", ");
            sb.append(buffer[i]);

        }
        //sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    // nested/inner/helper class
    public class ArrayIntListIterator implements Iterator<Integer> {
        private int currentPosition;

        // constructor
        public ArrayIntListIterator(){
            currentPosition = 0;
        }


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (currentPosition < size()){
                return true;
            } else {
                return false;
            }
            // could just say return (currentPosition < size);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            // double-check the list has another spot to go to / has another next at all
            if (!hasNext()){
                throw new NoSuchElementException("You have reached the end of the list!");
            }
            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }
}
