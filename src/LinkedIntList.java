import java.util.Iterator;

public class LinkedIntList implements IntList {
    private Node head;
    private int size = 0;

    /**
     *
     */
    private class Node {
        Integer value;
        Node next;

        private Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
        private Node(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedIntList() {
        this.head = null;
    }

    // Time Complexity: O(1)
    public LinkedIntList(Integer... value) {
        this.head = new Node(value[0]);
        for (Integer val : value) {
            this.addBack(val);
        }
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     * Time Complexity: O(1)
     *
     * @param value value to be inserted
     *
     *
     */
    @Override
    public void addFront(int value) {
        this.head = new Node(value, head);
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     * Time Complexity: O(n)
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(value);
        }
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     * Time Complexity: O(n)
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        if (index > size) {
            throw new IndexOutOfBoundsException("");
        } else if (index == 0) {
            addFront(value);
        } else {
                int currIndex = 0;
                Node curr = head;
                while (currIndex < index - 1) {
                    curr = curr.next;
                    currIndex++;
                }
                curr.next = new Node(value, curr.next);
        }
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     * Time Complexity: O(1)
     */
    @Override
    public void removeFront() {
        if (head != null) {
            head = head.next;
            size--;
        } else {
            throw new NullPointerException("List is empty");
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     * Time Complexity: O(n)
     */
    @Override
    public void removeBack() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node curr = head;
                while (curr.next.next != null) {
                    curr = curr.next;
                }
                curr.next = null;
            }
            size--;
        } else {
            throw new NullPointerException("");
        }
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     * Time Complexity: O(n)
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if (!isEmpty() && index < size) {
            if (index == 0) {
                int temp = head.value;
                head = head.next;
                size--;
                return temp;
            } else {
            int currIndex = 0;
            Node curr = head;
            while (currIndex + 1 != index) {
                curr = curr.next;
                currIndex++;
            }
            int temp = curr.next.value;
            curr.next = curr.next.next;
            return temp;
            }
        }
        throw new IndexOutOfBoundsException("Not valid index");
    }

    /**
     * Returns the value at the specified position in the list.
     * Time Complexity: O(n)
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (index < size) {
            if (head.next == null) {
                return head.value;
            } else {
                Node curr = head;
                int currIndex = 0;
                while (currIndex != index) {
                    curr = curr.next;
                    currIndex++;
                }
                return curr.value;
            }
        } else {
            throw new IndexOutOfBoundsException("");
        }
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     * Time Complexity: O(n)
     */
    @Override
    public boolean contains(int value) {
        if (head != null) {
            Node curr = head;
            while (curr != null) {
                if (curr.value == value) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     * Time Complexity: O(n)
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        if (head != null) {
            Node curr = head;
            int currIndex = 0;
            while (curr != null) {
                if (curr.value == value) {
                    return currIndex;
                }
                currIndex++;
                curr = curr.next;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     * Time Complexity: O(1)
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Returns the number of values in this list.
     * Time Complexity: O(1)
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
     * Time Complexity: O(1)
     */
    @Override
    public void clear() {
        this.head = null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * Time Complexity: O(1)
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private Node curr = (head == null ? null : head);

            // Time Complexity: O(1)
            @Override
            public boolean hasNext() {
                if (curr == null) {
                    curr = head;
                }
                return curr != null;
            }

            // Time Complexity: O(1)
            @Override
            public Integer next() {
                if (hasNext()) {
                    Integer temp = curr.value;
                    curr = curr.next;
                    return temp;
                }
                throw new NullPointerException("No such next node");
            }
        };
    }

    /**
     * Time Complexity: O(n)
     * @return String representation of the Linked List
     */
    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = head;

        while (curr.next != null) {
            sb.append(curr.value);
            sb.append(", ");
            curr = curr.next;
        }
        sb.append(curr.value);
        sb.append("]");
        return sb.toString();
    }
}
