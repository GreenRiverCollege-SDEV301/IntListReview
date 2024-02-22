import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        int count = theList.size();
        assertEquals(count, 1);
        assertEquals(theList.get(0), 42);
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        assertEquals(theList.get(theList.size() - 1), 42);
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        //Fill the list with INITIAL_CAPACITY or 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        //Now add item 11:
        theList.addBack(42);
        assertEquals(theList.get(theList.size() - 1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 1000000; i++) {
            theList.addBack(i);
        }
        //Now add item 11:
        theList.addBack(42);
        assertEquals(theList.get(theList.size() - 1), 42);
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        //Create an empty list
        ArrayIntList theList = new ArrayIntList();

        //You can trigger multiple things here to get an exception
//        assertThrowsExactly(IllegalStateException.class, () -> {
//            theList.removeBack();
//        });

        //You can only do 1 thing here to trigger an exception
        assertThrowsExactly(IllegalStateException.class, theList::removeBack);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList() {

    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        //Create a list
        ArrayIntList theList = new ArrayIntList();

        //Fill list with 10 items
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        //Remove the item in the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
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