import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {
    // helper / inner / nested class
    public class Node {
        int data; // holds data value
        // this attribute makes this a self-referential class
        Node next; // holds address of next node

        /**
         * Constructor
         * T = 2
         * runtime is constant
         * */
        Node(){
            data = 0;
            next = null;
        }

        /**
         * Constructor
         * T = 2
         * runtime is constant
         * */
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    } // end of class Node

    // fields for LinkedIntList class
    private Node head;
    private int size;

    /**
     * Constructor
     * T = 2
     * runtime is constant
     * */
    public LinkedIntList() {
        head = null;
        size = 0;
    }

    public LinkedIntList(Node head){
        this.head = head;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * T = 6 is O(1) constant time
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        // this route is much slightly better runtime than below
        head = new Node(value, head);
        /* the following's run time is ~7, constant, no dominating factor O(1)
        if (head == null){
            head = new Node(value, null);
        } else {
            // if the list is not empty
            head = new Node(value, head);
        }*/

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     * T = 5 if head == null AKA O(1), constant time
     * T = 2n+6 if head != null AKA O(n), linear time
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // check if list is empty
        if (head == null){
            head = new Node(value, null);
        }

        // create a variable to keep track of the location
        Node current = head;

        // go forward until we reach the back
        while(current.next != null){
            // iterate through the list
            current = current.next;
        }

        // we are now at the end so we can make this node equal our new one
        current.next = new Node(value, null);
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * T = linear O(n)
     * We have to go through the list n times (up to the full size)
     * in order to search for the index and then we have to also
     * put in the value with some variable assigning.
     * If the index is out of bounds or there is one item in the list, it
     * can be constant time.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        // check size to throw exception
        if (size < index){
            throw new IndexOutOfBoundsException("That index does not exist in this list.");
        }

        // create a counter and a tracker for current
        int count = 0;
        Node current = head;

        while (current.next != null){
            // our 'index' will start at 0 like a typical list, so
            // we make this comparison before we increase it
            if (count == index){
                // keep old pointer to this node and point to the old node
                current = new Node(value, current);
                return;
            } else {
                // increase count and move to next node
                count++;
                current = current.next;
            }
        }

        // check the very last piece of data
        if (count == index){
            current.next = new Node(value, null);
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     *
     * T = O(1) AKA constant time
     * We only have to find the head and reset it, there is no searching
     * or rearranging needed.
     */
    @Override
    public void removeFront() {
        // set the head to the next one, removing the link with the original head
        this.head = this.head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     *
     * T = O(n) linear time
     * No matter what we have to go through the whole list so the time is O(size)
     */
    @Override
    public void removeBack() {
        Node current = head;
        // iterate through the list
        while (current.next != null){
            // check if it's the last one before the end
            if (current.next.next != null) {
                current = current.next;
            } else {
                // if next.next is null, then next is what we want to cut out
                // all we have to do is make it direct to null next
                current.next = new Node(current.next.data, null);
                // this cuts connection with the last node
            }
        }
        size--;
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
        if (index >= size){
            throw new IndexOutOfBoundsException("This index is outside of the list");
        }

        Node current = head;
        // create index tracker
        int count = 0;

        while(current.next != null){
            // check index and return if matches
            if (count == index){
                int ret = current.data;
                // reassign the node to the next node
                current = current.next;
                // return the removed value
                return ret;
            }
            // if not the same as value, keep searching
            current = current.next;
            count++;
        }
        // checked the final value
        if (count == index){
            int ret = current.data;
            // reassign the node to the next node
            current = current.next;
            // return the removed value
            return ret;
        }
        // if we make it this far we didn't find it
        return -1;
    }

    /**
     * Returns the value at the specified position in the list.
     * T = linear AKA O(n), have to start at head and walk through size amount of times
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException("This index is outside of the list");
        }

        Node current = head;
        // create index tracker
        int count = 0;

        while(current.next != null){
            // check index and return if matches
            if (count == index){
                return current.data;
            }
            // if not the same as value, keep searching
            current = current.next;
            count++;
        }
        // checked the final value
        if (count == index){
            return current.data;
        }
        // if we make it this far we didn't find it
        return -1;
    }

    /**
     * Returns true if this list contains the specified value.
     * T = linear O(n), have to walk through potentially the whole list
     *  if head is null, constant time
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if (head == null){
            return false;
        }

        // create index tracker
        Node current = head;
        while(current.next != null){
            // check index data and return if matches
            if (current.data == value){
                return true;
            }
            // if not the same as value, keep searching
            current = current.next;
        }
        // checked the final value
        if (current.data == value){
            return true;
        }
        // if we make it this far we didn't find it
        return false;
    }


    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *  T = O(n)
     *  Linear time, best case scenario head is null and it returns O(1)
     *  but otherwise it could potentially have to search the whole list one by one
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        if (head == null){
            return -1;
        }

        // create index tracker and counter
        Node current = head;
        int counter = 0;
        while(current.next != null){
            // check index data and return if matches
            if (current.data == value){
                return counter;
            }
            // if not the same as value, keep searching
            current = current.next;
            counter++;
        }
        // checked the final value
        if (current.data == value){
            return counter;
        }
        // if we make it this far we didn't find it
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     * T = O(1)
     * Constant time
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        // if head is null, list is empty
        return (head == null);
    }

    /**
     * Returns the number of values in this list.
     * T = O(1), constant time
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
     *
     * T = O(1) constant time
     */
    @Override
    public void clear() {
        // set head to null
        head = null;

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIterator();
    }

    public void print() {
        // create temp variable (similar to index)
        // copy in head and save it
        Node current = head;

        while (current != null){
            // print data in node
            System.out.println(current.data);

            // go to next node
            current = current.next;
        }
    }

    public String toString() {
        if (head == null) {
            // if empty
            return "[]";
        } else {
            // if not empty
            Node current = head;
            StringBuilder result = new StringBuilder();
            result.append("[");

            // this will stop one before the last node
            while (current.next != null){
                result.append(current.data).append(", ");
                current = current.next;
            }

            // add last node
            result.append(current.data).append("]");
            return result.toString();
        }

    }
    public class LinkedIterator implements Iterator<Integer>{
        // keep track of current position
        private Node current;

        public LinkedIterator(){
            // start at first node of list
            current = head;
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
            if (current == null) {
                return false;
            } else {
                return true;
            }
            //or return (current!=null)
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            int result = current.data;
            current = current.next;
            return result;
        }
    } // end of helper class
} // end of LinkedIntList

