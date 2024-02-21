import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.addFront(88);
        assertEquals(theList.get(0), 88);
        assertEquals(theList.get(1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBack()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.addBack(22);
        int count = theList.size();
        //check to ensure list is proper size
        assertEquals(count, 3);
        //check to ensure list is in proper order
        assertEquals(theList.get(1), 88);
        assertEquals(theList.get(2), 22);
        theList.removeBack();
        theList.addBack(33);
        assertEquals(theList.get(2), 33);
    }

    @org.junit.jupiter.api.Test
    void add()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 42);
        theList.add(1, 88);
        assertEquals(theList.get(0), 42);
        assertEquals(theList.get(1), 88);
    }

    @org.junit.jupiter.api.Test
    void removeFront()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.removeFront();
        assertEquals(theList.size(), 1);
        assertEquals(theList.get(0), 88);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");

    }
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();

        assertThrows(IllegalStateException.class, () -> {theList.removeBack();});
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.removeBack();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.remove(1), 88);
        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.get(1), 88);
    }

    @org.junit.jupiter.api.Test
    void contains()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertTrue(theList.contains(42));
        assertFalse(theList.contains(99));
    }

    @org.junit.jupiter.api.Test
    void indexOf()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.indexOf(42), 0);
        assertEquals(theList.indexOf(88), 1);
        assertEquals(theList.indexOf(99), -1);
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
        theList.addBack(42);
        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.size(), 0);
        theList.addBack(42);
        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.clear();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        Iterator<Integer> iterator = theList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 42);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 88);
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.toString(), "[]");
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.toString(), "[42, 88]");
    }
}