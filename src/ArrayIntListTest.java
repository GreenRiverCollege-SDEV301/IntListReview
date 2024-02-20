import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList() {

    }

    @org.junit.jupiter.api.Test
    void addFrontWithNonemptyList() {

    }

    @org.junit.jupiter.api.Test
    void addFrontWithResize() {

    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();
        testList.addBack(42);

        assertEquals(testList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithNonemptyList() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        String out = testList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList testList = new ArrayIntList();
        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.addBack(10);
        assertEquals(testList.size(), 11);
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBackOfEmptyList() {
        ArrayIntList testList = new ArrayIntList();
        assertThrowsExactly(IllegalStateException.class, testList::removeBack, "The list is already empty");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf1() {
        ArrayIntList testList = new ArrayIntList();
        testList.addBack(1);
        testList.removeBack();

        assertEquals(testList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.removeBack();

        String out = testList.toString();
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
    void sizeOfEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        assertEquals(testList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeOfNonemptyList() {
        ArrayIntList testList = new ArrayIntList();


        assertEquals(testList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeWithResize() {
        ArrayIntList testList = new ArrayIntList();

        assertEquals(testList.size(), 0);
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