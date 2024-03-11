import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFrontEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(34);
        assertEquals(list.get(0), 34);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithValues() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addFront(4);
        list.addFront(1000);
        assertEquals(list.get(0), 1000);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithResize() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addFront(4);
        list.addFront(5);
        list.addFront(6);
        list.addFront(7);
        list.addFront(8);
        list.addFront(9);
        list.addFront(10);
        list.addFront(1000);
        assertEquals(list.get(0), 1000);
    }

    //add Back method tests
    @org.junit.jupiter.api.Test
    void addBackWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.get(0), 42);

    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(count - 1), 42);

    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        theList.addBack(6);
        theList.addBack(7);
        theList.addBack(8);
        theList.addBack(9);
        theList.addBack(10);
        theList.addBack(11);
        int size = theList.size() -1;
        assertEquals(theList.get(size), 11);

    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResize() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 1000; i++){
            theList.addBack(i);
        }
        theList.addBack(42);
        int count = theList.size();
        assertEquals(theList.get(count - 1), 42);

    }

    //add method tests
    @org.junit.jupiter.api.Test
    void addWithEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {list.add(2, 500);});
    }

    @org.junit.jupiter.api.Test
    void addWithResize() {
        ArrayIntList list = new ArrayIntList();
        for(int i = 0; i < 11; i++) {
            list.add(i, i);
        }
        list.add(11, 444);

        assertEquals(list.get(list.size() - 1), 444);
    }

    @org.junit.jupiter.api.Test
    void addWithMultipleResize() {
        ArrayIntList list = new ArrayIntList();
        for(int i = 0; i <= 100; i++) {
            list.add(i, i);
        }
        list.add(67, 444);

        assertEquals(list.get(list.size() - 1), 100);
        assertEquals(list.get(67), 444);
    }

    @org.junit.jupiter.api.Test
    void addWithValues() {
        ArrayIntList list = new ArrayIntList();
        list.add(0, 500);
        list.add(1, 500);
        list.add(2, 500);
        list.add(3, 500);
        list.add(2, 7);
        assertEquals(list.get(2), 7);
    }

    @org.junit.jupiter.api.Test
    void removeFrontEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.removeFront();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFrontWithOneValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.removeFront();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFrontWithValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(200);
        theList.addBack(1);
        theList.addBack(1);
        theList.removeFront();
        assertEquals(theList.size(), 3);
        assertEquals(theList.get(0), 200);
    }

    //removeback method test
    @org.junit.jupiter.api.Test
    void removeBackWithTenItems() {
        ArrayIntList theList = new ArrayIntList();

        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        theList.removeBack();

        assertEquals(theList.get(theList.size() - 1), 8);
    }
    @org.junit.jupiter.api.Test
    void removeBackWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IllegalStateException.class, () -> {theList.removeBack();});
    }

    @org.junit.jupiter.api.Test
    void removeBackWithValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(500);
        theList.addBack(1);
        theList.removeBack();
        assertEquals(theList.get(theList.size() - 1), 500);
    }

    @org.junit.jupiter.api.Test
    void removeWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {theList.remove(1);});

    }

    @org.junit.jupiter.api.Test
    void removeWithOneValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.remove(0);
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeWithValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(500);
        theList.addBack(1);
        theList.addBack(1);
        theList.remove(1);
        assertEquals(theList.get(1), 500);
        assertEquals(theList.size(), 4);
    }

    @org.junit.jupiter.api.Test
    void getWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {theList.get(0);});
    }

    @org.junit.jupiter.api.Test
    void getWithOneValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(theList.get(0), 1);
    }

    @org.junit.jupiter.api.Test
    void getWithMultipleValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(5);
        theList.addBack(34);
        theList.addBack(23);
        theList.addBack(500);
        assertEquals(theList.get(4), 500);
    }

    @org.junit.jupiter.api.Test
    void containsWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.contains(23), false);
    }
    @org.junit.jupiter.api.Test
    void containsWithOneValueReturnTrue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(theList.contains(1), true);
    }

    @org.junit.jupiter.api.Test
    void containsWithOneValueReturnFalse() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(23);
        assertEquals(theList.contains(1), false);
    }
    @org.junit.jupiter.api.Test
    void containsWithMultipleValuesReturnTrue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(34);
        theList.addBack(1456);
        theList.addBack(-56);
        theList.addBack(-34);
        assertEquals(theList.contains(-34), true);
    }

    @org.junit.jupiter.api.Test
    void containsWithMultipleValuesReturnFalse() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(34);
        theList.addBack(1456);
        theList.addBack(-56);
        theList.addBack(-34);
        assertEquals(theList.contains(50000000), false);
    }

    @org.junit.jupiter.api.Test
    void indexOfEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.indexOf(5), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfWithOneValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(theList.indexOf(1), 0);
    }

    @org.junit.jupiter.api.Test
    void indexOfWithMultipleValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(1);
    }

    @org.junit.jupiter.api.Test
    void isEmptyYes() {
        ArrayIntList theList = new ArrayIntList();
        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyNo() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void sizeWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeWithOneValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void sizeWithMultipleValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(1);
        assertEquals(theList.size(), 3);
    }

    @org.junit.jupiter.api.Test
    void clearWithEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clearWithOneValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clearWithMultipleValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(1);
        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayIntList theList = new ArrayIntList();
    }

    @org.junit.jupiter.api.Test
    void getInitialCapacity() {
        ArrayIntList theList = new ArrayIntList();
    }

    @org.junit.jupiter.api.Test
    void testToStringMultipleValues() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(1);
        theList.addBack(1);
        assertEquals("[1, 1, 1]", theList.toString());
    }

    @org.junit.jupiter.api.Test
    void testToStringEmpty() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals("[]", theList.toString());
    }

    @org.junit.jupiter.api.Test
    void testToStringOneValue() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals("[1]", theList.toString());
    }
}