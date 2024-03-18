import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{
    private Node head;

    public LinkedIntList() {
        head = null;
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    @Override
    public void addFront(int value) {

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */

    public void addBack(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }

            current.next = newNode;
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

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Wrong index entered!");
        }
        else if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        else {
            Node newNode = new Node(value);
            Node current = head;
            for(int i=0; i<index-1;i++) {
                current = current.next;
            }

            //Stitching up
            newNode.next = current.next;
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
        if(head !=null){
            head=head.next;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(head == null) {
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node current = head;

        while(current.next.next != null) {  //second last node
            current = current.next;
        }

        current.next = null;  //current is second last node, and current.next is the last node, which is being set to null;

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
        if(index < 0|| index>=size()){
            throw new IndexOutOfBoundsException("Wrong index entered!");
        }
        int removedValue;
        if (index == 0) {
            removedValue = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedValue = current.next.data;
            current.next = current.next.next;
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
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
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
        Node current2 = head;
        while(current2 !=null) {

            if(current2.data == value) {
                return true;
            }
            current2 = current2.next;
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
        int index =0;

        while(current != null) {
            if(current.data == value) {
                return index;
            }
            current = current.next;
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
        return head==null;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
       Node current = head;
       int sizeCounter =0;

       while(current != null ) {
           sizeCounter++;
           current = current.next;
       }
       return sizeCounter;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = null;

    }

    @Override
    public void resize(int newSize) {

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

    private class LinkedIntListIterator implements Iterator<Integer> {
        private Node current;

        public LinkedIntListIterator() {
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
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}
