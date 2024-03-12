import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    @Test
    void addFrontWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(10);
        int check = theList.size();
        //check size is correct
        assertEquals(check, 1);
        //check value was added to front
        assertEquals(theList.get(0), 10);
    }
    @Test
    void addFrontWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(10);
        theList.addFront(20);
        int check = theList.size();
        assertEquals(check, 2);
        assertEquals(theList.get(0), 20);
    }
    @Test
    void addFrontWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i < 10; i++){
            theList.addFront(i);
        }
        int check = theList.size();
        assertEquals(check, 10);
        assertEquals(theList.get(0), 9);
    }
    /////////////////////////////////////////////////////////////////
    @Test
    void addBackWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        int check = theList.size();
        assertEquals(theList.get(0), 10);
        assertEquals(check, 1);
    }
    @Test
    void addBackWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        theList.addBack(20);
        int check = theList.size();
        assertEquals(theList.get(1), 20);
        assertEquals(check, 2);
    }
    @Test
    void addBackWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        int check = theList.size();
        assertEquals(theList.get(9), 9);
        assertEquals(check, 10);
    }
    ///////////////////////////////////////////////////////////////////
    @Test
    void addToFrontWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        theList.add(0,100);
        int check = theList.get(0);
        assertEquals(check, 100);
        assertEquals(theList.size(), 1);
    }
    @Test
    void addToFrontWithNonEmpty() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <=10; i++){
            theList.addBack(i);
        }
        theList.add(0, 100);
        int check = theList.get(0);
        assertEquals(check, 100);
        assertEquals(theList.size(), 12);
    }
    @Test
    void addToMiddleWithNonEmpty() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <=10; i++){
            theList.addBack(i);
        }
        theList.add(5,100);
        int check = theList.get(5);
        assertEquals(check, 100);
        assertEquals(theList.size(),12);
    }
    @Test
    void addToBackWithNonEmpty() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <=10; i++){
            theList.addBack(i);
        }
        theList.add(11,100);
        int check = theList.get(11);
        assertEquals(check, 100);
        assertEquals(theList.size(), 12);
    }
    //////////////////////////////////////////////////////////////////
    @Test
    void removeFrontWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertThrowsExactly(NoSuchElementException.class, () -> {
            theList.removeFront();
        });
    }
    @Test
    void removeFrontWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        theList.removeFront();
        //checks size
        int check = theList.size();
        //checks the value of index 0 have been removed(-1)
        int value = theList.get(0);

        assertEquals(check, 0);
        assertEquals(value, -1);
    }
    @Test
    void removeFrontWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        theList.removeFront();
        int check = theList.size();
        assertEquals(check, 9);
        assertEquals(theList.get(0), 1);
    }
    ////////////////////////////////////////////////////////////////
    @Test
    void removeBackWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertThrowsExactly(NoSuchElementException.class, () -> {
            theList.removeBack();
        });
    }
    @Test
    void removeBackWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        theList.removeBack();
        int check = theList.size();
        assertEquals(check, 0);
        assertEquals(theList.get(0), -1);
    }
    @Test
    void removeBackWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        theList.removeBack();
        int check = theList.size();
        assertEquals(check, 9);
        assertEquals(theList.get(8), 8);
    }
    //////////////////////////////////////////////////////////////////
    @Test
    void removeFrontEmpty() {
        LinkedIntList theList = new LinkedIntList();
        int check = theList.remove(0);
        assertEquals(check, -1);
    }
    @Test
    void removeFrontNonEmpty() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <=9; i++){
            theList.addBack(i);
        }
        int check = theList.remove(0);
        assertEquals(check, 0);
        assertEquals(theList.size(), 9);
    }
    @Test
    void removeMiddleNonEmpty() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <= 9; i++){
            theList.addBack(i);
        }
        int check = theList.remove(5);
        assertEquals(check, 5);
        assertEquals(theList.size(), 9);
    }
    @Test
    void removeBackNonEmpty() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <= 9; i++){
            theList.addBack(i);
        }
        int check = theList.remove(9);
        assertEquals(check, 9);
        assertEquals(theList.size(), 9);
    }
    //////////////////////////////////////////////////////////////
    @Test
    void getWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(theList.get(0), -1);
    }
    @Test
    void getWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(25);
        assertEquals(theList.get(0), 25);
    }
    @Test
    void getWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.get(9), 9);
        assertEquals(theList.get(5), 5);
    }
    /////////////////////////////////////////////////////////////////
    @Test
    void containsWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(theList.contains(100), false);
    }
    @Test
    void containsWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        assertEquals(theList.contains(10), true);
        assertEquals(theList.contains(100), false);
    }
    @Test
    void containsWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.contains(0), true);
        assertEquals(theList.contains(5), true);
        assertEquals(theList.contains(9), true);
        assertEquals(theList.contains(10), false);
    }
    ////////////////////////////////////////////////////////////////////////
    @Test
    void indexOfWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(theList.indexOf(5), -1);
    }
    @Test
    void indexOfWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(100);
        assertEquals(theList.indexOf(0), 100);
    }
    @Test
    void indexOfWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <= 10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(10), 10);
    }
    @Test
    void indexOfOutOfBounds() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <= 10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(11), -1);
    }
    ////////////////////////////////////////////////////////////////////
    @Test
    void isEmptyWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(theList.isEmpty(), true);
    }
    @Test
    void isEmptyWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        assertEquals(theList.isEmpty(),false);
    }
    @Test
    void isEmptyWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <= 10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.isEmpty(), false);
    }
    ////////////////////////////////////////////////////////////////
    @Test
    void sizeWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        assertEquals(theList.size(), 0);
    }
    @Test
    void sizeWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        assertEquals(theList.size(), 1);
    }
    @Test
    void sizeWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <=10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.size(), 11);
    }
    /////////////////////////////////////////////////////////////////
    @Test
    void clearWithEmpty() {
        LinkedIntList theList = new LinkedIntList();
        theList.clear();
        assertEquals(theList.size(),0);
    }
    @Test
    void clearWithOne() {
        LinkedIntList theList = new LinkedIntList();
        theList.addBack(10);
        theList.clear();
        assertEquals(theList.size(), 0);
    }
    @Test
    void clearWithMany() {
        LinkedIntList theList = new LinkedIntList();
        for(int i = 0; i <=10; i++){
            theList.addBack(i);
        }
        theList.clear();
        assertEquals(theList.size(), 0);
    }

    @Test
    void iterator() {
    }

    @Test
    void testToString() {
    }

    @Test
    void print() {
    }
}