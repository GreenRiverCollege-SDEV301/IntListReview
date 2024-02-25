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
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(true, theList.isEmpty());
        theList.addBack(88);
        assertEquals(false, theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}