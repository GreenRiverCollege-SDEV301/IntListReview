import java.util.Iterator;
public class LinkedIntList implements IntList{
    // helper inner/nested class
    public class Node{
        int data;  // holds the data value
        Node next; // holds address of next node

        public Node(){
            data = 0;
            next = null;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    } // end of class Node

    // fields for LinkedIntList class
    private Node head; // address of first node in list
    private int size;

    public LinkedIntList(){
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
        // if list is empty
        if (head == null){
           head = new Node(value, null);
        }
        // if list not empty
        else {
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
        } else {
            Node current = head;
            // Traverse to the last node
            while (current.next != null) {
                current = current.next;
            }
            // Add the new node at the end
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
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        // If adding at the front, use addFront method
        if (index == 0) {
            addFront(value);
        } else {
            Node newNode = new Node(value, null);
            Node current = head;

            // Traverse to the node before the specified index
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // Insert the new node in between
            newNode.next = current.next;
            current.next = newNode;

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
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (head != null) {
            // If there's only one node, remove it
            if (head.next == null) {
                head = null;
            } else {
                Node current = head;
                // Traverse to the second-to-last node
                while (current.next.next != null) {
                    current = current.next;
                }
                // Remove the last node
                current.next = null;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        int removedValue;

        // If removing at the front, use removeFront method
        if (index == 0) {
            removedValue = head.data;
            removeFront();
        } else {
            Node current = head;
            // Traverse to the node before the specified index
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // Get the value to be removed
            removedValue = current.next.data;
            // Remove the node
            current.next = current.next.next;
            size--;
        }

        return removedValue;
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
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        Node current = head;
        // Traverse to the specified index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
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
        // Traverse the list to find the value
        while (current != null) {
            if (current.data == value) {
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
        Node current = head;
        // Traverse the list to find the index of the value
        for (int i = 0; i < size; i++) {
            if (current.data == value) {
                return i;
            }
            current = current.next;
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
        return null;
    }

    public String toString(){
        if (head == null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while (current.next != null){
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }
        sb.append(current.data);
        sb.append("]");
        return sb.toString();
    }

}
