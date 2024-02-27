import java.util.Iterator;

public class LinkedIntList implements IntList
{       //helper inner/ nested class
    public class Node{
        int data;
        Node next;
//default
        public Node(){
            data = 0;
            next = null;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }//end of the node class

    //field for linkedIntlist class
    private Node head;
    private int size;
    public LinkedIntList(){
        head = null;
        size = 0;
    }


    /**
     * head is var that hold the memory of first node object
     *
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value)
    {

        // if the list is not empty
          head = new Node(value,head);
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {

        //set a pointer
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node(value,null);
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
    public void add(int index, int value)
    { // if index is greater than size or index is less than zero
        if( index< 0 || index >= size()){
            return;
        }
        //if index is zero
        if(index == 0) addFront(value);
        Node newNode = new Node(value,null);
        Node cur = head;
        for (int i = 0; i < index - 1; i++)
        {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        if( head == null ) return;
        if(head.next == null){
            head = null;
        }
        head= head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if(head == null) return;
        if(head.next == null) {
            head = null;
            size = 0;
            return;
        }
        Node cur = head;
        while(cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
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
    public int remove(int index)
    {
        return 0;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)
    {
        if(head == null || index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index is out of range");
        }
        Node cur = head;
        int count = 0 ;
        while (count < index){
            cur = cur.next;
            count ++;
        }
        return cur.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)
    {
        if(head == null) return false;

        //check if the fist node is true

        Node cur = head;
        while(cur != null){
            if(cur.data == value){
                return true;
            }
            cur = cur.next;
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
    public int indexOf(int value)
    {
        if(head == null) return -1;
        Node cur = head;
        int count = 0;
        while(cur != null){
            if(cur.data == value){
                return count;
            }
            cur = cur.next;
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
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        if(head == null) return 0;
        int count = 0 ;
        Node cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        head = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return null;
    }
}
