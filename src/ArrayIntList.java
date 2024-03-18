import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList  extends Object implements IntList {

    private int[] buffer;
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


    @Override
    public void addFront(int value) {
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }

        // Shift existing elements to the right
        for (int i = size - 1; i >= 0; i--) {
            buffer[i + 1] = buffer[i];
        }

        // Insert the new value at the front
        buffer[0] = value;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */


    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
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



        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index Out of range");

        }
        if(size == buffer.length) {
            resize(2*buffer.length);
        }

            if(index <= size) {

                for (int i = size - 1; i >= index; i--) {
                    buffer[i + 1] = buffer[i];
                }
                buffer[index] = value;
                size++;
            }

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (size == 0) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }

        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size == 0) {
            throw new IllegalArgumentException("Already Empty");
        }
        --size;
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

        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect Index Value!");
        }
        else {
            int var1 = buffer[index];

            for (int i = index; i < size - 1; i++) {
                buffer[i] = buffer[i + 1];

            }
            size--;
            return var1;
        }


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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect Index Asked!");
        }

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
        for(int i = 0; i < size; i++) {
            if(buffer[i] == value) {
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
       for(int i=0; i<= size; i++) {
           if(buffer[i] == value) {
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
        if(size == 0 ) {
            return true;
        }

        return false;
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

        size = 0; //soft delete / Lazy delete

        for(int i =0; i<= size; i++) {
            buffer[i] = 0;
        }

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {

        //return a new instance of the helper interator class (at the bottom)
        return new ArrayIntListIterator();
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        }


        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buffer[0]);
        for(int i=1; i < size; i++){
            sb.append(", ");
            sb.append(buffer[i]);
        }
        sb.append("]");

        return sb.toString();


    }

    @Override
    public void resize(int newSize) {
        int[] temp = new int[newSize];

        for (int i = 0; i < size; i++) {
            temp[i] = buffer[i];
        }
        buffer = temp;


        size = Math.min(size, newSize);
    }



    public class ArrayIntListIterator implements Iterator<Integer> {
        private int currentPosition;

        public ArrayIntListIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            if (currentPosition < size){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public Integer next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            int value = get(currentPosition);
            currentPosition++;
            return value;
        }
    }
}
