import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    //Helper methods (creating lists for tests)

    //Create an empty list
    public ArrayIntList getEmptyList() {
        return new ArrayIntList();
    }

    //Create a list with 1 value
    public ArrayIntList getListWithOneValue() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        return list;
    }

    //Create a list with 4 values
    public ArrayIntList getListWithFourValues() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.addBack(42);
        return list;
    }

    //Create a list with 10 values
    public ArrayIntList getListWithTenValues() {
        ArrayIntList list = new ArrayIntList();
        //Fill the list with INITIAL_CAPACITY or 10 items
        for (int i = 0; i < 10; i++) {
            list.addBack(i);
        }
        return list;
    }

    //Test addFront()
    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList() {
        ArrayIntList list = getEmptyList();
        list.addFront(42);
        assertEquals(list.get(0), 42);
        assertEquals(list.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithNonEmptyList() {
        ArrayIntList list = getListWithFourValues();
        assertEquals(list.get(list.size() - 1), 42);
        String out = list.toString();
        assertEquals(out, "[1, 2, 3, 42]");
    }

    @org.junit.jupiter.api.Test
    void addFrontWithResize() {
        ArrayIntList list = getListWithTenValues();
        list.addFront(42);
        assertEquals(list.get(0), 42);
    }

    //Test addBack()
    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = getEmptyList();
        theList.addBack(42);
        int count = theList.size();
        assertEquals(count, 1);
        assertEquals(theList.get(0), 42);
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = getListWithFourValues();
        assertEquals(theList.get(theList.size() - 1), 42);
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = getListWithTenValues();
        //Now add item 11:
        theList.addBack(42);
        assertEquals(theList.get(theList.size() - 1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();

        for (int i = 0; i < 1000000; i++) {
            theList.addBack(i);
        }
        //Now add item 11:
        theList.addBack(42);
        assertEquals(theList.get(theList.size() - 1), 42);
    }

    //Test add()
    @org.junit.jupiter.api.Test
    void addWithEmptyList() {
        ArrayIntList list = getEmptyList();
        list.add(0, 0);
        assertEquals(list.get(0), 0);
    }

    @org.junit.jupiter.api.Test
    void addWithNonEmptyList() {
        ArrayIntList list = getListWithFourValues();
        list.add(1, 3);
        assertEquals(list.get(1), 3);
    }

    @org.junit.jupiter.api.Test
    void addWithResize() {
        ArrayIntList list = getListWithTenValues();
        list.add(11, 4);
        assertEquals(list.get(11), 4);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList() {
        ArrayIntList list = getEmptyList();
        assertThrows(IllegalStateException.class, list::removeFront);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromNonEmptyList() {
        ArrayIntList list = getListWithFourValues();
        list.removeFront();
        assertEquals(list.get(0), 2);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        //Create an empty list
        ArrayIntList theList = new ArrayIntList();

        //You can trigger multiple things here to get an exception
//        assertThrowsExactly(IllegalStateException.class, () -> {
//            theList.removeBack();
//        });

        //You can only do 1 thing here to trigger an exception
        assertThrowsExactly(IllegalStateException.class, theList::removeBack);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingletonList() {
        ArrayIntList list = getListWithOneValue();
        list.removeBack();
        assertEquals(list.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        //Create a list
        ArrayIntList theList = new ArrayIntList();

        //Fill list with 10 items
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        //Remove the item in the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }

    @org.junit.jupiter.api.Test
    void removeFromEmptyList() {
        ArrayIntList list = getEmptyList();
        assertThrows(IllegalStateException.class, () -> list.remove(0));
    }

    @org.junit.jupiter.api.Test
    void removeFromNonEmptyList() {
        ArrayIntList list = getListWithFourValues();
        list.remove(2);
        assertEquals(42, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void getFromEmptyList() {
        ArrayIntList list = getEmptyList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @org.junit.jupiter.api.Test
    void getFromNonEmptyList() {
        ArrayIntList list = getListWithFourValues();
        assertEquals(2, list.get(1));
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
    void size() {
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