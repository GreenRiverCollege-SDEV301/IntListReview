import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    @Test
    void addFront()
    {
        LinkedIntList thelist = new LinkedIntList();
        //check while list is empty
        assertEquals("Head -> ", thelist.toString());
        //add one
        thelist.addFront(101);
        String out = thelist.toString();
        assertEquals(out, "Head ->  [101]");
        //add one again
        thelist.addFront(102);
        out = thelist.toString();
        assertEquals(out, "Head ->  [102] [101]");
    }

    @Test
    void addBack()
    {
        LinkedIntList theList = new LinkedIntList();
        String out = theList.toString();
        assertEquals(out, "Head -> ");
        theList.addBack(4);
        out = theList.toString();
        assertEquals(out, "Head ->  [4]");
        theList.addBack(5);
        theList.addBack(6);
        theList.addBack(7);
        out = theList.toString();
        assertEquals(out, "Head ->  [4] [5] [6] [7]");

    }

    @Test
    void add() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void get()
    {
        LinkedIntList theList = new LinkedIntList();
        //test on empty list
        assertThrowsExactly(NullPointerException.class, () -> theList.get(0));
        //added a few and still throw out of bounds
        theList.addFront(4);
        theList.addFront(3);
        theList.addFront(2);
        theList.addFront(1);
        theList.addFront(0);
        assertThrowsExactly(NullPointerException.class, () -> theList.get(5));
        //now grab a valid index
        assertEquals(3, theList.get(3));

    }

    @Test
    void contains()
    {
        LinkedIntList theList = new LinkedIntList();
        //test an empty list
        assertEquals(false, theList.contains(12));
        //now with some items
        theList.addFront(8);
        theList.addFront(3);
        theList.addFront(4);
        theList.addFront(2);
        assertEquals(false, theList.contains(7));
        assertEquals(true, theList.contains(3));
        assertEquals(true, theList.contains(8));
        assertEquals(true, theList.contains(2));
    }

    @Test
    void indexOf() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void clear()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(1);
        theList.addFront(2);
        theList.addFront(3);
        String out = theList.toString();
        assertEquals(out, "Head ->  [3] [2] [1]");
        theList.clear();
        out = theList.toString();
        assertEquals(out, "Head -> ");
    }

    @Test
    void iterator() {
    }
}