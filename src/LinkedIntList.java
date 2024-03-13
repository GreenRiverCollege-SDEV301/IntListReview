import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    private Node head;
    private int size;

    /**
     * T = 2 is o(1) constant
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
     * @param value value to be inserted
     *
     * T = 2 + 1 + 1 + 2 -> 6 is O(1) constant time
     */
    @Override
    public void addFront(int value) {
        head = new Node(value, head);

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     * T = 7 is O(1) constant or T = 2 * size + 6 -> n is O(n) linear
     */
    @Override
    public void addBack(int value) {
        if(head == null) {
            head = new Node(value, null);
        } else {
            Node current = head;

            while(current.next != null) {
                current = current.next;
            }

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
     *
     * T =
     */
    @Override
    public void add(int index, int value) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if(head != null) {
            if(index == 0) {
                addFront(value);
            } else if(index == size) {
                addBack(value);
            } else {
                Node current = head;
                Node previous = null;
                int count = 1;

                while(current.next != null) {
                    previous = current;
                    current = current.next;

                    if(count == index) {
                        previous.next = new Node(value, current);
                    }

                    count++;
                }

                size++;
            }
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(head != null) {
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
        if(head != null) {
            Node current = head;

            while(current.next.next != null) {
                current = current.next;
            }

            current.next = null;
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
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(head == null) {
            throw new IllegalStateException();
        }

        int value = get(index);

        if(index == 0) {
            removeFront();
        } else if(index == size - 1) {
            removeBack();
        } else {
            Node current = head;
            Node previous = null;
            int count = 1;

            while(current.next != null) {
                previous = current;
                current = current.next;

                if(count == index) {
                    previous.next = current.next;
                }

                count++;
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
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(head != null) {
            Node current = head;
            int count = 0;

            while(current != null) {
                if(count == index) {
                    return current.data;
                }

                current = current.next;
                count++;
            }

        }

        return -1;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if(head != null) {
            Node current = head;

            while(current != null) {
                if(current.data == value) {
                    return true;
                }

                current = current.next;
            }
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
        if(head != null) {
            Node current = head;
            int count = 0;

            while(current != null) {
                if(current.data == value) {
                    return count;
                }

                current = current.next;
                count++;
            }
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
        return new LinkedIntListIterator();
    }

    // helper method
    public void print() {
        if(head == null) {
            System.out.println("[]");
        } else {
            Node current = head;
            System.out.print("[");

            while (current.next != null) {
                System.out.print(current.data + ", ");

                current = current.next;
            }

            System.out.print(current.data + "]");
        }
    }

    @Override
    public String toString() {
        if(head == null) {
            return "[]";
        }

        StringBuilder str = new StringBuilder("[");
        Node current = head;

        while(current.next != null) {
            str.append(current.data);
            str.append(", ");

            current = current.next;
        }

        str.append(current.data);
        str.append("]");

        return str.toString();
    }

    public class Node {
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
    }

    public class LinkedIntListIterator implements Iterator<Integer>{
        private Node current;
        private int currentPosition;

        public LinkedIntListIterator() {
            current = head;
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            int value = get(currentPosition);
            current = current.next;
            currentPosition++;

            return value;
        }

    }
}
