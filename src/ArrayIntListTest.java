import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
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
    void add() {
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
            theList.addFront(i);
        }
        theList.removeFront();
        assertEquals(8, theList.get(0));
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
    void isEmpty() {
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