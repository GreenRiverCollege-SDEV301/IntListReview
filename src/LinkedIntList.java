import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {
    // helper inner/nested class
    public class Node {
        int data;
        Node next;

        public Node() {
            data = 0;
            next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    } // end of node class

    // fields for LinkedIntList class
    private Node head; // address  of first node in list
    private int size; // size of list in terms of nodes

    public LinkedIntList() {
        head = null;
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
        // if the list is empty
        if (head == null) {
            head = new Node(value, null);
        }
        else {
            // if the list is not empty
            head = new Node(value, head);
        }

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // if list is empty
        if (head == null) {
            head = new Node(value, null);
        }
        else {
            // if list is not empty
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value, null);
        }
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
    public void add(int index, int value) { // currently does not work
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            // check if empty
            if (size == 0) {
                head = new Node(value, null);
                size++;
            }
            else {
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                // check if there is a next
                if (current.next != null) {
                    Node temp = current.next;
                    current.next = new Node(value, temp);
                    size++;
                }
                else {
                    current.next = new Node(value, null);
                    size++;
                }
            }
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (head.next == null) {
            head = null;
        }
        else {
            head = head.next;
        }
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
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
        return (head != null);
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

    // helper method (not required but nice example to reference)
    public void print() {
        // create tenp variable (almost like an index i)
        // copy in the address from head and save it
        Node current = head;

        // print the value inside the note
        System.out.println(current.data);

        // go to next node
        current = current.next;
    }

    @Override
    public String toString() {
        if (head == null) {
            // if list is empty, indicate with []
            return "[]";
        }
        // if i get here, the list is not empty for sure
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        // stop one before the last node
        while (current.next != null) {
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }
        // add in the last node
        sb.append(current.data);
        sb.append("]");
        return sb.toString();
    }
    // helper class
    public class LinkedIterator implements Iterator<Integer> {
        // keep track of current position
        private Node current;

        public LinkedIterator() {
            // start current position at the first node
            current = head;
        }

        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            }
            else {
                return true;
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int result = current.data;
            current = current.next;
            return result;
        }
    }
}
