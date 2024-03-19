import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    // addFront() --------------------------------------------
    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }
    @org.junit.jupiter.api.Test
    void addFrontWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.addFront(2);
        theList.addFront(3);
        theList.addFront(4);
        theList.addFront(42);
        String out = theList.toString();
        assertEquals(out, "[42, 4, 3, 2, 1]");
    }
    @org.junit.jupiter.api.Test
    void addFrontWithResizedList() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addFront(i);
        }
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    // addBack() --------------------------------------------
    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.get(0), 42);

    }
    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        //assertEquals(theList.get(theList.size()-1), 42);
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 42]");
    }
    @org.junit.jupiter.api.Test
    void addBackWithResizedList() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY or 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        // now add item 11
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }
    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY or 10 items
        for (int i = 0; i < 1000000; i++) {
            theList.addBack(i);
        }
        // now add item 11
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }

    // add() ----------------------------------
    @org.junit.jupiter.api.Test
    void addWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0,42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addAt10() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.add(10,42);});

    }

    @org.junit.jupiter.api.Test
    void addWithFullList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(10);
        theList.addBack(11);
        theList.addBack(12);
        theList.addBack(13);
        theList.addBack(14);
        theList.addBack(15);
        theList.addBack(16);
        theList.addBack(17);
        theList.addBack(18);
        theList.addBack(19);
        theList.add(5,42);
        assertEquals(theList.toString(), "[10, 11, 12, 13, 14, 42, 15, 16, 17, 18, 19]");
    }

    @org.junit.jupiter.api.Test
    void addFirstWithFullList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(10);
        theList.addBack(11);
        theList.addBack(12);
        theList.addBack(13);
        theList.addBack(14);
        theList.addBack(15);
        theList.addBack(16);
        theList.addBack(17);
        theList.addBack(18);
        theList.addBack(19);
        theList.add(0,42);
        assertEquals(theList.toString(), "[42, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]");
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    // removeBack() -------------------------------------------
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class,
                () -> {theList.removeBack();});
    }
    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        ArrayIntList theList = new ArrayIntList();

        //fill list with 10 items (0,1,2,3,4,5,6,7,8,9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }
    @org.junit.jupiter.api.Test
    void removeBackFromOneItemList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.removeBack();
        assertEquals(0, theList.size());
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