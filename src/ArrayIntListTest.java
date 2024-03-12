import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFrontWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        int count = theList.size();
        assertEquals(count, 1);
    }
    @org.junit.jupiter.api.Test
    void addFrontWithOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        int check = theList.get(0);
        assertEquals(check, 10);
    }
    @org.junit.jupiter.api.Test
    void addFrontWithMany() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        theList.addFront(11);
        theList.addFront(12);
        theList.addFront(13);
        theList.addFront(14);
        theList.addFront(15);
        int check = theList.get(0);
        assertEquals(check, 15);
    }
    ////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList thelist = new ArrayIntList();
        thelist.addBack(42);
        int count = thelist.size();
        assertEquals(count, 1);
    }
    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList thelist = new ArrayIntList();
        thelist.addBack(1);
        thelist.addBack(2);
        thelist.addBack(3);
        thelist.addBack(42);
        //int count = thelist.size();
        assertEquals(thelist.get(thelist.size()-1), 42);
    }
    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList thelist = new ArrayIntList();
        for(int i = 0; i < 10; i++){
            thelist.addBack(i);
        }
        thelist.addBack(42);
        assertEquals(thelist.get(thelist.size())-1, 42);
    }
    ///////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void addToIndexZero() {
        ArrayIntList theTest = new ArrayIntList();
        theTest.add(0,100);
        int check = theTest.get(0);
        assertEquals(check, 100);
    }
    @org.junit.jupiter.api.Test
    void addToIndexFive() {
        ArrayIntList theTest = new ArrayIntList();
        theTest.addBack(1);
        theTest.addBack(2);
        theTest.addBack(3);
        theTest.addBack(4);
        theTest.addBack(5);
        theTest.add(5,10);
        int check = theTest.get(5);
        assertEquals(check, 10);
    }
    @org.junit.jupiter.api.Test
    void addToIndexOutBound() {
        ArrayIntList theTest = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {
            theTest.add(1,10);
        });
    }
    ////////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            theList.removeFront();
        });

    }
    @org.junit.jupiter.api.Test
    void removeFrontWithOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(10);
        theList.removeFront();
        String check = theList.toString();
        assertEquals(check, "[]");
    }
    @org.junit.jupiter.api.Test
    void removeFrontWithTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        theList.removeFront();
        String check = theList.toString();
        assertEquals(check, "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    ////////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            theList.removeBack();
        });
    }
    @org.junit.jupiter.api.Test
    void removeBackWithOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(10);
        theList.removeBack();
        String check = theList.toString();
        assertEquals(check, "[]");
    }
    @org.junit.jupiter.api.Test
    void removeBackWithTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out,"[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }
    //////////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void removeWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () ->{
            theList.remove(0);
        });
    }
    @org.junit.jupiter.api.Test
    void removeWithListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(10);
        int check = theList.remove(0);
        assertEquals(check, 10);
        assertEquals(theList.size(), 0);
    }
    @org.junit.jupiter.api.Test
    void removeWithListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 1; i <= 10; i++){
            theList.addBack(i);
        }
        int check = theList.remove(5);
        assertEquals(check, 6);
        assertEquals(theList.size(), 9);
    }
    ///////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void getFirstIndexWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> {
            theList.remove(0);
        });
    }
    @org.junit.jupiter.api.Test
    void getFirstIndexWithFullList() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        int check = theList.get(0);
        assertEquals(check, 0);
    }
    @org.junit.jupiter.api.Test
    void getLastIndexWithFullList() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 0; i < 10; i++){
            theList.addBack(i);
        }
        int check = theList.get(9);
        assertEquals(check, 9);
    }
    ///////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void containsWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        //theList.contains(5);
        assertEquals(false, theList.contains(5));
    }
    @org.junit.jupiter.api.Test
    void containsWithListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(true, theList.contains(1));
    }
    @org.junit.jupiter.api.Test
    void containsWithListOfOneFalse() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(false, theList.contains(5));
    }
    @org.junit.jupiter.api.Test
    void containsWithListOf10() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 1; i <= 10; i++) {
            theList.addBack(i);
        }
        assertEquals(true, theList.contains(10));
    }
    //////////////////////////////////////////////////////

    @org.junit.jupiter.api.Test
    void indexOfEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(-1, theList.indexOf(5));
    }
    @org.junit.jupiter.api.Test
    void indexOfListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(0,theList.indexOf(1));
    }
    @org.junit.jupiter.api.Test
    void indexOfListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(0,theList.indexOf(1));
    }

    /////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void isEmptyWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(true, theList.isEmpty());
    }
    @org.junit.jupiter.api.Test
    void isEmptyWithListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 1; i <= 10; i++){
            theList.addBack(i);
        }
        assertEquals(false, theList.isEmpty());
    }
    ///////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void sizeOfEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(0, theList.size());
    }
    @org.junit.jupiter.api.Test
    void sizeOfListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        assertEquals(1, theList.size());
    }
    @org.junit.jupiter.api.Test
    void sizeOfListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 1; i <= 10; i++) {
            theList.addBack(i);
        }
        assertEquals(10, theList.size());
    }
    /////////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void clearEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.clear();
        assertEquals(0, theList.size());
    }
    @org.junit.jupiter.api.Test
    void clearListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.clear();
        assertEquals(0, theList.size());
    }
    @org.junit.jupiter.api.Test
    void clearListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 1; i <= 10; i++) {
            theList.addBack(i);
        }
        theList.clear();
        assertEquals(0, theList.size());
    }

    //////////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void iterator() {
    }
    /////////////////////////////////////////////////////////////
    @org.junit.jupiter.api.Test
    void testToStringWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        assertEquals(theList.toString(), "[]");
    }
    @org.junit.jupiter.api.Test
    void testToStringWithListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(10);
        assertEquals(theList.toString(), "[10]");
    }
    @org.junit.jupiter.api.Test
    void testToStringWithListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        for(int i = 1; i <= 10; i++){
            theList.addBack(i);
        }
        assertEquals(theList.toString(),"[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }
}