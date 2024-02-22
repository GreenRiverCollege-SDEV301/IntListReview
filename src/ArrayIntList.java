import java.util.Iterator;
import java.util.NoSuchElementException;

//There is a class called Object
//It's not explicit, but when we create a class we "extend Object",
//which holds methods like toString();
public class ArrayIntList implements IntList {
    //Internal (private) representation
    private int[] buffer;
    private int size; //how much is actually currently contained ("spots used") in the buffer
    //capacity is different - capacity is the total length of what can be held
    private final static int INITIAL_CAPACITY = 10;

    public ArrayIntList() {
        this.buffer = new int[INITIAL_CAPACITY];
        this.size = 0;
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
        //Check if full
        if (size == buffer.length) {
            resize(2 * buffer.length);
        }

        //Open a spot at index 0 where value will be saved
        //Shift everything over to the right by 1 position
        for (int i = size; i > 0; i--) {
            buffer[i] = buffer[i - 1];
        }

        //Put value in position [0]
        this.buffer[0] = value;
        this.size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            //If the size matches the capacity, then I know I'm "fulL" and I need to resize (create a new larger buffer
            // and copy the values over from the older smaller buffer) make the newSize twice the existing capacity
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
        //If we are inserting to the front, we can use our addFront() method
        if (index == 0) {
            this.addFront(value);
            return;
        }

        //Check if our buffer is full or if the given index is outside our buffer length
        if (this.size == this.buffer.length) {
            //Check if full
            resize(2 * this.buffer.length);
        } else if (index >= this.buffer.length) {
            //If we insert to an index outside the length of buffer, we have to resize it first
            resize(2 * index);
            this.size = index;
        }

        int[] newList = new int[this.buffer.length];

        int counter = 0;
        //Go through the array until we get to the index (index) given
        for (int i = 0; i < index; i++) {
            newList[i] = this.buffer[i];
            counter = i;
        }

        //When we get there, we can add the new value
        counter++;
        newList[counter] = value;
        counter++;
        this.size++;

        //Then add in the rest
        for (int i = counter; i < this.size; i++) {
            newList[i] = this.buffer[i-1];
        }

        this.buffer = newList;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (this.size <= 0) {
            throw new IllegalStateException("Already empty!");
        }

        int[] newBuffer = new int[this.buffer.length];

        for (int i = 0; i < this.size; i++) {
            newBuffer[i] = this.buffer[i+1];
        }

        this.buffer = newBuffer;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (this.size > 0) {
            //Note: You can do "lazy deletion" i.e. just update size
            //because it'll auto "filter" via size (in toString)
            this.size -= 1;
            this.buffer[size] = 0;

            //Alternative ways
            //If using --size: subtract from size first, then access buffer
            //If using size--: access buffer first and set to zero, then subtract size
//            buffer[--size] = 0;
        } else {
            throw new IllegalStateException("Already empty!");
        }
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
        //If the index is higher than our buffer's size
        if (index > this.size) {
            throw new IllegalStateException("Error: the given index to remove is higher than what's currently in buffer");
        }

        int value = this.buffer[index];

        //If index is the first element in this.buffer
        if (index == 0) {
            this.removeFront();
        } else {
            //If index is anywhere else
            int[] newBuffer = new int[this.size];

            int counter = 0;

            //Add in the buffer values prior to the given index
            for (int i = 0; i < index; i++) {
                newBuffer[i] = this.buffer[i];
                counter = i;
            }

            //Increment counter by 1 so that we're at the next index
            counter++;

            //Add in the buffer values post the given index
            for (int i = counter; i < this.size; i++) {
                newBuffer[i] = this.buffer[i + 1];
            }

            this.buffer = newBuffer;
            size--;
        }

        return value;
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
        return this.buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if (this.size == 0) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (value == this.buffer[i]) {
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
        if (this.size == 0) {
            return -1;
        }

        for (int i = 0; i < this.size; i++) {
            if (this.buffer[i] == value) {
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
        return this.size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        this.buffer = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentIndex = 0;

            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                //If current index is 5 & the current size is 6, this would return true even though
                //there is no "next" element. We have to reduce size by 1 in order to have the current
                //index point to the right "size".
                return currentIndex < size - 1;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return buffer[currentIndex + 1];
            }

            //We do not have to override remove() or forEachRemaining(), because the Iterator interface
            //already defines these two methods.
        };
    }

//    /**
//     * Returns an iterator over elements of type {@code T}.
//     *
//     * @return an Iterator.
//     */
//    public class ArrayIntListIterator implements Iterator<Integer> {
//        private int currentPosition;
//
//        public ArrayIntListIterator() {
//            currentPosition = 0;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return currentPosition < size();
//        }
//
//        @Override
//        public Integer next() {
//            //Ensure that there is a next
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//
//            int value = get(currentPosition);
//            currentPosition++;
//            return value;
//        }
//    }

    //toString() is from the object class
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size - 1; i++) {
            sb.append(buffer[i]);
            sb.append(", ");
        }

        sb.append(this.buffer[size - 1]);

        sb.append("]");
        return sb.toString();
    }


    //Helper Methods

    private void resize(int newSize) {
        //Create a new array that is of the new size
        //If primitive array, we use primitive values (the array is set to zeros, not null)
        //Since it's int[], we can only put in ints (i.e. 0's)
        //If we had an object array, we'd be able to use null
        int[] temp = new int[newSize];

        //Copy over values from the existing buffer
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.buffer[i];
        }

        //Make the switchover
        this.buffer = temp;
    }
}
