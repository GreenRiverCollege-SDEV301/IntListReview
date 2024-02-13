import java.util.Iterator;

//There is a class called Object
//It's not explicit, but when we create a class we "extends Object",
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

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (size == buffer.length) {
            //If the size matches the capacity, then I know I'm "fulL"
            //and I need to resize (create a new larger buffer and copy
            //the values over from the older smaller buffer)

            //make the newSize twice the existing capacity
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
        if (this.size > 0) {
            //Note: You can do "lazy deletion" i.e. just update size
            //because it'll auto "filter" via size (in toString)
            this.size -= 1;
            this.buffer[size] = 0;

            //Alternative ways
            //If using --size: subtract from size first, then access buffer
            //If using size--: access buffer first and set to zero, then subtract size
//            buffer[--size] = 0;
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
        return 0;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
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
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

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
