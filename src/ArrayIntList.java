import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {
    //internal private representation
    private int[] buffer;
    //num of full spots in the array buffer
    private int size;
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
    //relatively slow, linear time/ depends on the size
    //have to shift size items to the right.
    //assuming no resize
    @Override
    public void addFront(int value) {
        //open a value at index 0
        for (int i = size; i >= 1; i--) {
            //buffer[i+1] = buffer[i];
            buffer[i] = buffer[i - 1];
        }
        buffer[0] = value;
        size++;
    }


    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param @value to be inserted
     */
    //slow, linear time, O(n)/O(size), as you have to resize the resize will get slower
    //you have to copy the entire array into a new empty array
    private void resize(int newSize) {
        int[] temp = new int[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        //reassign memory address
        buffer = temp;
    }
    //fast operation, constant time until you array resizes
    //can be slow, linear time if resize is needed.
    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            //make a new array twice the size as the old
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
    //runtime can be as good as addBack with no resize(best case) O(n)-linear
    //or as slow as addFront with resize(worst case) O(1)-constant
    @Override
    public void add(int index, int value) throws IndexOutOfBoundsException{
        //check if add in front
        if (index == 0) {
            addFront(value);
            //middle
        } else if (index > 0 && index < size-1) {
            for (int i = size; i > index; i--) {
                buffer[i] = buffer[i - 1];
            }
            buffer[index] = value;
            size++;
            //back of list
        } else if (index == size) {
            buffer[size] = buffer[size - 1];
            addBack(value);

        }else if(index >= size+1){
            throw new IndexOutOfBoundsException("Index Out Of Bounds!");
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    //slow, linear time, depends on the size O(n)/O(size)
    @Override
    public void removeFront() {
        if(size == 0){
            throw new IllegalArgumentException("Already Empty!");
        }
        for (int i = 0; i <= size-2; i++) {
            buffer[i] = buffer[i + 1];
        }
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    //fast, constant time, O(1)/order 1
    @Override
    public void removeBack() {
        if (size == 0) {
            throw new IllegalArgumentException("Already Empty!");
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
    //can be as slow as removeFront O(n)-linear
    //can be as fast as removeBack O(1)-constant
    @Override
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        //beginning
        if (index == 0) {
            int t = buffer[index];
            removeFront();
            return t;
            //end
        } else if (index == size - 1) {
            int t = buffer[size - 1];
            removeBack();
            return t;
            //middle
        } else {
            int t = buffer[index];
            for (int i = index; i <= size-2; i++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
            return t;
        }
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    //fast operation, constant time, O(1).
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if(index >= size){
            throw new IndexOutOfBoundsException("Index out of Bounds!");
        }
        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    //can be fast if the search is found at a lower index
    //best case if search is found at index 0
    //worst case, value is not found - linear O(n)
    @Override
    public boolean contains(int value) {

        for(int i = 0; i < size; i++){
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
    //can be fast if the search is found at a lower index
    //best case if search is found at index 0
    //worst case, value is not found - linear O(n)
    @Override
    public int indexOf(int value) {
        for(int i = 0; i <= size-1; i++){
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
    //fast, constant, O(1)
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    //fast constant time O(1)
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

        for(int i = 0; i <= buffer.length-1; i++){
            buffer[i] = 0;
            size--;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        //return a new instance of the helper iterator class(nested below)
        return new ArrayIntListIterator();
    }
    //slow, have to visit every item in the list, O(n) - linear time
    @Override
    public String toString(){
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
    //nested inner class
    public class ArrayIntListIterator implements Iterator<Integer>{
        private int currentPosition;

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
            return (currentPosition < size());
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() throws NoSuchElementException {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }

}//end of ArrayIntList
