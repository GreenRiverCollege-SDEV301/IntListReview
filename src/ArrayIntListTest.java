import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    // addFront() Tests

    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }
    @org.junit.jupiter.api.Test
    void addFrontWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        theList.addFront(22);
        theList.addFront(8);
        theList.addFront(99);
        assertEquals(theList.get(0), 99);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithResize() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i < 10; i++){
            theList.addFront(i);
        }
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addFrontWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i < 100000; i++){
            theList.addFront(i);
        }
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    // addBack() Tests
    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
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
        assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i < 10; i++){
            theList.addBack(i);
        }
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i < 1000000; i++){
            theList.addBack(i);
        }
        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }



    // add() Tests



    @org.junit.jupiter.api.Test
    void addWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        theList.add(0, 42);
        assertEquals(theList.get(0), 42);
    }
    @org.junit.jupiter.api.Test
    void addWithNonEmptyListToMiddle() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(50);
        theList.addFront(24);
        theList.addFront(15);
        theList.addFront(50);
        theList.addFront(22);
        theList.addFront(15);

        theList.add(2, 15);
        assertEquals(theList.get(2), 15);
    }

    @org.junit.jupiter.api.Test
    void addWithNonEmptyListToBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(50);
        theList.addBack(24);
        theList.addBack(15);
        theList.addBack(50);
        theList.addBack(22);
        theList.addBack(15);

        theList.add(theList.size()-1, 15);
        assertEquals(theList.get(theList.size()-1), 15);
    }
    @org.junit.jupiter.api.Test
    void addWithIndexOutOfRange() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(42);
        theList.addFront(55);
        theList.addFront(80);

        assertThrows(IndexOutOfBoundsException.class, ()->{theList.add(5, 2);});
    }

    @org.junit.jupiter.api.Test
    void addWithResize() {
        ArrayIntList theList = new ArrayIntList();
        for(int i=0; i < 10; i++){
            theList.add(i, i*2);
        }
        theList.add(theList.size(), 42);
        assertEquals(theList.get(theList.size()-1), 42);
    }



    // removeFront() Tests


    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(42);
        theList.addFront(55);
        theList.addFront(72);
        theList.addFront(80);
        theList.addFront(24);
        theList.removeFront();
        assertEquals(theList.get(0), 80);
    }

    @org.junit.jupiter.api.Test
    void removeFrontMultipleTimes() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(42);
        theList.addFront(55);
        theList.addFront(72);
        theList.addFront(80);
        theList.addFront(24);
        theList.removeFront();
        theList.removeFront();
        theList.removeFront();
        theList.removeFront();
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void removeFrontEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        assertThrows(IllegalStateException.class, theList::removeFront);
    }

    @org.junit.jupiter.api.Test
    void removeFrontAfterResize() {
        ArrayIntList theList = new ArrayIntList();

        for(int i=0; i < 100; i++){
            theList.addBack(i);
        }
        theList.removeFront();

        assertEquals(theList.get(0), 1);
    }



    // removeBack() Tests


    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        assertThrows(IllegalStateException.class, theList::removeBack);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingleItemList() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(50);
        theList.removeBack();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        ArrayIntList theList = new ArrayIntList();

        // Fill list with 10 items [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        for(int i=0; i < 10; i++){
            theList.addBack(i);
        }

        // Remove the item from the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }



    // remove() Tests


    @org.junit.jupiter.api.Test
    void removeFromMiddle() {
        ArrayIntList theList = new ArrayIntList();
        // Add 100 numbers to the list
        for(int i = 0; i < 100; i++){
            theList.addBack(i);
        }
        assertEquals(theList.remove(5), 5);
    }

    @org.junit.jupiter.api.Test
    void removeFromBeginning() {
        ArrayIntList theList = new ArrayIntList();
        // Add 100 numbers to the list
        for(int i = 0; i < 100; i++){
            theList.addBack(i);
        }
        assertEquals(theList.remove(0), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFromEnd() {
        ArrayIntList theList = new ArrayIntList();
        // Add 100 numbers to the list
        for(int i = 0; i < 100; i++){
            theList.addBack(i);
        }
        assertEquals(theList.remove(theList.size()-1), 99);
    }



    // get() Tests


    @org.junit.jupiter.api.Test
    void getFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, ()->{
            theList.get(0);
        });
    }

    @org.junit.jupiter.api.Test
    void getFromSingleItemList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(50);
        assertEquals(theList.get(0), 50);
    }

    @org.junit.jupiter.api.Test
    void getFromMultiItemList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(50);
        theList.addFront(22);
        theList.addBack(78);
        theList.addBack(45);
        theList.addBack(14);
        assertEquals(theList.get(2), 78);
    }

    @org.junit.jupiter.api.Test
    void getFromBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(50);
        theList.addFront(22);
        theList.addFront(15);
        theList.addFront(66);
        assertEquals(theList.get(theList.size()-1), 50);
    }

    // contains() Tests
    @org.junit.jupiter.api.Test
    void containsWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertFalse(theList.contains(5));
    }

    @org.junit.jupiter.api.Test
    void containsWithSingleItem() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(5);
        assertTrue(theList.contains(5));
    }

    @org.junit.jupiter.api.Test
    void containsWithMultiItem() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(5);
        theList.addFront(10);
        theList.addFront(15);
        theList.addFront(20);
        assertTrue(theList.contains(15));
    }



    // indexOf() Tests


    @org.junit.jupiter.api.Test
    void indexOfEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.indexOf(0), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfSingleItem() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        assertEquals(theList.indexOf(10), 0);
    }

    @org.junit.jupiter.api.Test
    void indexOfFullList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        theList.addFront(22);
        theList.addFront(36);
        theList.addFront(78);
        theList.addFront(49);
        theList.addFront(99);
        assertEquals(theList.indexOf(78), 2);
    }

    @org.junit.jupiter.api.Test
    void indexOfItemAtEnd() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        theList.addFront(56);
        theList.addFront(99);
        theList.addFront(28);
        theList.addFront(75);
        theList.addFront(73);
        theList.addFront(58);
        assertEquals(theList.indexOf(10), theList.size()-1);
    }


    // isEmpty() Tests


    @org.junit.jupiter.api.Test
    void isEmptyWithNoItems() {
        ArrayIntList theList = new ArrayIntList();

        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyWithSingleItem() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);

        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyWithMultipleItems() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        theList.addFront(22);
        theList.addFront(76);
        theList.addFront(48);
        theList.addFront(90);

        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyAfterRemoval() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        theList.addFront(22);
        theList.removeFront();
        theList.removeFront();

        assertTrue(theList.isEmpty());
    }



    // size() Tests


    @org.junit.jupiter.api.Test
    void sizeWhileEmpty() {
        ArrayIntList theList = new ArrayIntList();

        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeWithSingleItem() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(55);

        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void sizeWithMultipleItems() {
        ArrayIntList theList = new ArrayIntList();

        for(int i=0; i< 100; i++){
            theList.addBack(i);
        }

        assertEquals(theList.size(), 100);
    }



    // clear() Tests


    @org.junit.jupiter.api.Test
    void clearWithItemsInList() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(5);
        theList.addFront(50);
        theList.addFront(24);

        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clearWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clearAfterAddThenRemoveList() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(5);
        theList.addFront(50);
        theList.removeFront();
        theList.removeFront();

        theList.clear();
        assertEquals(theList.size(), 0);
    }



    // Iterator() tests


    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(5);
        theList.addFront(10);
        theList.addFront(15);
        theList.addFront(20);

        int i = 0;
        for(int n : theList){
            assertEquals(n, theList.get(i));
            i++;
        }
    }



    // toString() Tests


    @org.junit.jupiter.api.Test
    void testToStringWithSingleItem() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(5);
        assertEquals(theList.toString(), "[5]");
    }

    @org.junit.jupiter.api.Test
    void testToStringWithMultipleItems() {
        ArrayIntList theList = new ArrayIntList();

        theList.addFront(5);
        theList.addFront(50);
        assertEquals(theList.toString(), "[50, 5]");
    }

    @org.junit.jupiter.api.Test
    void testToStringWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        assertEquals(theList.toString(), "[]");
    }
}