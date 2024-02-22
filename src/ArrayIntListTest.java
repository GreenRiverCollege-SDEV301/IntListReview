import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.addFront(88);
        assertEquals(theList.get(0), 88);
        assertEquals(theList.get(1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBack()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.addBack(22);
        int count = theList.size();
        //check to ensure list is proper size
        assertEquals(count, 3);
        //check to ensure list is in proper order
        assertEquals(theList.get(1), 88);
        assertEquals(theList.get(2), 22);
        theList.removeBack();
        theList.addBack(33);
        assertEquals(theList.get(2), 33);
    }

    @org.junit.jupiter.api.Test
    void add()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 42);
        theList.add(1, 88);
        assertEquals(theList.get(0), 42);
        assertEquals(theList.get(1), 88);
    }

    @org.junit.jupiter.api.Test
    void addWithIndexToListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.add(5, 99);
        assertEquals(theList.get(5), 99);
    }

    @org.junit.jupiter.api.Test
    void addWithIndexToEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> { theList.add(1, 42); });
    }

    @org.junit.jupiter.api.Test
    void addWithIndexToSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.add(0, 88);
        assertEquals(theList.get(0), 88);
    }

    @org.junit.jupiter.api.Test
    void removeFront()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.removeFront();
        assertEquals(theList.size(), 1);
        assertEquals(theList.get(0), 88);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.removeFront();
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrows(IllegalStateException.class, () -> { theList.removeFront(); });
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.removeFront();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10()
    {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");

    }
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {
        ArrayIntList theList = new ArrayIntList();

        assertThrows(IllegalStateException.class, () -> {theList.removeBack();});
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.removeBack();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.remove(1), 88);
        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void removeFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.remove(5), 5);
        assertEquals(theList.size(), 9);
    }

    @org.junit.jupiter.api.Test
    void removeFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> { theList.remove(0); });
    }

    @org.junit.jupiter.api.Test
    void removeFromSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.remove(0), 42);
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.get(1), 88);
    }

    @org.junit.jupiter.api.Test
    void getFromListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.get(5), 5);
    }

    @org.junit.jupiter.api.Test
    void getFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> { theList.get(0); });
    }

    @org.junit.jupiter.api.Test
    void getFromSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void contains()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertTrue(theList.contains(42));
        assertFalse(theList.contains(99));
    }

    @org.junit.jupiter.api.Test
    void containsInListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertTrue(theList.contains(5));
        assertFalse(theList.contains(99));
    }

    @org.junit.jupiter.api.Test
    void containsInEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertFalse(theList.contains(42));
    }

    @org.junit.jupiter.api.Test
    void containsInSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertTrue(theList.contains(42));
    }

    @org.junit.jupiter.api.Test
    void indexOf()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.indexOf(42), 0);
        assertEquals(theList.indexOf(88), 1);
        assertEquals(theList.indexOf(99), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfInListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(5), 5);
        assertEquals(theList.indexOf(99), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfInEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.indexOf(42), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfInSingletonList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.indexOf(42), 0);
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
        theList.addBack(42);
        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyInitially() {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyAfterAddingElements() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.size(), 0);
        theList.addBack(42);
        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void sizeInitially() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeAfterAddingElements() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.size(), 2);
    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.clear();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clearNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        theList.clear();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clearEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void iterator()
    {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        Iterator<Integer> iterator = theList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 42);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 88);
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void iteratorWithElements() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.addBack(88);
        Iterator<Integer> iterator = theList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 42);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 88);
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void iteratorEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        Iterator<Integer> iterator = theList.iterator();
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.toString(), "[]");
        theList.addBack(42);
        theList.addBack(88);
        assertEquals(theList.toString(), "[42, 88]");
    }
}