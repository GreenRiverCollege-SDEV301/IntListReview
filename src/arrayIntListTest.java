import static org.junit.jupiter.api.Assertions.*;

class arrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        theList.addFront(10);
        assertEquals(theList.get(0), 10);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithNonEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addFront(10);
        assertEquals(theList.get(0), 10);
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(42);
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void addToEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        theList.add(0,4);
        assertEquals(theList.get(0), 4);
    }

    @org.junit.jupiter.api.Test
    void addToNonEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.add(2,10);
        assertEquals(theList.get(2), 10);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        assertThrowsExactly(IllegalStateException.class, () -> {
            theList.removeFront();
        });
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListWithOneItem()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(1);
        theList.removeFront();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        assertThrowsExactly(IllegalStateException.class, () -> {
            theList.removeBack();
        });
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListWith10Items()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        theList.removeFront();

        String out = theList.toString();

        assertEquals(out, "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListWithOneItem()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(1);
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        theList.removeBack();

        String out = theList.toString();

        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }

    @org.junit.jupiter.api.Test
    void removeFromEmptyList()
    {
        arrayIntList theList = new arrayIntList();
        assertThrowsExactly(IllegalStateException.class, () -> {
            theList.remove(0);
        });
    }

    @org.junit.jupiter.api.Test
    void removeFromListWithOneItem()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(5);
        theList.remove(0);
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeFromListWith10()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.remove(5);
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 6, 7, 8, 9]");
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertEquals(theList.get(5), 5);
    }

    @org.junit.jupiter.api.Test
    void containsTrue()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertTrue(theList.contains(5));
    }

    @org.junit.jupiter.api.Test
    void containsFalse()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertFalse(theList.contains(15));
    }

    @org.junit.jupiter.api.Test
    void indexOf()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(5), 5);
    }

    @org.junit.jupiter.api.Test
    void isEmptyTrue()
    {
        arrayIntList theList = new arrayIntList();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyFalse()
    {
        arrayIntList theList = new arrayIntList();
        theList.addBack(5);
        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        assertEquals(theList.size(), 10);
    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.clear();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        arrayIntList theList = new arrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }
}