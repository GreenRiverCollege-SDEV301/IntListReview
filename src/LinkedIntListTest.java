import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    /*Add Front*/
    @org.junit.jupiter.api.Test
    void addFront_SingleElement() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(10);
        assertEquals("[10]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addFront_MultipleElements() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(10);
        list.addFront(20);
        assertEquals("[20, 10]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addFront_EnsureSizeUpdatesCorrectly() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(10);
        list.addFront(20);
        assertEquals(2, list.size());
    }

    /*Add Back*/
    @org.junit.jupiter.api.Test
    void addBack_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertEquals("[10]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addBack_NonEmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        assertEquals("[10, 20]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addBack_EnsureSizeUpdatesCorrectly() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        assertEquals(2, list.size());
    }

    /*Add*/
    @org.junit.jupiter.api.Test
    void addAtIndex_Start() {
        LinkedIntList list = new LinkedIntList();
        list.add(0, 10); // Adding at the start
        assertEquals("[10]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addAtIndex_Middle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(30);
        list.add(1, 20); // Adding in the middle
        assertEquals("[10, 20, 30]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void addAtIndex_End() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.add(2, 30); // Adding at the end
        assertEquals("[10, 20, 30]", list.toString());
    }

    /*Remove Front*/
    @org.junit.jupiter.api.Test
    void removeFront_NonEmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.removeFront();
        assertEquals("[20]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void removeFront_SingleElementList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.removeFront();
        assertTrue(list.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeFront_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.removeFront(); // Should not throw an exception
        assertTrue(list.isEmpty());
    }

    /*Remove Back*/
    @org.junit.jupiter.api.Test
    void removeBack_NonEmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.removeBack();
        assertEquals("[10]", list.toString());
    }
    @org.junit.jupiter.api.Test
    void removeBack_SingleElementList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.removeBack();
        assertTrue(list.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void removeBack_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.removeBack(); // Should not throw an exception
        assertTrue(list.isEmpty());
    }

    /*Remove*/
    @org.junit.jupiter.api.Test
    void removeAtIndex_Start() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        assertEquals(10, list.remove(0));
        assertEquals("[20]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void removeAtIndex_Middle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        assertEquals(20, list.remove(1));
        assertEquals("[10, 30]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void removeAtIndex_End() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        assertEquals(20, list.remove(1));
        assertEquals("[10]", list.toString());
    }

    /*Get*/
    @org.junit.jupiter.api.Test
    void get_FirstElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertEquals(10, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void get_MiddleElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        assertEquals(20, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void get_LastElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        assertEquals(30, list.get(2));
    }

    /*Contains*/
    @org.junit.jupiter.api.Test
    void contains_ExistingElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertTrue(list.contains(10));
    }

    @org.junit.jupiter.api.Test
    void contains_NonExistingElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertFalse(list.contains(20));
    }

    @org.junit.jupiter.api.Test
    void contains_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        assertFalse(list.contains(10));
    }

    /*IndexOf*/
    @org.junit.jupiter.api.Test
    void indexOf_ExistingElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        assertEquals(1, list.indexOf(20));
    }

    @org.junit.jupiter.api.Test
    void indexOf_NonExistingElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertEquals(-1, list.indexOf(30));
    }

    @org.junit.jupiter.api.Test
    void indexOf_MultipleOccurrences() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(10);
        assertEquals(0, list.indexOf(10)); // Should return the index of the first occurrence
    }

    /*isEmpty*/
    @org.junit.jupiter.api.Test
    void isEmpty_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmpty_NonEmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertFalse(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmpty_AfterClear() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.clear();
        assertTrue(list.isEmpty());
    }

    /*Size*/
    @org.junit.jupiter.api.Test
    void size_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void size_NonEmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        assertEquals(2, list.size());
    }

    @org.junit.jupiter.api.Test
    void size_AfterRemoval() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.removeBack();
        assertEquals(1, list.size());
    }

    /*Clear*/
    @org.junit.jupiter.api.Test
    void clear_NonEmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.clear();
        assertTrue(list.isEmpty() && list.size() == 0);
    }

    @org.junit.jupiter.api.Test
    void clear_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        list.clear(); // Should not throw an exception
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear_MultipleClears() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.clear();
        list.clear(); // Ensure clear can be called multiple times without issue
        assertTrue(list.isEmpty());
    }

    /*Iterator*/
    @org.junit.jupiter.api.Test
    void iterator_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext(), "Iterator should not have next on an empty list");
        assertThrows(NoSuchElementException.class, iterator::next, "Iterator should throw NoSuchElementException on next() call when list is empty");
    }
    @org.junit.jupiter.api.Test
    void iterator_SingleItemList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10); // Adding a single element
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next on a list with one item");
        assertEquals(10, iterator.next(), "Iterator next should return the single item in the list");
        assertFalse(iterator.hasNext(), "Iterator should not have next after iterating over single item");
    }
    @org.junit.jupiter.api.Test
    void iterator_MultipleItemsList() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(30); // Adding multiple elements
        Iterator<Integer> iterator = list.iterator();

        assertTrue(iterator.hasNext(), "Iterator should have next at the start");
        assertEquals(10, iterator.next(), "First call to iterator next should return the first item");

        assertTrue(iterator.hasNext(), "Iterator should have next after first item");
        assertEquals(20, iterator.next(), "Second call to iterator next should return the second item");

        assertTrue(iterator.hasNext(), "Iterator should have next after second item");
        assertEquals(30, iterator.next(), "Third call to iterator next should return the third item");

        assertFalse(iterator.hasNext(), "Iterator should not have next after last item");
    }

    /*toString*/
    @org.junit.jupiter.api.Test
    void toString_EmptyList() {
        LinkedIntList list = new LinkedIntList();
        assertEquals("[]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void toString_SingleElement() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        assertEquals("[10]", list.toString());
    }

    @org.junit.jupiter.api.Test
    void toString_MultipleElements() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        assertEquals("[10, 20, 30]", list.toString());
    }

}