import java.util.Iterator;
import java.util.NoSuchElementException;

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

        //T = 2 is O(1) constant time
        //Create a new Node object with data and a next node value
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //LinkedIntList's variables
    Node head;
    int size;

    //Constructor
    public LinkedIntList() {
        head = null;
        size = 0;
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
        //Code analysis:
        //Bc this calls a method, we have to analyze the method value. For new Node(), it's 2.
        //
        this.head = new Node(value, head); //1 (assignment) + 1 (new) + 2 (value, head)
        size++; //2
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * If list is empty (go into the if statement), T = 5 which is constant time
     * Into if T = 5 + 9 => 14
     *
     * If list isn't empty (go into the else statement), T = 2 * size + 6, which is O(n) linear
     *                                                   T = 2n + 6, which is O(n) linear
     * Into else T = 1 + 1 + (2*size) + 4 => (2*size) + 6 => 2n * 6 => n + 6 => n, which is O(n) linear
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //If head is null, that means we have an empty LinkedIntList
        if (this.head == null) { //Comparison is 1
            this.head = new Node(value); //assignment is 1, new is 1, Node(value is 2 => 4
        } else {
            //If head is not null, we have to find the end of the LinkedIntList and add the
            //new node
            Node currentNode = this.head; //assignment is 1

            //While loop will run "size" amount of times
            //The entire while loop will run (2 * size)
            while (currentNode.next != null) { //!= is 1
                currentNode = currentNode.next; //assignment is 1
            }

            currentNode.next = new Node(value); //assignment is 1, new is 1, Node(value) is 2 => 4
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
        //If the index is at the head
        if (index == 0) {
            Node nextNode = this.head;

            this.head = new Node(value, nextNode);
            this.size++;
            return;
        }

        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("Please provide a valid index (value of 0 up to and including " + (this.size - 1));
        }

        //If the index is in the middle or end
        int counter = 0;
        Node currentNode = this.head;

        while (counter < index) {
            if (counter + 1 == index) {
                Node tempNextNode = currentNode.next;
                currentNode.next = new Node(value, tempNextNode);
                this.size++;
                return;
            }
            currentNode = currentNode.next;
            counter++;
        }
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
        if (index > this.size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Please provide a valid index (value of 0 up to and including " + (this.size - 1));
        }

        //If the index is at the head
        if (index == 0) {
            int removedValue = this.head.data;
            this.head = this.head.next;
            this.size--;
            return removedValue;
        }

        //If the index is in the middle or end
        int counter = 0;
        Node currentNode = this.head;
        int removedValue = 0;

        while (counter < index) {
            if (counter + 1 == index) {
                removedValue = currentNode.next.data;
                currentNode.next = currentNode.next.next;
                this.size--;
                break;
            }
            currentNode = currentNode.next;
            counter++;
        }
        return removedValue;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * O(n) linear - to get an item at an index, you have to start at the head and walk up to the size positions over
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
        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.data == value) {
                return true;
            }
            currentNode = currentNode.next;
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
        if (this.head == null) {
            return -1;
        }

        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data == value) {
                return index;
            }

            currentNode = currentNode.next;
            index++;
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
        this.head = null;
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

    public class LinkedIterator implements Iterator<Integer> {
        //keep track of current position
        private Node current; //Holds address of current node

        public LinkedIterator() {
            //Start the current position at the first node in the listt
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

    //Helper Methods

    //Keep
    public void print() {
        //Create a temp variable (almost like an index i)
        //Copy in the address from head and save it
        Node current = head;

        while (current != null) {
            //Print the value in the node
            System.out.println(current.data);

            //Go to the next node
            current = current.next;
        }
    }
}

