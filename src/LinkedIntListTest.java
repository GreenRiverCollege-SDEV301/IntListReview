import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    // addFront() tests


    @Test
    void addFrontWithEmptyList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(25);
        assertEquals(theList.get(0), 25);
    }

    @Test
    void addFrontWithSingleItemList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(40);
        theList.addFront(4);
        assertEquals(theList.get(0), 4);
    }

    @Test
    void addFrontWithMultiItemList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(25);
        theList.addFront(40);
        theList.addFront(4);
        theList.addFront(88);
        assertEquals(theList.get(0), 88);
    }



    // addBack() tests



    @Test
    void addBackWithEmptyList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(25);
        assertEquals(theList.get(0), 25);
    }

    @Test
    void addBackWithSingleItemList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(50);
        theList.addBack(30);
        assertEquals(theList.get(theList.size()-1), 30);
    }

    @Test
    void addBackWithMultiItemList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(50);
        theList.addBack(30);
        theList.addBack(23);
        theList.addBack(88);
        assertEquals(theList.get(theList.size()-1), 88);
    }



    // add() Tests


    @org.junit.jupiter.api.Test
    void addWithEmptyList() {
        LinkedIntList theList = new LinkedIntList();

        theList.add(0, 42);
        assertEquals(theList.get(0), 42);
    }
    @org.junit.jupiter.api.Test
    void addWithNonEmptyListToMiddle() {
        LinkedIntList theList = new LinkedIntList();
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
        LinkedIntList theList = new LinkedIntList();
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
        LinkedIntList theList = new LinkedIntList();

        theList.addFront(42);
        theList.addFront(55);
        theList.addFront(80);

        assertThrows(IndexOutOfBoundsException.class, ()->{theList.add(5, 2);});
    }



    // removeFront() Tests


    @org.junit.jupiter.api.Test
    void removeFront() {
        LinkedIntList theList = new LinkedIntList();

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
        LinkedIntList theList = new LinkedIntList();

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
        LinkedIntList theList = new LinkedIntList();

        assertThrows(IllegalStateException.class, theList::removeFront);
    }



    // removeBack() Tests


    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        LinkedIntList theList = new LinkedIntList();

        assertThrows(IllegalStateException.class, theList::removeBack);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingleItemList() {
        LinkedIntList theList = new LinkedIntList();

        theList.addBack(50);
        theList.removeBack();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10() {
        LinkedIntList theList = new LinkedIntList();

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
        LinkedIntList theList = new LinkedIntList();
        // Add 100 numbers to the list
        for(int i = 0; i < 100; i++){
            theList.addBack(i);
        }
        assertEquals(theList.remove(5), 5);
    }

    @org.junit.jupiter.api.Test
    void removeFromBeginning() {
        LinkedIntList theList = new LinkedIntList();
        // Add 100 numbers to the list
        for(int i = 0; i < 100; i++){
            theList.addBack(i);
        }
        assertEquals(theList.remove(0), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFromEnd() {
        LinkedIntList theList = new LinkedIntList();
        // Add 100 numbers to the list
        for(int i = 0; i < 100; i++){
            theList.addBack(i);
        }
        assertEquals(theList.remove(theList.size()-1), 99);
    }



    // get() Tests


    @org.junit.jupiter.api.Test
    void getFromEmptyList() {
        LinkedIntList theList = new LinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, ()->{
            theList.get(0);
        });
    }

    @org.junit.jupiter.api.Test
    void getFromSingleItemList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(50);
        assertEquals(theList.get(0), 50);
    }

    @org.junit.jupiter.api.Test
    void getFromMultiItemList() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(50);
        theList.addFront(22);
        theList.addBack(78);
        theList.addBack(45);
        theList.addBack(14);
        assertEquals(theList.get(2), 78);
    }

    @org.junit.jupiter.api.Test
    void getFromBack() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(50);
        theList.addFront(22);
        theList.addFront(15);
        theList.addFront(66);
        assertEquals(theList.get(theList.size()-1), 50);
    }



    // contains() Tests


    @org.junit.jupiter.api.Test
    void containsWithEmptyList() {
        LinkedIntList theList = new LinkedIntList();
        assertFalse(theList.contains(5));
    }

    @org.junit.jupiter.api.Test
    void containsWithSingleItem() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(5);
        assertTrue(theList.contains(5));
    }

    @org.junit.jupiter.api.Test
    void containsWithMultiItem() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(5);
        theList.addFront(10);
        theList.addFront(15);
        theList.addFront(20);
        assertTrue(theList.contains(15));
    }


    // indexOf() Tests


    @org.junit.jupiter.api.Test
    void indexOfEmptyList() {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(theList.indexOf(0), -1);
    }

    @org.junit.jupiter.api.Test
    void indexOfSingleItem() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(10);
        assertEquals(theList.indexOf(10), 0);
    }

    @org.junit.jupiter.api.Test
    void indexOfFullList() {
        LinkedIntList theList = new LinkedIntList();
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
        LinkedIntList theList = new LinkedIntList();
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
        LinkedIntList theList = new LinkedIntList();

        assertTrue(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyWithSingleItem() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(10);

        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyWithMultipleItems() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(10);
        theList.addFront(22);
        theList.addFront(76);
        theList.addFront(48);
        theList.addFront(90);

        assertFalse(theList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmptyAfterRemoval() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(10);
        theList.addFront(22);
        theList.removeFront();
        theList.removeFront();

        assertTrue(theList.isEmpty());
    }



    // size() Tests


    @org.junit.jupiter.api.Test
    void sizeWhileEmpty() {
        LinkedIntList theList = new LinkedIntList();

        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeWithSingleItem() {
        LinkedIntList theList = new LinkedIntList();

        theList.addFront(55);

        assertEquals(theList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void sizeWithMultipleItems() {
        LinkedIntList theList = new LinkedIntList();

        for(int i=0; i< 100; i++){
            theList.addBack(i);
        }

        assertEquals(theList.size(), 100);
    }



    // clear() Tests


    @org.junit.jupiter.api.Test
    void clearWithItemsInList() {
        LinkedIntList theList = new LinkedIntList();

        theList.addFront(5);
        theList.addFront(50);
        theList.addFront(24);

        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clearWithEmptyList() {
        LinkedIntList theList = new LinkedIntList();

        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clearAfterAddThenRemoveList() {
        LinkedIntList theList = new LinkedIntList();

        theList.addFront(5);
        theList.addFront(50);
        theList.removeFront();
        theList.removeFront();

        theList.clear();
        assertEquals(theList.size(), 0);
    }
}