import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {

    // helper inner/nested class
    public static class Node {
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
    } // end of class node

    // fields for LinkedIntList class
    private Node head; // address of first node in list
    private int size; // number of nodes/items in list

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
            return;
        }

        // if the list is not empty
        head = new Node(value, head);
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {

        if (head == null) {
            head = new Node(value, null);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(value, null);
            size++;
        }
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
        if (index > size) {
            System.out.println("index larger than size");
            return;
        } else if (index < 0) {
            System.out.println("index lower than 0");
            return;
        }

        int nodeIndex = 0;
        Node current = head;
        Node temp = null;

        while (current.next != null && nodeIndex != index) {
            current = current.next;
            nodeIndex++;
        }

        if (size == index && current.next == null) {
            current.next = new Node(value, null);
            size++;
        } else {
            temp = new Node(current.data, current.next);
            current.data = value;
            current.next = temp;
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
        if (head.next == null) {
            System.out.println("single value in list");
        }
        head = head.next;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node current = head;

        if (current == null) {
            System.out.println("Empty");
        } else if (current.next == null) {
            System.out.println("No back to remove");
        } else {
            while (current.next.next != null) {
                current = current.next;
            }

            current.next = null;
        }
    }

    public void removeMiddle() {

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
        int nodeIndex = 0;
        Node current = head;
        Node temp = null;

        while (current.next != null && nodeIndex != index) {
            current = current.next;
            nodeIndex++;
            System.out.println();
        }

        return -1;
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
        boolean result = false;
        Node current = head;

        while (current.next != null) {
            if (current.data == value) {
                result = true;
            }
            current = current.next;
        }

        if (current.data == value) {
            result = true;
        }

        return result;
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
        int nodeIndex = 0;

        while (current.next != null && current.data != value) {
            current = current.next;
            nodeIndex++;
        }

        return nodeIndex;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
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

    // helper method (not required, but nice example to reference)
    public void print() {
        // create temp variable )almost like an index i)
        // copy in the address from head and save it
        Node current = head;

        while (current != null) {
            // print the value inside the node
            System.out.println(current.data);

            // go to the next node
            current = current.next;
        }

    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        // If I get here, the list is not empty
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while (current.next != null) {
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }

        sb.append(current.data);

        sb.append("]");

        return sb.toString();
    }

    public class LinkedIterator implements Iterator<Integer> {
        private Node current;

        public LinkedIterator() {
            // start the current position at the first node in list
            current = head;
        }
        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            } else {
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
