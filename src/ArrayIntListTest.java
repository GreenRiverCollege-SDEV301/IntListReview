import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    /*Add Front*/
    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(42);
        assertEquals("[42]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addFront_MultipleElements() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(10);
        list.addFront(20);
        assertEquals("[20, 10]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addFront_ResizeRequired() {
        ArrayIntList list = new ArrayIntList();
        for (int i = 0; i < 12; i++) { // Assuming initial capacity is 10
            list.addFront(i);
        }
        assertEquals(12, list.size());
        assertEquals("[11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", list.toString());
    }
    /*Add Back*/
    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        String out = theList.toString();
        assertEquals(out,"[42]");
    }
    @org.junit.jupiter.api.Test
    void addBackNoneEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1),42);
    }
    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i<10; i++){
            theList.addBack(i);
        }
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1),42);
    }

    /*Add*/
    @org.junit.jupiter.api.Test
    void addAtIndex_Beginning() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.add(0, 0); // Adding at the beginning
        assertEquals("[0, 1, 2]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void addAtIndex_Middle() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(3);
        list.add(1, 2); // Adding in the middle
        assertEquals("[1, 2, 3]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void addAtIndex_End() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.add(2, 3); // Adding at the end
        assertEquals("[1, 2, 3]", list.toString());
    }

    /*Remove Front*/
    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.removeFront();
        assertEquals("[2, 3]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void removeFront_SingleElement() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(42);
        list.removeFront();
        assertTrue(list.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeFront_EmptyList() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, list::removeFront);
    }

    /*Remove Back*/
    @org.junit.jupiter.api.Test
    void removeBackFromSingleElementList() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(42);
        list.removeBack();
        assertTrue(list.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeBackFromNonEmptyList() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.removeBack();
        assertEquals("[1, 2]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IllegalStateException.class, list::removeBack);
    }

    /*Remove*/
    @org.junit.jupiter.api.Test
    void remove() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.remove(1);
        assertEquals("[1, 3]", list.toString());

    }
    @org.junit.jupiter.api.Test
    void remove_FirstElement() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.remove(0);
        assertEquals("[2, 3]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void remove_LastElement() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.remove(2); // Removing the last element
        assertEquals("[1, 2]", list.toString());
    }

    /*Get*/
    @org.junit.jupiter.api.Test
    void get() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals(2, list.get(1));
    }
    @org.junit.jupiter.api.Test
    void get_FirstElement() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(42);
        assertEquals(42, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void get_OutOfBounds() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(42);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1)); // Out of bounds
    }

    /*Contains*/
    @org.junit.jupiter.api.Test
    void contains() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));

    }

    /*Index Of*/
    @org.junit.jupiter.api.Test
    void indexOf() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    /*Is Empty*/
    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayIntList emptyList = new ArrayIntList();
        ArrayIntList nonEmptyList = new ArrayIntList();
        nonEmptyList.addBack(1);
        assertFalse(nonEmptyList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    /*Size*/
    @org.junit.jupiter.api.Test
    void size() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals(3, list.size());
    }

    /*Clear*/
    @org.junit.jupiter.api.Test
    void clear() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    /*iterator*/
    @org.junit.jupiter.api.Test
    void iteratorHasNextAndNext() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
    }

    @org.junit.jupiter.api.Test
    void iteratorThrowsNoSuchElementException() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        Iterator<Integer> it = list.iterator();
        it.next(); // Advance to the end
        assertThrows(NoSuchElementException.class, it::next); // Should throw when there are no more elements
    }


    /*toString*/
    @org.junit.jupiter.api.Test
    void toString_EmptyList() {
        ArrayIntList list = new ArrayIntList();
        assertEquals("[]", list.toString(), "The string representation of an empty list should be []");
    }
    @org.junit.jupiter.api.Test
    void toString_SingleElementList() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(42); // Add a single element
        assertEquals("[42]", list.toString(), "The string representation of a list with one element should enclose the element in brackets");
    }
    @org.junit.jupiter.api.Test
    void toString_MultipleElementsList() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3); // Add multiple elements
        assertEquals("[1, 2, 3]", list.toString(), "The string representation of a list with multiple elements should be enclosed in brackets and comma-separated");
    }

}