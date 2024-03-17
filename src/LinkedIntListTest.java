import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    @Test
    void addFront()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        assertEquals(6, theList.get(0));
    }

    @Test
    void addBack()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        theList.addBack(25);
        assertEquals(25, theList.get(3));
    }

    @Test
    void add()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        theList.add(2,12);
        assertEquals(12, theList.get(2));
    }

    @Test
    void removeFront()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        theList.removeFront();
        assertEquals(34, theList.get(0));
    }

    @Test
    void removeBack()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        theList.removeBack();
        assertEquals(34, theList.get(theList.size()-1));
    }

    @Test
    void remove()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        theList.remove(1);
        assertEquals(6, theList.get(1));
    }

    @Test
    void get()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        assertEquals(34, theList.get(1));
    }

    @Test
    void containsTrue()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        assertTrue(theList.contains(34));
    }
    @Test
    void containsFalse()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        assertFalse(theList.contains(5));
    }

    @Test
    void indexOf()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        assertEquals(1, theList.indexOf(34));
    }

    @Test
    void isEmptytrue()
    {
        LinkedIntList theList = new LinkedIntList();
        assertTrue(theList.isEmpty());
    }

    @Test
    void isEmptyFalse()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        assertFalse(theList.isEmpty());
    }

    @Test
    void size()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addBack(34);
        theList.add(1,10);
        theList.addFront(7);
        theList.addBack(35);
        theList.add(1,11);
        theList.removeBack();
        theList.removeFront();
        theList.remove(2);

        assertEquals(3, theList.size());
    }

    @Test
    void clear()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(6);
        theList.addFront(34);
        theList.addFront(93);
        theList.clear();
        assertEquals(0, theList.size());
    }

    @Test
    void iterator() {
    }
}