import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedIntListTest {
    @Test
    void addFrontEmpty() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        assertEquals("[1]", list.toString());
    }

    @Test
    void addFrontSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(2);
        list.addFront(1);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void addFrontMultiple() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void addBackEmpty() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        assertEquals("[1]", list.toString());
    }

    @Test
    void addBackSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void addBackMultiple() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void addEmpty() {
        LinkedIntList list = new LinkedIntList();
        list.add(0, 1);
        assertEquals("[1]", list.toString());
    }

    @Test
    void addEmptySingleBack() {
        LinkedIntList list = new LinkedIntList();
        list.add(0, 0);
        list.add(1, 1);
        assertEquals("[0, 1]", list.toString());
    }

    @Test
    void addEmptySingleFront() {
        LinkedIntList list = new LinkedIntList();
        list.add(0, 1);
        list.add(0, 0);
        assertEquals("[0, 1]", list.toString());
    }

    @Test
    void addEmptyMultipleFront() {
        LinkedIntList list = new LinkedIntList();
        list.add(0, 3);
        list.add(0, 2);
        list.add(0, 1);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void addEmptyMultipleBack() {
        LinkedIntList list = new LinkedIntList();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 3);
        list.add(2, 2);
        assertEquals("[0, 1, 2, 3]", list.toString());

    }

    @Test
    void removeFrontEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertThrows(NullPointerException.class,
                () -> list.removeFront());
    }

    @Test
    void removeFrontSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        list.removeFront();
        assertEquals(0, list.size());
    }

    @Test
    void removeFrontMultiple() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);

        list.removeFront();
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    void removeBackEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertThrows(NullPointerException.class,
                () -> list.removeBack());
    }

    @Test
    void removeBackSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.removeBack();
        assertEquals(0, list.size());
    }

    @Test
    void removeBackMultiple() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.removeBack();
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void removeEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void removeSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        int result = list.remove(0);
        assertEquals("[]", list.toString());
        assertEquals(1, result);
    }

    @Test
    void removeMultiple() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        int result = list.remove(2);
        assertEquals("[1, 2]", list.toString());
        assertEquals(3, result);
    }

    @Test
    void removeMultipleMiddle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        int result = list.remove(1);
        assertEquals("[1, 3]", list.toString());
        assertEquals(2, result);
    }
    @Test
    void getEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void getSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        int result = list.get(0);
        assertEquals(1, result);
    }

    @Test
    void getMultipleEnd() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        int result = list.get(2);
        assertEquals(3, result);
    }

    @Test
    void getMultipleMiddle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        int result = list.get(1);
        assertEquals(2, result);
    }

    @Test
    void containsEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertFalse(list.contains(0));
    }

    @Test
    void containsSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        assertTrue(list.contains(1));
    }

    @Test
    void containsMultipleMiddle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertTrue(list.contains(2));
    }

    @Test
    void containsMultipleEnd() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertTrue(list.contains(3));
    }

    @Test
    void indexOfEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertEquals(-1, list.indexOf(0));
    }

    @Test
    void indexOfSingle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        assertEquals(0, list.indexOf(1));
    }

    @Test
    void indexOfMultipleMiddle() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    void indexOfMultipleEnd() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals(2, list.indexOf(3));
    }

    @Test
    void isEmptyTrue() {
        LinkedIntList list = new LinkedIntList();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void sizeEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertEquals(0, list.size());
    }

    @Test
    void sizeNotEmpty() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        assertEquals(1, list.size());
    }

    @Test
    void clear() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void iteratorSingle() {
        LinkedIntList list = new LinkedIntList();
        Iterator itr = list.iterator();
        list.addBack(1);
        assertTrue(itr.hasNext());
        assertEquals(1, itr.next());
    }

    @Test
    void iteratorMultiple() {
        LinkedIntList list = new LinkedIntList();
        Iterator itr = list.iterator();
        list.addBack(1);
        list.addBack(2);

        assertTrue(itr.hasNext());
        assertEquals(1, itr.next());
    }

    @Test
    void testToStringEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertEquals("[]", list.toString());
    }

    @Test
    void testToStringPopulated() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);
        assertEquals("[1]", list.toString());
    }
}