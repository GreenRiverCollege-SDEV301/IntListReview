import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    /** Start of addFront tests */

    @org.junit.jupiter.api.Test
    void addFrontWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void addFrontWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.addFront(42);
        String out = theList.toString();
        assertEquals(out, "[42, 1]");
    }

    @org.junit.jupiter.api.Test
    void addFrontFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY of 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    /** End of addFront tests */

    /** Start of addBack tests */

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        //assertEquals(theList.get(0), 42);
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
        //assertEquals((theList.size() - 1), 42);
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY of 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        // now add item 11:
        theList.addBack(42);

        assertEquals(theList.get(theList.size() - 1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY of 10 items
        for (int i = 0; i < 1000000; i++) {
            theList.addBack(i);
        }

        // now add item 11:
        theList.addBack(42);

        assertEquals(theList.get(theList.size() - 1), 42);
    }

    /** End of addBack tests */

    /** Start of add tests */

    @org.junit.jupiter.api.Test
    void addWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 42);
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void addWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 1);
        theList.add(0, 42);
        String out = theList.toString();
        assertEquals(out, "[42, 1]");
    }

    @org.junit.jupiter.api.Test
    void addFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY of 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.add(5, 42);
        assertEquals(theList.get(5), 42);
    }

    /** End of add tests */

    /** Start of removeFront tests */

    @org.junit.jupiter.api.Test
    void removeFrontWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.removeFront();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFrontWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.removeFront();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPACITY of 10 items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.removeFront();
        assertEquals(theList.get(0), 1);
    }

    /** End of removeFront tests */

    /** Start of removeBack tests */

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        // create an empty list
        ArrayIntList theList  = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class, theList::removeBack);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        // create list
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        // remove the item in the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }

    /** End of removeBack tests */


    /** Start of remove tests */

    @org.junit.jupiter.api.Test
    void removeWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> theList.remove(0));
    }

    @org.junit.jupiter.api.Test
    void removeWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.remove(0);
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.remove(4);

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 5, 6, 7, 8, 9]");
    }

    /** End of remove tests */

    /** Start of get tests */

    @org.junit.jupiter.api.Test
    void getWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> theList.get(0));
    }

    @org.junit.jupiter.api.Test
    void getWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void getFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.get(5), 5);
    }

    /** End of get tests */


    /** Start of contains tests */

    @org.junit.jupiter.api.Test
    void containsWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertFalse(theList.contains(42));
    }

    @org.junit.jupiter.api.Test
    void containsWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertTrue(theList.contains(42));
    }

    @org.junit.jupiter.api.Test
    void containsFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        assertTrue(theList.contains(5));
    }

    /** End of contains tests */

    /** Start of indexOf tests */

    @org.junit.jupiter.api.Test
    void indexOfWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.indexOf(42), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.indexOf(42), 0);
    }

    @org.junit.jupiter.api.Test
    void indexOfFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        assertEquals(theList.indexOf(5), 5);
    }

    /** End of indexOf tests */

    /** Start of isEmpty tests */

    @org.junit.jupiter.api.Test
    void isEmptyWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        assertFalse(theList.isEmpty());
    }

    /** End of isEmpty tests */

    /** Start of size tests */

    @org.junit.jupiter.api.Test
    void sizeWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void sizeFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        assertEquals(theList.size(), 10);
    }

    /** End of size tests */

    /** Start of clear tests */

    @org.junit.jupiter.api.Test
    void clearWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void clearWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.clear();
        String out = theList.toString();
        assertEquals(out, "[]");

    }

    @org.junit.jupiter.api.Test
    void clearFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        theList.clear();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    /** End of clear tests */

    /** Start of iterator tests */

    @org.junit.jupiter.api.Test
    void iteratorWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        Iterator<Integer> iterator = theList.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @org.junit.jupiter.api.Test
    void iteratorWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(5);
        Iterator<Integer> iterator = theList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @org.junit.jupiter.api.Test
    void iteratorFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        Iterator<Integer> iterator = theList.iterator();
        for (int i = 0; i < 10; i++) {
            assertTrue(iterator.hasNext());
            assertEquals(i, iterator.next());
        }
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    /** End of iterator tests */

    /** Start of toString tests */

    @org.junit.jupiter.api.Test
    void testToStringWhenEmpty() {
        ArrayIntList theList = new ArrayIntList();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void testToStringWhenSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void testToStringFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        // fill with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    /** End of toString tests */
}