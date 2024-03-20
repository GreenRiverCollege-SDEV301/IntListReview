import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedIntList implements IntList{

    public class Node {
    int data;
    Node next;

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    }

    private Node head;
    private int size;

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
//        Node temp = head;
//        head = new Node(value, temp);

        Node front = new Node(value, head);
        head = front;
        size ++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     *if list is empty runtime is T=5 O(1) constant, if list not empty, T=2n+6 (n = size) O(n) linear
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if(head == null){
            head = new Node(value, null);
        }else{
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(value, null);
        }

        size ++;
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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of Range.");
        }else{
            Node current = head;
            if(index == 0){
                head = new Node(value, current);
            }else{
                for (int i = 0; i < index-1; i++) {
                    current = current.next;
                }
                current.next = new Node(value, current.next);
            }
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
        head = head.next;
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
        size --;
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
        int value = 0;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Range.");
        } else {
            Node current = head;
            if(index == 0){
                value = head.data;
                head = head.next;
            }else{
                for (int i = 0; i < index-1; i++) {
                    current = current.next;
                }
                value = current.next.data;
                current.next = current.next.next;
            }
            size--;
        }
        return value;
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Range.");
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
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
        Node current = head;
        while(current!=null){
            if(current.data == value){
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
        int index = 0;
        while(current!=null){
            if(current.data == value){
                return index;
            }
            current = current.next;
            index ++;
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
        head.next = null;
        head.data = 0;
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

    public void print() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);

            current = current.next;
        }

    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
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

    public class LinkedIterator implements Iterator<Integer> {

        private Node current;

        public LinkedIterator(){
            current = head;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int result = current.data;
            current = current.next;
            return result;
        }

    }
}


