import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList{

    //private representation
    private int[] buffer;
    private int size;

    private final static int INITIAL_CAPACITY = 10;

    public ArrayIntList(){
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
    @java.lang.Override
    public void addFront(int value) { //linear time. O(2N) if resize
        if(buffer.length == size){
            //if size matches capacity then it is full and need to resize creating a larger buffer and copy values over
            resize(buffer.length * 2);
        }
        for(int i = size; i > 0; i--){
           buffer[i] = buffer[i - 1];
        }
        buffer[0] = value;
        size++;
    }

    private void resize(int newSize){ //linear time.
        //create a new array larger than newSize and copy values over from buffer
        int[] temp = new int[newSize];

        for(int i = 0; i < size; i++){
            temp[i] = buffer[i];
        }

        buffer = temp;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @java.lang.Override
    public void addBack(int value) { //constant time. linear if have to resize

        if(buffer.length == size){
            //if size matches capacity then it is full and need to resize creating a larger buffer and copy values over
            resize(buffer.length * 2);
        }
        size++;
        buffer[size - 1] = value;
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
    @java.lang.Override
    public void add(int index, int value) { // linear time
        //TO DO
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        if(buffer.length == size){
            //if size matches capacity then it is full and need to resize creating a larger buffer and copy values over
            resize(buffer.length * 2);
        }

        for(int i = index; i < buffer.length; i++){
            int temp = buffer[i];
            buffer[i] = value;
            value = temp;
        }
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @java.lang.Override
    public void removeFront() { //linear time
        //TO DO
        if(size > 0) {
            for (int i = 0; i < buffer.length - 1; i++) {
                buffer[i] = buffer[i + 1];
            }
            buffer[buffer.length - 1] = 0;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @java.lang.Override
    public void removeBack() { //constant time
        if(size == 0){
            throw new IllegalStateException("Already Empty");
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
    @java.lang.Override
    public int remove(int index) {
        //TO DO
        if(index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        int value = buffer[index];
        for(int i = index; i < buffer.length - 1; i++){
            buffer[i] = buffer[i + 1];
        }
        size--;
        return value;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @java.lang.Override
    public int get(int index) {
        //TO DO
        if(size < 1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return buffer[index]; //fast. constant time
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @java.lang.Override
    public boolean contains(int value) {
        //TO DO
//        if(size == 0){
//            return false;
//        }
        for(int i = 0; i < buffer.length; i++){
            if(buffer[i] == value){
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
    @java.lang.Override
    public int indexOf(int value) {
        //TO DO
        for(int i = 0; i < buffer.length; i++){
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
    @java.lang.Override
    public boolean isEmpty() {
        //TO DO
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @java.lang.Override
    public int size() {
        //TO DO
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @java.lang.Override
    public void clear() {
        //TO DO
        while (size != 0){
            int i = size - 1;
            buffer[i] = 0;
            size--;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @java.lang.Override
    public Iterator<Integer> iterator() {
        //TO DO

        return new ArrayIntListIterator();
    }

    public static int getInitialCapacity() {
        //TO DO
        return INITIAL_CAPACITY;
    }

    public String toString(){// linear time
        if(size == 0){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buffer[0]);

        for(int i = 1; i < size; i++){
            sb.append(", ");
            sb.append(buffer[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    //nested inner class(helper class)
    public class ArrayIntListIterator implements Iterator<Integer>{
        private int currentPosition;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            int value = get(currentPosition);
            currentPosition++;
            return value;
        }

        public ArrayIntListIterator(){
            currentPosition = 0;
        }
    }
}
