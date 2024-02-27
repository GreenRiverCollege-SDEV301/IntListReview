import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    @Test
    void addFrontWithEmptyList() {
        IntList testList = new LinkedIntList();
        testList.addFront(2);

        String out = testList.toString();
        assertEquals(out, "[2]");
    }
    @Test
    void addFrontWithNonEmptyList() {
        IntList testList = new LinkedIntList();
        testList.addFront(1);
        testList.addFront(2);
        testList.addFront(3);
        testList.addFront(4);

        String out = testList.toString();
        assertEquals(out, "[4, 3, 2, 1]");
    }

    @Test
    void addBackWithEmptyList() {
        IntList testList = new LinkedIntList();
        testList.addBack(2);

        String out = testList.toString();
        assertEquals(out, "[2]");
    }
    @Test
    void addBackWithNonEmptyList() {
        IntList testList = new LinkedIntList();
        testList.addBack(1);
        testList.addBack(2);
        testList.addBack(3);
        testList.addBack(4);

        String out = testList.toString();
        assertEquals(out, "[1, 2, 3, 4]");
    }

    @Test
    void add() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }

    @Test
    void testToString() {
    }
}