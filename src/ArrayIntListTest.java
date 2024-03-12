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
        //assertEquals(theList.get(0), 1);
        String out = theList.toString();
        assertEquals(out,"[42]");

    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(theList.size()-1), 42);

    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        theList.addBack(6);
        theList.addBack(7);
        theList.addBack(8);
        theList.addBack(9);
        theList.addBack(10);
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(theList.size()-1), 42);

    }

    @org.junit.jupiter.api.Test
    void addBackWithLargeCount() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 1000000; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.get(theList.size()-1), 999999);

    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        assertThrows(IllegalStateException.class, theList::removeBack);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromFullList() {
        ArrayIntList theList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        theList.removeBack();

        String out = theList.toString();

        assertEquals(out,"[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromList() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);

        theList.removeBack();

        String out = theList.toString();

        assertEquals(out,"[1, 2]");
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