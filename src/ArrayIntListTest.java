import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class ArrayIntListTest {

    @Test
     void addFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);

        int count = theList.size();
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addMultipleFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.addFront(2);
        theList.addFront(3);
        theList.addFront(42);

        int count = theList.size();
        assertEquals(theList.get(0), 42);
    }
    @org.junit.jupiter.api.Test
    void addResizedFront() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i<1000; i++) {
            theList.addFront(i);
        }
        theList.addFront(42);

        int count = theList.size();
        assertEquals(theList.get(0), 42);
    }


@org.junit.jupiter.api.Test
    void addBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);

        int count = theList.size();
        assertEquals(theList.get(0), 42);

    }

    @org.junit.jupiter.api.Test
    void addMultipleBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);

        int count = theList.size();
        assertEquals(theList.get(theList.size()-1), 42);

    }

    @org.junit.jupiter.api.Test
    void addResizedBack() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i<1000; i++) {
            theList.addBack(i);
        }
        theList.addBack(42);

        int count = theList.size();
        assertEquals(theList.get(theList.size()-1), 42);

    }





    @Test
    void addSingle() {

        ArrayIntList theList = new ArrayIntList();
        theList.addBack(5);
        theList.addBack(4);
        theList.addBack(12);
        theList.add(2,5);
        assertEquals(theList.get(2), 5);

    }

    @Test
    void addmultiple() {

        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i<1000; i++){
            theList.add(i,i);
        }
        theList.add(1000,69);
        assertEquals(theList.get(1000), 69);

    }

    @Test
    void removeSingleFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(22);

        theList.removeFront();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @Test
    void removeMultipleFront() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 15; i++) {
            theList.addBack(i);
        }

        for(int i = 0; i < 5; i++) {
            theList.removeFront(); // Remove 5 elements from the front
        }

        assertEquals(10, theList.size());
        assertEquals(5, theList.get(0));
    }

    @Test
    void removeEmptyBack() {

        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalArgumentException.class, () -> {theList.removeBack();});
    }
    @Test
    void removeSingleBack() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(1);
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[]");
    }
    @Test
    void removeMultipleBack() {
        ArrayIntList theList = new ArrayIntList();

        for(int i=0; i<20; i++) {
            theList.addBack(i);
        }
        theList.removeBack();

        assertEquals(theList.get(theList.size() - 1), 18);
    }

    @Test
    void removesValid() {
    ArrayIntList theList = new ArrayIntList();

        theList.addBack(10);
        theList.addBack(3);
        theList.addBack(5);

       int removedValue = theList.remove(1);

        assertEquals(3, removedValue);
        assertEquals(2, theList.size());
        assertEquals(10, theList.get(0));
        assertEquals(5, theList.get(1));
    }

    @Test
    void removesThrows() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(10);
        theList.addBack(3);
        theList.addBack(5);



        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {theList.remove(3);});

    }

    @Test
    void removeslastElement() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(10);
        theList.addBack(3);
        theList.addBack(5);

        int removedValue = theList.remove(2);

        assertEquals(5, removedValue);
        assertEquals(2, theList.size());
        assertEquals(10, theList.get(0));
        assertEquals(3, theList.get(1));
    }

    @Test
    void getValidOutput() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);


        int value = theList.get(1);


        assertEquals(2, value);

    }
    @Test
    void getThrows() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);


        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {theList.get(3);});

    }
    @Test
    void getFirstElement() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);


        int value = theList.get(0);


        assertEquals(1,value);

    }

    @Test
    void containsValues() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};

        for (int value : testData) {
            theList.addBack(value);
        }
        assertTrue(theList.contains(30));
    }

    void containsNoValues() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        assertFalse(theList.contains(100));
    }

    @Test
    void indexOfMiddle() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        assertEquals(2, theList.indexOf(30));
    }

    @Test
    void indexOfNotFound() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        assertEquals(-1, theList.indexOf(100));
    }

    @Test
    void indexOfEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(-1, theList.indexOf(100));
    }

    @Test
    void isEmptyafterClearing() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        theList.clear();
        assertTrue(theList.isEmpty());
    }

    @Test
    void isEmptyofisEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
    }

    @Test
    void isEmptyNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertFalse(theList.isEmpty());
    }

    @Test
    void sizenonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        assertEquals(testData.length, theList.size());
    }

    @Test
    void sizeemptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(0, theList.size());
    }

    @Test
    void sizeAfterRemovingElements() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        theList.remove(2); // Remove an element
        assertEquals(testData.length - 1, theList.size());
    }

    @Test
    void clearlistIsEmpty() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        theList.clear();
        assertTrue(theList.isEmpty());
    }

    @Test
    void clearlistSizeIsZero() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        theList.clear();
        assertEquals(0, theList.size());
    }

    @Test
    void clearremovedElements() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        theList.clear();
        for (int value : testData) {
            assertFalse(theList.contains(value));
        }
    }

    @Test
    void iteratorcorrectIteration() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        Iterator<Integer> iterator = theList.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals(testData[index], iterator.next());
            index++;
        }
    }

    @Test
    void iteratorHasNextAfterIteration() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};

        for (int value : testData) {
            theList.addBack(value);
        }
        Iterator<Integer> iterator = theList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorException() {
        ArrayIntList theList = new ArrayIntList();
        int[] testData = {10, 20, 30, 40, 50};
        for (int value : testData) {
            theList.addBack(value);
        }
        Iterator<Integer> iterator = theList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}