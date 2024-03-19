import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements  IntList{
    // helper inner/nested class
    public class Node {
        int data;       // holds the data value
        Node next;      // holds address of next node

        public Node() {
            data = 0;
            next = null;
        }

        // T = 2 is O(1) constant
        public Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    } // end of class Node

    // fields for LinkedIntList class
    private Node head;      //address of first node in list
    private int size;       // number of nodes/items in list

    /**
     * T = 2 is O(1) constant
     */
    public LinkedIntList() {
        head = null;
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * T = 6 is O(1) constant
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        /*
        This does the same, in more depth:
        // if the list is empty
        if (head == null) {
            head = new Node(value, null);
        }
        else {
        // if the list is not empty
        head = new Node(value, head);
        }
        */
        head = new Node(value, head);
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * If list is empty (go into if). T = 7 which is O(1) constant time
     * If list not empty (go into else). T = 2 * size + 8 which is O(n) linear time
     *                                   T = 2n + 8
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // if list is empty
        if (head == null) {
            head = new Node(value, null);

        } else {

            // if list is not empty
            Node current = head;

            // loop and stop on last node in list
            // (but not all the way to null)
            while (current.next != null) {
                // move current forward
                current = current.next;
            }

            // at end of list - current is referencing last node
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
        if(head == null) {
            throw new IndexOutOfBoundsException("Nothing in list!");
        }
        else if (index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        else {
            Node current = head;

            // move before to the index node
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            // put in the node between the nodes
            Node newNode = new Node(value, current.next);
            current.next = newNode;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // if head empty, exit method
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;

            // move to second last node
            while (current.next.next != null) {
                current = current.next;
            }

            // make last node null
            current.next = null;
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
        if (head == null) {
            throw new IndexOutOfBoundsException("Nothing in list!");
        } if (index == 0) {
            // saving value
            int data = head.data;
            if (head.next != null) {
                // can make it past head.next because it exists
                head = head.next;

            } else {
                // cannot make it past head.next because doesn't exist
                head = null;
            }
            size--;
            return data;
        }
        // start at 1, needs to have access to the index after current one
        int i = 1;
        Node current = head;
        while (current.next != null) {
            if (i == index) {
                // save value, using i since we won't be moving anymore
                i = current.next.data;

                if (current.next.next == null) {
                    // checking if we can skip over current.next, if not, make next = null
                    current.next = null;

                } else {
                    // if we can skip over current.next, skip
                    current.next = current.next.next;
                }
                size--;
                return i;
            }
            current = current.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * O(n) linear - to get an item at an index, I have to start at the
     * head and walk up to the size positions over 
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Nothing in list!");
        }
        int i = 0;
        Node current = head;
        while (current != null) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if (head == null) {
            return false;
        }
        Node current = head;
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
        if (head == null) {
            return -1;
        }
        int i = 0;
        Node current = head;
        while (current != null) {
            if (current.data == value) {
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
        return head == null;
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
        return new LinkedIterator();
    }

    // helper method (not required, but nice example to reference)
    public void print() {
        // create a temp variable (almost like an index i)
        // copy in the address from head and save it
        Node current = head;

        while (current != null) {
            // print the value inside the node
            System.out.println(current.data);

            //go to the next node
            current = current.next;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            // if list is empty, indicate with []
            return "[]";
        }

        // list not empty...
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        // stop one before the last node
        Node current = head;
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
        private Node current;         // holds address of current node

        public LinkedIterator() {
            // start the current position at the first node in list
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
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
