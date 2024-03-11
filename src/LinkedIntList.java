import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{
    public class Node{
        int data;
        Node next; //holds address of next node

        public Node(){
            data = 0;
            next = null;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }//end of class node

    //fields for LinkedIntList
    private Node head;
    private int size;

    /**
     *
     */
    public LinkedIntList(){
        head = new Node();
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * T = O()
     *
     * @param value value to be inserted
     */
    @java.lang.Override
    public void addFront(int value) {
        Node temp = new Node(value, head);
        temp.next = head;
        head = temp;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * if list is empty T=5 O(1)
     * if list not empty T = 2N + 6 O(N)
     *
     * @param value value to be inserted
     */
    @java.lang.Override
    public void addBack(int value) {
        //To Do
        if(head == null){
            head = new Node(value, null);
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value, null);
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
    @java.lang.Override
    public void add(int index, int value) {

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @java.lang.Override
    public void removeFront() {
        //To Do
        head = head.next;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @java.lang.Override
    public void removeBack() {
        //To Do
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp = null;
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
    @java.lang.Override
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
    @java.lang.Override
    public int get(int index) {
        return 0;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @java.lang.Override
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
    @java.lang.Override
    public int indexOf(int value) {
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @java.lang.Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @java.lang.Override
    public int size() {
        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @java.lang.Override
    public void clear() {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @java.lang.Override
    public Iterator<Integer> iterator() {
        return new LinkedIterator();
    }

    public void print(){
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
    }

    public String toString(){
        if(head == null){
            return"[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while(current.next != null){
            sb.append(current.data);
            sb.append(", ");
            current = current.next;
        }

        //add last node
        sb.append(current.data);
        sb.append("]");

        return sb.toString();
    }

    public class LinkedIterator implements Iterator<Integer>{
        private Node current;

        public LinkedIterator(){
            current = head;
        }
        public boolean hasNext(){
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if(current.next == null){
                throw new NoSuchElementException();
            }
            int result = current.data;
            current = current.next;
            return result;
        }

    }
}
