import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @org.junit.jupiter.api.Test
    void addFront() {
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        Array theList = new Array();
        theList.addBack(42);
        assertEquals(theList.get(0), 42);

    }
    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        Array theList = new Array();
        theList.addBack(1);
        theList.addBack(42);
        assertEquals(theList.get(0), 42);

    }
    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        Array theList = new Array();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);


        }
    theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        Array theList = new Array();
        assertThrowsExactly(IllegalStateException.class,
                theList::removeBack);
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