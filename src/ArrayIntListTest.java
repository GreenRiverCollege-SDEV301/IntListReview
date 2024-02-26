import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(11);
        theList.addFront(12);
        theList.addFront(13);
        theList.addFront(14);
        theList.addFront(15);
        String out = theList.toString();
        assertEquals(out, "[15,14,13,12,11]");
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
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.add(5,99);
        assertEquals(99, theList.get(5));
        assertEquals(4, theList.get(4));
        assertEquals(5, theList.get(6));
        assertEquals(9,theList.get(10));
        theList.add(10, 1000);
        assertEquals(1000,theList.get(10));
        assertEquals(9,theList.get(11));

    }

    @org.junit.jupiter.api.Test
    void removeFrontEmpty()
    {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IllegalStateException.class, () -> theList.removeFront());
    }
//not working :(((
    @org.junit.jupiter.api.Test
    void removeFront()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.removeFront();
        assertEquals(1, theList.get(0));
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
        assertEquals(out, "[0,1,2,3,4,5,6,7,8]");

    }
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IllegalStateException.class, () -> theList.removeBack());
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertEquals(5,theList.remove(5));
        String out = theList.toString();
        assertEquals(out, "[0,1,2,3,4,6,7,8,9]");
        theList.clear();
        assertThrows(IllegalStateException.class, () -> theList.remove(8));
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        assertEquals(0, theList.get(9));
        assertEquals(2,theList.get(1));
        assertEquals(4,theList.get(3));

    }

    @org.junit.jupiter.api.Test
    void contains()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(false, theList.contains(9));
        theList.addBack(0);
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        assertEquals(false, theList.contains(4));
        assertEquals(true, theList.contains(2));
    }

    @org.junit.jupiter.api.Test
    void indexOf()
    {
        ArrayIntList theList = new ArrayIntList();
        //test while empty
        assertEquals(-1, theList.indexOf(2));

        //test with items
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        assertEquals(3, theList.indexOf(4));
        assertEquals(-1, theList.indexOf(8));
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(true, theList.isEmpty());
        theList.addBack(88);
        assertEquals(false, theList.isEmpty());
        theList.clear();
        assertEquals(true, theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(0, theList.size());
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertEquals(10, theList.size());
        theList.removeBack();
        assertEquals(9, theList.size());
        theList.removeFront();
        assertEquals(8, theList.size());

    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(0);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.clear();
        assertEquals(true, theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
        //tbh no clue how I should test this
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
       ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        String out = theList.toString();
        assertEquals(out, "[0,1,2,3,4,5,6,7,8,9]");
    }
}