import java.sql.Array;
import java.util.Iterator;

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

    // removeFront() ------------------------------------------
    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        theList.removeFront();
        String out = theList.toString();
        assertEquals(out, "[]");
    }
    @org.junit.jupiter.api.Test
    void removeFrontFromListOf10() {
        ArrayIntList theList = new ArrayIntList();

        // fill list
        for (int i = 0; i < 10; i++) {
            theList.addFront(i);
        }
        theList.removeFront();

        String out = theList.toString();
        assertEquals(out, "[8, 7, 6, 5, 4, 3, 2, 1, 0]");
    }
    @org.junit.jupiter.api.Test
    void removeFrontSizeTest() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(42);
        theList.removeFront();

        String out = theList.toString();
        assertEquals(0, theList.size());
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

    // remove() ------------------------------------------------
    @org.junit.jupiter.api.Test
    void removeFromEmptyList() {
       ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IllegalStateException.class,
                () -> {theList.remove(0);});
    }
    @org.junit.jupiter.api.Test
    void removeOutOfBoundsPositive() {
       ArrayIntList theList = new ArrayIntList();
       theList.addFront(1);
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.remove(1);});
    }
    @org.junit.jupiter.api.Test
    void removeOutOfBoundsNegative() {
       ArrayIntList theList = new ArrayIntList();
       theList.addFront(1);
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.remove(-1);});
    }
    @org.junit.jupiter.api.Test
    void removeFromListOf10() {
       ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.remove(4);
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 5, 6, 7, 8, 9]");
    }
    @org.junit.jupiter.api.Test
    void removeLastItemFromListOf10() {
       ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.remove(9);
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }
    // get() ---------------------------------------------------
    @org.junit.jupiter.api.Test
    void getFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.get(0);});
    }
    @org.junit.jupiter.api.Test
    void getNegativeOutOfBounds() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.get(-1);});
    }
    @org.junit.jupiter.api.Test
    void getPositiveOutOfBounds() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.get(1);});
    }
    @org.junit.jupiter.api.Test
    void getMiddleOfList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(42);
        theList.addBack(4);
        assertEquals(theList.get(2), 42);
    }
    // contains() ---------------------------------------------
    @org.junit.jupiter.api.Test
    void containsNotThere() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertFalse(theList.contains(42));
    }
    @org.junit.jupiter.api.Test
    void containsThere() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertTrue(theList.contains(4));
    }
    // indexOf() --------------------------------------------
    @org.junit.jupiter.api.Test
    void indexOfNotThere() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(42), -1);
    }
    @org.junit.jupiter.api.Test
    void indexOfThere() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(2), 2);
    }
    // isEmpty() ------------------------------------------------
    @org.junit.jupiter.api.Test
    void isEmptyEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyNotEmpty() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertFalse(theList.isEmpty());
    }
    // size() -------------------------------------------
    @org.junit.jupiter.api.Test
    void sizeEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.size(), 0);
    }
    @org.junit.jupiter.api.Test
    void sizeTen() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.size(), 10);
    }
    // clear() ---------------------------------------------------
    @org.junit.jupiter.api.Test
    void clearSizeTest() {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        assertEquals(theList.size(), 0);
    }
    @org.junit.jupiter.api.Test
    void clearListTest() {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        int total = 0;
        Iterator<Integer> itr = theList.iterator();
        while (itr.hasNext()) {
            total = total+itr.next();
        }
        assertEquals(total, 15);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        theList.removeFront();
        String out = theList.toString();
        assertEquals(out, "[2, 3, 4, 5]");
    }
}