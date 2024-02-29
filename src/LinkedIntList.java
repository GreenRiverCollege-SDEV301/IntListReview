import java.util.Iterator;

public class LinkedIntList implements IntList{
    Node head;
    int size;

    private class Node {
        int val;
        Node next;

        public Node() {

        }

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next) {
            this.val = value;
            this.next = next;
        }
    }



    public LinkedIntList() {

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
        Node temp = new Node(value, head);

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node temp = new Node(value);
        Node pointer = head;

        while(pointer.next != null) {
            pointer = pointer.next;
        }

        pointer.next = temp;
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
        Node pointer = head;

        for(int i = 0; i < index -1; i++) {
            pointer = pointer.next;
        }
        Node next = pointer.next;
        pointer.next = new Node(value, next);
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        head = head.next;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node pointer = head;

        while(pointer.next.next != null) {
            pointer = pointer.next;
        }

        pointer.next = null;

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
        if(index > size) {
            throw new IndexOutOfBoundsException("given index out of bounds");
        }

        Node pointer = head;

        for (int i = 0; i < index-1; i++) {
            pointer = pointer.next;
        }
        int temp = pointer.next.next.val;
        pointer.next = pointer.next.next;

        return temp;


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
        if(index > size) {
            throw new IndexOutOfBoundsException("given index out of bounds");
        }
        Node pointer = head;

        for (int i = 0; i < index-1; i++) {
            pointer = pointer.next;
        }

        return pointer.val;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node pointer = head;

        while(pointer.next != null) {
            if(pointer.val == value){
                return true;
            }

            pointer = pointer.next;
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
        int count = 0;
        Node pointer = head;

        while(pointer.next != null) {
            if(pointer.val == value){
                return count;
            }

            pointer = pointer.next;
            count++;
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
        return size==0;
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
        head = new Node();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node iterator = head;
            @Override
            public boolean hasNext() {
                return iterator.next == null;
            }

            @Override
            public Integer next() {
                return iterator.next.val;
            }
        };
    }
}
