import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {


    @org.junit.jupiter.api.Test
    void addFrontEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }
    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(25);
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addFrontResize() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.addFront(2);
        theList.addFront(3);
        theList.addFront(4);
        theList.addFront(5);
        theList.addFront(6);
        theList.addFront(7);
        assertEquals(theList.get(0), 7);
    }

    @org.junit.jupiter.api.Test
    void addFrontMultipleResize() {
        ArrayIntList theList = new ArrayIntList();
        for (int i =0; i < 1000; i++){
            theList.addFront(i);
        }
        String testString = theList.get(0) + ", " + theList.size() + ", " + theList.get(theList.size()-1);
        assertEquals(testString, "999, 1000, 0");
    }

    @org.junit.jupiter.api.Test
    void addBackEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        assertEquals(theList.get(0), 42);

    }
    @org.junit.jupiter.api.Test
    void addBackNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(25);
        theList.addBack(42);
        assertEquals(theList.get(1), 42);

    }

    @org.junit.jupiter.api.Test
    void addBackResize() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(5);
        theList.addBack(6);
        theList.addBack(7);
        assertEquals(theList.get(6), 7);
    }

    @org.junit.jupiter.api.Test
    void addBackMultipleResize() {
        ArrayIntList theList = new ArrayIntList();
        for (int i =0; i < 1000; i++){
            theList.addBack(i);
        }

        assertEquals(theList.get(999), 999);
    }
    @org.junit.jupiter.api.Test
    void addToEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0,42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addToFront() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0,42);
        theList.add(0,43);
        theList.add(0,45);
        assertEquals(theList.get(0), 45);
    }

    @org.junit.jupiter.api.Test
    void addToMiddle() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0,42);
        theList.add(0,43);
        theList.add(0,45);
        theList.add(1,100);
        assertEquals(theList.get(1), 100);
    }

    @org.junit.jupiter.api.Test
    void addToBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0,42);
        theList.add(0,43);
        theList.add(0,45);
        theList.add(3,100);
        assertEquals(theList.get(3), 100);
    }

    @org.junit.jupiter.api.Test
    void addWithResize() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0,42);
        theList.add(0,43);
        theList.add(0,45);
        theList.add(3,100);
        theList.add(0,33);
        theList.add(0,3);
        theList.add(3,75);
        assertEquals(theList.get(3), 75);
    }
    @org.junit.jupiter.api.Test
    void addOutOfRange() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, ()->theList.add(2,5));
    }


    @org.junit.jupiter.api.Test
    void removeFrontFromEmpty() {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class, theList::removeFront);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFrom1ItemList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.removeFront();
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromManyList() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        theList.removeFront();

        String out = theList.toString();

        assertEquals(out, "[2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmpty() {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IllegalStateException.class, theList::removeBack);
    }
    @org.junit.jupiter.api.Test
    void removeBackFrom1ItemList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.removeBack();
        String out = theList.toString();
        assertEquals(out, "[]");
    }
    @org.junit.jupiter.api.Test
    void removeBackFromManyList() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        theList.removeBack();

        String out = theList.toString();

        assertEquals(out, "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }


    @org.junit.jupiter.api.Test
    void removeFromEmpty() {
        ArrayIntList theList = new ArrayIntList();

        assertThrowsExactly(IndexOutOfBoundsException.class, ()->theList.remove(0));
    }

    @org.junit.jupiter.api.Test
    void removeOutOfRange() {
        ArrayIntList theList = new ArrayIntList();
        assertThrowsExactly(IndexOutOfBoundsException.class, ()->theList.remove(2));
    }
    @org.junit.jupiter.api.Test
    void remove1ItemList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.remove(0);
        String out = theList.toString();
        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void removeFromFront() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        theList.remove(0);

        String out = theList.toString();

        assertEquals(out, "[2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

    @org.junit.jupiter.api.Test
    void removeFromMiddle() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        theList.remove(3);

        String out = theList.toString();

        assertEquals(out, "[1, 2, 3, 5, 6, 7, 8, 9, 10]");
    }

    @org.junit.jupiter.api.Test
    void removeFromBack() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        theList.remove(9);

        String out = theList.toString();

        assertEquals(out, "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }
    @org.junit.jupiter.api.Test
    void getBeginning() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.get(0), 1);
    }

    @org.junit.jupiter.api.Test
    void getMiddle() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.get(5), 6);
    }

    @org.junit.jupiter.api.Test
    void getEnd() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.get(9), 10);
    }

    @org.junit.jupiter.api.Test
    void getOORange() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->theList.get(20));
    }

    @org.junit.jupiter.api.Test
    void containsBeginning() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.contains(1), true);
    }

    @org.junit.jupiter.api.Test
    void containsMiddle() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.contains(5), true);
    }

    @org.junit.jupiter.api.Test
    void containsEnd() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.contains(10), true);
    }

    @org.junit.jupiter.api.Test
    void containsMissing() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.contains(90), false);
    }

    @org.junit.jupiter.api.Test
    void indexOfBeginning() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.indexOf(1), 0);

    }

    @org.junit.jupiter.api.Test
    void indexOfMiddle() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.indexOf(5), 4);

    }

    @org.junit.jupiter.api.Test
    void indexOfEnd() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.indexOf(10), 9);

    }

    @org.junit.jupiter.api.Test
    void indexOfMissing() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.indexOf(90), -1);

    }

    @org.junit.jupiter.api.Test
    void isEmptyFull() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.isEmpty(), false);
    }

    @org.junit.jupiter.api.Test
    void isEmptyEmpty() {
        ArrayIntList theList = new ArrayIntList();

        assertEquals(theList.isEmpty(), true);
    }

    @org.junit.jupiter.api.Test
    void sizeEmpty() {
        ArrayIntList theList = new ArrayIntList();


        assertEquals(theList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeNotEmpty() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        assertEquals(theList.size(), 10);
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        theList.clear();

        assertEquals(theList.isEmpty(), true);
    }

    @org.junit.jupiter.api.Test
    void clearLarge() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=100; i++){
            theList.addBack(i);
        }

        theList.clear();

        assertEquals(theList.isEmpty(), true);
    }
    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        String out ="";
        Iterator<Integer> itr2 = theList.iterator();

        while (itr2.hasNext()) {
            out = out + itr2.next() + " ";
        }

        assertEquals(out, "1 2 3 4 5 6 7 8 9 10 ");
    }

    @org.junit.jupiter.api.Test
    void iteratorEmpty() {
        ArrayIntList theList = new ArrayIntList();

        String out ="";
        Iterator<Integer> itr2 = theList.iterator();

        while (itr2.hasNext()) {
            out = out + itr2.next() + " ";
        }

        assertEquals(out, "");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=10; i++){
            theList.addBack(i);
        }

        String out = theList.toString();

        assertEquals(out, "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

    @org.junit.jupiter.api.Test
    void testToStringEmpty() {
        ArrayIntList theList = new ArrayIntList();

        String out = theList.toString();

        assertEquals(out, "[]");
    }

    @org.junit.jupiter.api.Test
    void testToStringLong() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 1; i <=50; i++){
            theList.addBack(i);
        }

        String out = theList.toString();

        assertEquals(out, "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23" +
                ", 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, " +
                "48, 49, 50]");
    }
}