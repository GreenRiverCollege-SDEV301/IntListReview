import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    // regular case where the list has items, add value to front
    void addFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        theList.addBack(6);

        theList.addFront(7);
        assertEquals(theList.get(0), 7);
    }

    @org.junit.jupiter.api.Test
    // test addFront if there are no values in the list (list is empty)
    void addFrontWithNoValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(2);
        assertEquals(theList.get(0), 2);
    }

    @org.junit.jupiter.api.Test
    // test if there is only a single value in the list
    void addFrontWithSingleValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(2);
        theList.addFront(100);
        assertEquals(theList.get(0), 100);
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY or 10 items
        for (int i = 0; i < 100; i++) {
            theList.addBack(i);
        }

        // now add item 11:
        theList.addBack(42);

        assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        theList.add(3, 55);

        System.out.println(theList);
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        theList.removeFront();

        System.out.println(theList);
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        theList.removeBack();

        System.out.println(theList);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        // create an empty list
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class, () -> {theList.removeBack();});
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList() {

    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        ArrayIntList theList = new ArrayIntList();


        // fill list with 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        // remove the item in the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8, 0]");
    }

    @org.junit.jupiter.api.Test
    void remove() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        ArrayIntList removed = new ArrayIntList();
        removed.addBack(1);
        removed.addBack(2);
        removed.addBack(4);
        removed.addBack(5);

        theList.remove(2);

        assertEquals(removed.size(), theList.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        assertEquals(5, theList.get(4));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        assertEquals(false, theList.contains(6));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        System.out.println(theList.indexOf(4));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayIntList theList = new ArrayIntList();

        assertEquals(0, theList.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        System.out.println(theList.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);

        theList.clear();
        assertEquals(0, theList.size());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}