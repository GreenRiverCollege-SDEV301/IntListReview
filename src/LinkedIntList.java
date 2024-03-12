import java.util.Iterator;
import java.util.NoSuchElementException;
//add complexity class to each method


public class LinkedIntList implements IntList {
    //nested helper/inner class
    public class Node{
        //holds the data value
        int data;
        //holds the address of the next node
        Node next;

        public Node(){
            data = 0;
            next = null;
        }
        // T = 2 O(1) constant
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public int getData(){
            return this.data;
        }
    }
    //end of class node

    //fields for LinkedIntList class

    private Node head;          //address of first node in list
    private int size;           //number of nodes/items in list

    //T = 2, O(1) constant time
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
    //T = 7 O(1) constant time
    @Override
    public void addFront(int value) {
        Node temp = new Node(value, head);
        head = temp;
        size++;
    }
    /*
      //if empty
        if(head == null){
           head = new Node(value, null);
           size++;
        }else{
        //if non-empty
        head = new Node(value, head);
        size++;
        }
     */

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */

    //if list is empty go into if, T = 5 which is O(1) constant
    //if list is non-empty go into else, T = 2 * size +6 == O(n) linear
    @Override
    public void addBack(int value) {
        Node temp = new Node(value, null);
        if (head == null) {
            head = new Node(value, null);
            size++;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
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
    public void add(int index, int value) throws IndexOutOfBoundsException{
        //add  to front empty list. TESTED IN MAIN
        if(size == 0) {
            head = new Node(value, null);
            size++;
            //add to front non-empty. TESTED IN MAIN
        }else if(size >= 1 && index == 0){
            Node curr = head;
            Node temp = new Node(value, curr);
            head = temp;
            size++;
            //add to middle. TESTED IN MAIN
        }else if(index > 1 && index < size){
            Node curr = head;
            Node temp;
            int count = 0;
            while(count != index-1){
                curr = curr.next;
                count++;
            }
            temp = curr.next;
            curr.next = new Node(value,temp);
            curr = head;
            size++;
            //add back. TESTED IN MAIN
        }else if(index == size){
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(value,null);
            curr = head;
            size++;
            //throw exception out of bounds
        }else if(index == size+1){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() throws NoSuchElementException{
        if(size == 0){
            throw new NoSuchElementException();
        }else{
            Node curr = head.next;
            head = curr;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            head = null;
            size--;
        } else if (size >= 2) {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
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
    public int remove(int index)throws IndexOutOfBoundsException {
        //empty list. TESTED IN MAIN
        if (size == 0) {
            return -1;
            //from front. TESTED IN MAIN
        } else if (size >= 1 && index == 0) {
            int value = head.data;
            head = head.next;
            size--;
            return value;
            //from middle. TESTED IN MAIN
        } else if (index >= 1 && index <= size-2) {
            int count = 0;
            Node curr = head;
            Node temp;
            int value;
            while (count != index-1) {
                curr = curr.next;
                count++;
            }
            temp = curr.next.next;
            value = curr.next.data;
            curr.next = temp;
            curr = head;
            size--;
            return value;
            //from back. TESTED IN MAIN
        } else if (index == size-1) {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            int value = curr.next.data;
            curr.next = null;
            size--;
            return value;
            //throw exception out of bounds
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    //O(n) linear - to get an item at an index
    @Override
    public int get(int index)throws IndexOutOfBoundsException {
        //empty list
        Node curr = head;
        if (size == 0) {
            return -1;
            //get first
        }else if(index == 0){
            return curr.data;
            //get middle
        }else if(index >= 1 &&  index <= size-2){
            int count = 0;
            while(count != index){
                curr = curr.next;
                count++;
            }
            return curr.data;
            //get last
        }else if(index == size -1){
            while(curr.next != null){
                curr = curr.next;
            }
            return curr.data;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == value) {
                return true;
            }
            curr = curr.next;
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
        Node curr = head;
        int count = 0;
        //front to middle
        while(curr.next != null){
            if(curr.data == value){
                return count;
            }
            curr = curr.next;
            count++;
        }
        //get back
        while(curr != null){
            if(curr.data == value){
                return count;
            }
            curr = curr.next;
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
        if(size == 0){
            return true;
        }
        return false;
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
        LinkedIterator iterator = new LinkedIterator();
        return iterator;
    }



    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = head;
        while(curr.next != null) {
            sb.append(curr.data);
            sb.append(", ");
            curr = curr.next;
        }
        sb.append(curr.data);
        sb.append("]");
        return sb.toString();
    }

    //helper method 02-27-24 in-class
    public void print(){
        //create temp variable
        //copy address from head
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    //helper class
    public class LinkedIterator implements Iterator<Integer> {
        private Node current;

        public LinkedIterator() {
            current = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (current != null) {
                return false;
            } else {
                return true;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public Integer next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int result = current.data;
            current = current.next;
            return result;
        }
    }
}
