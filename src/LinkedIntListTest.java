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
    void add()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.add(0, 11);
        theList.add(1, 12);
        theList.add(2,13);
        String out = theList.toString();
        assertEquals(out, "Head ->  [11] [12] [13]");
    }

    @Test
    void removeFront()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(1);
        theList.removeFront();
        assertEquals(0, theList.size()); //remove front from list with one item
        String out = theList.toString();
        assertEquals(out, "Head -> "); //check an empty list
        //remove front from an empty list
        theList.removeFront();
        theList.toString();
        assertEquals(out, "Head -> "); //check an empty list
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.removeFront();
        out = theList.toString();
        assertEquals(3, theList.size()); //check size of list
        assertEquals(out, "Head ->  [2] [3] [4]"); //check to see fronts removed
    }

    @Test
    void removeBack()
    {
        LinkedIntList thelist = new LinkedIntList();
        thelist.addBack(1);
        thelist.addBack(2);
        thelist.addBack(3);
        thelist.addBack(4);
        String out = thelist.toString();
        assertEquals(4, thelist.size());
        assertEquals(out, "Head ->  [1] [2] [3] [4]");
        thelist.removeBack();
        out = thelist.toString();
        assertEquals(3, thelist.size());
        assertEquals(out, "Head ->  [1] [2] [3]");
        thelist.clear();
        thelist.removeBack();
        out = thelist.toString();
        assertEquals(out, "Head -> ");
    }

    @Test
    void remove()
    {
        LinkedIntList thelist = new LinkedIntList();
        assertEquals(-1, thelist.remove(1));
        assertEquals(-1, thelist.remove(4));
        thelist.addBack(1);
        thelist.addBack(2);
        thelist.addBack(3);
        thelist.addBack(4);
        thelist.addBack(5);
        assertEquals(4, thelist.remove(3));
        String out = thelist.toString();
        assertEquals(out, "Head ->  [1] [2] [3] [5]");
        assertEquals(5, thelist.remove(3));
        assertEquals(3, thelist.size());
        out = thelist.toString();
        assertEquals(out, "Head ->  [1] [2] [3]");
        assertEquals(1,thelist.remove(0));
        out = thelist.toString();
        assertEquals(out, "Head ->  [2] [3]");
        assertEquals(2, thelist.size());
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
    void indexOf()
    {
        LinkedIntList theList = new LinkedIntList();
        assertThrowsExactly(IllegalStateException.class, () -> theList.indexOf(5));
        theList.addFront(5);
        theList.addFront(4);
        theList.addFront(3);
        theList.addFront(2);
        theList.addFront(1);
        theList.addFront(0);
        assertEquals(5, theList.indexOf(5));
        assertEquals(0, theList.indexOf(0));
        assertEquals(3, theList.indexOf(3));

    }

    @Test
    void isEmpty()
    {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(true, theList.isEmpty());
        theList.addFront(4);
        assertEquals(false, theList.isEmpty());
        theList.clear();
        assertEquals(true, theList.isEmpty());
    }

    @Test
    void size()
    {
        LinkedIntList theList = new LinkedIntList();
        //test empty
        assertEquals(0, theList.size());
        theList.addBack(12);
        theList.addFront(11);
        theList.add(1,14);
        assertEquals(3, theList.size()); //size 3
        theList.remove(1); //remove 1
        assertEquals(2, theList.size()); //size 2
        theList.addFront(22);
        theList.addFront(11);
        assertEquals(4, theList.size()); //size 4
        theList.removeFront();
        theList.removeBack();
        assertEquals(2,theList.size());

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