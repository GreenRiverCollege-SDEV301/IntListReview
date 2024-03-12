import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

//3 test methods required for each method empty, has items, has single item

class ArrayIntListTest
{
    //Add front
    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(20);

        String out = theList.toString();
        assertEquals("[20]", out);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithNonEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(13);
        theList.addFront(20);
        theList.addFront(8);
        theList.addFront(6);

        String out = theList.toString();
        assertEquals("[6, 8, 20, 13]", out );
    }

    @org.junit.jupiter.api.Test
    void addFrontWithResize()
    {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 10; i++)
        {
            theList.addFront(i);
        }

        theList.addFront(13);

        int out = theList.get(0);
        assertEquals(out, 13);
    }

    //Add back
    @org.junit.jupiter.api.Test
    void addBack()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);

        //Testing method 1
        String out = theList.toString();
        assertEquals(out, "[42]");

        //Testing method 2
        //assertEquals(theList.get(0), 42); // Test passes if theList.get(0) == 42
    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);

        //Testing method 1
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 42]");

        //Testing method 2
        //assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize()
    {
        ArrayIntList theList = new ArrayIntList();
        //fill the list with INITIAL_CAPACITY or 10 times
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        //now add item 11
        theList.addBack(42);

        assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResize()
    {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 1000000; i++)
        {
            theList.addBack(i);
        }

        //now add item 11
        theList.addBack(42);

        assertEquals(theList.get(theList.size()-1), 42);
    }

    //Just Add
    @org.junit.jupiter.api.Test
    void addToEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 20);

        String out = theList.toString();
        assertEquals("[20]", out);
    }

    @org.junit.jupiter.api.Test
    void addToSingletonList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 20);
        theList.add(1, 8);

        String out = theList.toString();
        assertEquals("[20, 8]", out);

    }

    @org.junit.jupiter.api.Test
    void addToListOf5()
    {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 5; i++)
        {
            theList.addBack(i);
        }

        theList.add(3, 83);
        String out = theList.toString();
        assertEquals("[0, 1, 2, 83, 3, 4]", out);
    }

    //Remove front
    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class, theList::removeFront);

    }

    @org.junit.jupiter.api.Test
    void removeFrontFromSingletonList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 20);
        theList.removeFront();

        String out = theList.toString();
        assertEquals("[]", out);

    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListOf10()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.removeFront();
        int out = theList.get(0);
        assertEquals(1, out);

    }

    //Remove Back
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();

//        assertThrowsExactly(IllegalStateException.class, () -> theList.removeBack());
        assertThrowsExactly(IllegalStateException.class, theList::removeBack);


    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList()
    {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(1);

        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[]");


    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10()
    {
        ArrayIntList theList = new ArrayIntList();

        //fill list with 10 items
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        //remove the item in the back
        theList.removeBack();

        //testing
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");

    }


    //Just remove
    @org.junit.jupiter.api.Test
    void removeFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class, () -> theList.remove(0));


    }

    @org.junit.jupiter.api.Test
    void removeFromSingletonList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(12);
        theList.remove(0);

        String out = theList.toString();
        assertEquals("[]", out);

    }

    @org.junit.jupiter.api.Test
    void removeFromListOf5()
    {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 5; i++)
        {
            theList.addBack(i);
        }

        theList.remove(3);
        String out = theList.toString();
        assertEquals("[0, 1, 2, 4]", out);


    }

    //Get
    @org.junit.jupiter.api.Test
    void get()
    {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        theList.remove(1);
        int out = theList.get(1);
        assertEquals(2, out);


    }

    //Contains
    @org.junit.jupiter.api.Test
    void contains()
    {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        boolean out = theList.contains(2);
        assertEquals(true, out);

    }

    @org.junit.jupiter.api.Test
    void indexOf()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        int out = theList.indexOf(5);
        assertEquals(5, out);

    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayIntList theList = new ArrayIntList();
        boolean out = theList.isEmpty();
        assertEquals(true, out);
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(2);

        int out = theList.size();
        assertEquals(1, out);
    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        String out = theList.toString();
        assertEquals("[]", out);

    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 5; i++)
        {
            theList.addBack(i);
        }
        Iterator<Integer> itr = theList.iterator();
        int x = 0;
        while(itr.hasNext())
        {
            int value = itr.next();
            assertEquals(x, value);
            x++;

        }

    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 5; i++)
        {
            theList.addBack(i);
        }
        String out = theList.toString();
        assertEquals("[0, 1, 2, 3, 4]", out);

    }
}