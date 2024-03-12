import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{
    // Helper inner/nested class
    public class Node {
        int data;   // Hold the data value
        Node next;  // Holds the address of the next node

        public Node(){
            data = 0;
            next = null;
        }

        // T = 2 is O(n) constant time
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        // End of class node
    }

    // Fields for LinkedIntList class
    private Node head;  // Address of the first node in list
    private int size;   // Number of nodes/items in list


     // T = 2 is O(1) constant time
    public LinkedIntList(){
        head = null;
        size = 0;
    }


    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     *  T = 7 is O(1) constant time
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        head = new Node(value, head);
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     *  If list is empty, (if statement) then T = 5 is O(1) constant time
     *  If list is not empty, (else statement) then T = (2 * size) + 6 OR T = 2n + 6 which is O(n) linear time
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // If the list is empty
        if (head == null){
            head = new Node(value, null);

        }else{
            // If the list is not empty
            Node current = head;

            // Loop and stop on last node in list (But not all the way to null)
            while (current.next != null){
                // move current forward
                current = current.next;
            }
            // When I am here, current is referencing the last node
            current.next = new Node(value, null);
        }
        // Increase the size of the list
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
        if (index > size){
            throw new IndexOutOfBoundsException("Index is longer than the length!");
        }
        if (index == 0){
            head = new Node(value, null);
        }else{
            Node newNode = new Node(value, null);
            Node current = head;

            // Traverse to the node before the specified index
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // Insert the new node in between
            newNode.next = current.next;
            current.next = newNode;


        }
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (size == 0){
            throw new IllegalStateException("List is empty!");
        }
        if (head != null) {
            Node current = head;
            if (current.next != null){
                head = current.next;
            }else{
                head = null;
            }
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size == 0){
            throw new IllegalStateException("List is empty!");
        }
        if (head != null){
            Node current = head;
            // Check if there is a next
            if (current.next != null){
                while (current.next.next != null){
                    current = current.next;
                }
                current.next = null;
            }else{
                head = null;
            }
            size--;
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
        if (size == 0){
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        Node current = head;
        for (int i = 0; i <= index; i++){
            if (i == index){
                Node removed = current;
                current = current.next;
                size--;
                return removed.data;
            }
            if (current.next != null){
                current = current.next;
            }
        }
        return -1;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * O(n) linear - to get an item at an index. I have to start at the head
     * and walk up to the size poisitons over
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (size == 0 || index > size){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        Node current = head;
        for (int i = 0; i <= index; i++){
            if (i == index){
                return current.data;
            }
            if (current.next != null){
                current = current.next;
            }
        }
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
        Node current = head;
        while(current != null){
            if(current.data == value){
                return true;
            }
            current = current.next;
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
        int i = 0;
        Node current = head;
        while(current != null){
            if (current.data == value){
                return i;
            }
            current = current.next;
            i++;
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
        head = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIntListIterator();
    }

    // helper method (not required, but nice example
    public void print() {
        // Create a temp variable (almost like an index i)
        // Copy in the address from head and save it
        Node current = head;

        while (current != null){
            // print the value inside the node
            System.out.println(current.data);

            // go to the next node
            current = current.next;
        }
    }

    @Override
    public String toString(){
        if (head == null) {
            // If list is empty, indicate with []
            return "[]";
        }

        // If I got here, the list is not empty for sure
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while (current.next != null){
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }

        // add the last node
        sb.append(current.data);
        sb.append("]");
        return sb.toString();
    }


    // Nested or inner class (helper class)
    public class LinkedIntListIterator implements Iterator<Integer>{
        private Node current;   // holds address of current node

        public LinkedIntListIterator(){
            // Start the current position at the first node in the list
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int result = current.data;
            current = current.next;
            return result;
        }
    }
}
