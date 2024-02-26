import java.util.Iterator;

public class LinkedIntList implements IntList {
    //Helper/nested class
    public static class Node {
        int data; //Holds the data value
        Node next; //Holds address of next node

        //Create a new Node object
        public Node() {
            this.data = 0;
            this.next = null;
        }

        //Create a new Node object with just data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        //Create a new Node object with data and a next node value
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //LinkedIntList's variables
    Node head;
    int size;

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        this.head = new Node(value, head);
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //If head is null, that means we have an empty LinkedIntList
        if (this.head == null) {
            this.head = new Node(value);
            this.size = 1;
            return;
        }

        //If head is not null, we have to find the end of the LinkedIntList and add the
        //new node
        Node currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(value);
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
        if (this.size == 0) {
            throw new IllegalStateException("Front node is unable to be removed because LinkedIntList is currently empty.");
        }
        this.head = this.head.next;
        this.size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (this.size == 0) {
            throw new IllegalStateException("Back node is unable to be removed because LinkedIntList is currently empty.");
        }

        LinkedIntList.Node currentNode = this.head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        this.size--;
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
        if (index > this.size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("The provided index is outside the range of this LinkedIntList.");
        }

        Node currentNode = this.head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                break;
            }
            currentNode = currentNode.next;
        }
        return currentNode.data;
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

    //Create a toString() method to pretty print the LinkedIntList
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        Node currentNode = this.head;
        while (currentNode != null) {
            sb.append("[");
            sb.append(currentNode.data);
            sb.append("]->");
            currentNode = currentNode.next;
        }

        sb.append("[");
        sb.append("null]");
        return sb.toString();
    }
}

