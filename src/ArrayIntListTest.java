import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest
{

    public static final int ACTUAL = 42;

    @org.junit.jupiter.api.Test
    void addFront()
    {
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(0), 42);

    }

    @org.junit.jupiter.api.Test
    void add()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1),42);
    }

    @org.junit.jupiter.api.Test
    void addBackAndResize()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1),42);
    }

    @org.junit.jupiter.api.Test
    void removeFront()
    {
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalArgumentException.class,
                ()->{theList.removeBack();
        });
    }

    @org.junit.jupiter.api.Test
    void removeBackSingletonList()
    {
    }

    @org.junit.jupiter.api.Test
    void removeBackfromListOf10()
    {
        //create a list
        ArrayIntList theList = new ArrayIntList();

        // fill list with 10 items
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
    }

    @org.junit.jupiter.api.Test
    void get()
    {
    }

    @org.junit.jupiter.api.Test
    void contains()
    {
    }

    @org.junit.jupiter.api.Test
    void indexOf()
    {
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
    }

    @org.junit.jupiter.api.Test
    void size()
    {
    }

    @org.junit.jupiter.api.Test
    void clear()
    {
    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
    }
}