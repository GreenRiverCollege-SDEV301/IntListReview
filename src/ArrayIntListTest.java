import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();
        testList.addFront(0);

        String out = testList.toString();

        assertEquals("[0]", out);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithNonemptyList() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++){
            testList.addBack(i);
        }

        testList.addFront(5);

        String out = testList.toString();

        assertEquals("[5, 0, 1, 2, 3, 4]", out);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithResize() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++){
            testList.addBack(i);
        }

        testList.addFront(10);

        String out = testList.toString();

        assertEquals("[10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", out);
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();
        testList.addBack(42);

        assertEquals(42, testList.get(0));
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
        assertEquals(11, testList.size());
    }

    // add()
    @org.junit.jupiter.api.Test
    void addAtLastIndex() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        testList.add(4, 9999);

        String out = testList.toString();
        assertEquals(out, "[0, 1, 2, 3, 9999, 4]");

    }

    @org.junit.jupiter.api.Test
    void addAtIndex0() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        testList.add(0, 9999);

        String out = testList.toString();
        assertEquals(out, "[9999, 0, 1, 2, 3, 4]");
    }

    @org.junit.jupiter.api.Test
    void addAtSize() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        testList.add(5, 9999);

        String out = testList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 9999]");
    }

    @org.junit.jupiter.api.Test
    void addOutOfBounds() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertThrowsExactly(IndexOutOfBoundsException.class, () -> testList.add(6, 9999));
    }

    // removeFront()
    @org.junit.jupiter.api.Test
    void removeFrontOfEmptyList() {
        ArrayIntList testList = new ArrayIntList();
        assertThrowsExactly(IllegalStateException.class, testList::removeFront, "The list is already empty");
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListOf1() {
        ArrayIntList testList = new ArrayIntList();
        testList.addBack(1);
        testList.removeFront();

        assertEquals(0, testList.size());
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListOf5() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        testList.removeFront();

        assertEquals(4, testList.size());
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListOf10() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.removeFront();

        assertEquals(9, testList.size());
    }

    // removeBack()
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

        assertEquals(0, testList.size());
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.removeBack();

        String out = testList.toString();
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8]", out);
    }

    // remove()
    @org.junit.jupiter.api.Test
    void removeFirst() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.remove(0);

        String out = testList.toString();
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", out);
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.remove(9);

        String out = testList.toString();
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8]", out);
    }

    @org.junit.jupiter.api.Test
    void removeMiddle() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.remove(5);

        String out = testList.toString();
        assertEquals("[0, 1, 2, 3, 4, 6, 7, 8, 9]", out);
    }

    @org.junit.jupiter.api.Test
    void removeOutOfBounds() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertThrowsExactly(IndexOutOfBoundsException.class, () -> testList.remove(-1), "Index is too small or too large");
    }

    @org.junit.jupiter.api.Test
    void removeFromEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        assertThrowsExactly(IndexOutOfBoundsException.class, () -> testList.remove(0), "Index is too small or too large");
    }

    // get()
    @org.junit.jupiter.api.Test
    void getAbsentValue() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertThrowsExactly(IndexOutOfBoundsException.class, () -> testList.get(10));
    }

    @org.junit.jupiter.api.Test
    void getFromEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        assertThrowsExactly(IndexOutOfBoundsException.class, () -> testList.get(0));
    }

    @org.junit.jupiter.api.Test
    void getFromMiddle() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertEquals(3, testList.get(3));
    }

    @org.junit.jupiter.api.Test
    void getFromFront() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertEquals(0, testList.get(0));
    }

    @org.junit.jupiter.api.Test
    void getFromBack() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertEquals(4, testList.get(4));
    }

    // contains()
    @org.junit.jupiter.api.Test
    void containsAbsentValue() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertFalse(testList.contains(10));
    }

    @org.junit.jupiter.api.Test
    void containsWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        assertFalse(testList.contains(0));
    }

    @org.junit.jupiter.api.Test
    void containsPresentValue() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertTrue(testList.contains(3));
    }

    @org.junit.jupiter.api.Test
    void containsPresentValueAtFront() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertTrue(testList.contains(0));
    }

    @org.junit.jupiter.api.Test
    void containsPresentValueAtBack() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertTrue(testList.contains(4));
    }

    // indexOf()
    @org.junit.jupiter.api.Test
    void indexOfAbsentValue() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertEquals(-1, testList.indexOf(10));
    }

    @org.junit.jupiter.api.Test
    void indexOfWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        assertEquals(-1, testList.indexOf(0));
    }

    @org.junit.jupiter.api.Test
    void indexOfValueAtFront() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i + 1);
        }

        assertEquals(0, testList.indexOf(1));
    }

    @org.junit.jupiter.api.Test
    void indexOfValueAtBack() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i + 1);
        }

        assertEquals(4, testList.indexOf(5));
    }

    @org.junit.jupiter.api.Test
    void indexOfValueAtMiddle() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i + 1);
        }

        assertEquals(2, testList.indexOf(3));
    }

    // isEmpty()
    @org.junit.jupiter.api.Test
    void isEmptyWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();
        assertTrue(testList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyWithListOf10() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        assertFalse(testList.isEmpty());
    }

    // size()
    @org.junit.jupiter.api.Test
    void sizeOfEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        assertEquals(testList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeOfNonemptyList() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++) {
            testList.addBack(i);
        }

        assertEquals(5, testList.size());
    }

    @org.junit.jupiter.api.Test
    void sizeWithResize() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 15; i++) {
            testList.addBack(i);
        }

        assertEquals(15, testList.size());
    }

    // clear()
    @org.junit.jupiter.api.Test
    void clearEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        testList.clear();

        assertEquals("[]", testList.toString());
    }

    @org.junit.jupiter.api.Test
    void clearNonEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 10; i++) {
            testList.addBack(i);
        }

        testList.clear();

        assertEquals("[]", testList.toString());
    }

    @org.junit.jupiter.api.Test
    void clearResizedList() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 15; i++) {
            testList.addBack(i);
        }

        testList.clear();

        assertEquals("[]", testList.toString());
    }


    // iterator()
    @org.junit.jupiter.api.Test
    void iteratorHasNextWhenEmpty() {
        ArrayIntList testList = new ArrayIntList();

        Iterator<Integer> itr = testList.iterator();

        assertFalse(itr.hasNext());
    }

    @org.junit.jupiter.api.Test
    void iteratorNextWhenEmpty() {
        ArrayIntList testList = new ArrayIntList();

        Iterator<Integer> itr = testList.iterator();

        assertThrowsExactly(NoSuchElementException.class, itr::next, "No more elements");
    }

    // toString()
    @org.junit.jupiter.api.Test
    void toStringWithEmptyList() {
        ArrayIntList testList = new ArrayIntList();

        String out = testList.toString();

        assertEquals("[]", out);
    }

    @org.junit.jupiter.api.Test
    void toStringWithListOf5() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 5; i++){
            testList.addBack(i);
        }

        String out = testList.toString();

        assertEquals("[0, 1, 2, 3, 4]", out);
    }

    @org.junit.jupiter.api.Test
    void toStringAfterResize() {
        ArrayIntList testList = new ArrayIntList();

        for(int i = 0; i < 15; i++){
            testList.addBack(i);
        }

        String out = testList.toString();

        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", out);
    }
}