import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFrontToEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addFrontToResizedList() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 100; i++) {
            theList.addFront(i);
        }
        theList.addFront(42);
        assertEquals(theList.get(0),42);
    }

    @org.junit.jupiter.api.Test
    void addFrontToListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.addFront(42);
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addFrontToListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++){
            theList.addFront(42);
        }
        assertEquals(theList.get(0), 42);
    }

    @org.junit.jupiter.api.Test
    void addBackWithEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        // the following checks/verifies if the variable is the same as what we expected
        // this also is testing the size method though, so we have to be sure that works
        assertEquals(theList.get(theList.size()-1), 42);
        // some people will use string outputs
        String out = theList.toString();
        assertEquals(out, "[42]");
    }

    // there will almost always be multiple tests per method
    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        theList.addBack(4);
        theList.addBack(42);
        // the following checks/verifies if the variable is the same as what we expected
        // this also is testing the size method though, so we have to be sure that works
        assertEquals(theList.get(theList.size() - 1), 42);
        // some people will use string outputs
        String out = theList.toString();
        assertEquals(out, "[1, 2, 3, 4, 42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        // fill list with initial capacity (ten items)
        for (int i = 0; i <= 10; i++) {
            theList.addBack(i);
        }

        theList.addBack(42);
        // the following checks/verifies if the variable is the same as what we expected
        // this also is testing the size method though, so we have to be sure that works
        assertEquals(theList.get(theList.size()-1), 42);
        // some people will use string outputs
    }

    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizes() {
        ArrayIntList theList = new ArrayIntList();
        // fill list with initial capacity (ten items)
        for (int i = 0; i < 1000; i++) {
            theList.addBack(i);
        }
        theList.addBack(42);
        // the following checks/verifies if the variable is the same as what we expected
        // this also is testing the size method though, so we have to be sure that works
        assertEquals(theList.get(theList.size()-1), 42);
    }


    @org.junit.jupiter.api.Test
    void addListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.add(0, 100);
        assertEquals(theList.get(0), 100);
    }

    @org.junit.jupiter.api.Test
    void addIndexOutOfBounds() {
        ArrayIntList theList = new ArrayIntList();
        // adding anything at this point should be out of bounds, the list is 0
        assertThrowsExactly(IndexOutOfBoundsException.class,
                // lambda to tell it the code to run that should throw the exception
                () -> {theList.add(2, 4);});
    }

    @org.junit.jupiter.api.Test
    void addMultiple() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            theList.add(i, i);
        }
        assertEquals(theList.toString(), "[0, 1, 2, 3, 4]");
    }

    @org.junit.jupiter.api.Test
    void addResize() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 100; i++) {
            theList.add(i, i);
        }
        theList.add(99, 42);
        assertEquals(theList.get(99), 42);
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromEmpty() {
        ArrayIntList theList = new ArrayIntList();
        theList.removeFront();
        // trying to get the index should throw an error because the list is empty
        assertThrowsExactly(IndexOutOfBoundsException.class,
                () -> {theList.get(0);});
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromMultipleList() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            theList.addFront(i);
        }
        theList.removeFront();
        // removing the front should remove the 4 at index 0, leaving a 3
        assertEquals(theList.get(0), 3);
    }

    @org.junit.jupiter.api.Test
    void removeFrontAfterResize() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 15; i++) {
            theList.addFront(i);
        }
        theList.addFront(42);
        assertEquals(theList.get(0), 42);

    }

    @org.junit.jupiter.api.Test
    void removeFrontListOfOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addFront(1);
        theList.removeFront();
        assertEquals(theList.get(0), 0);

    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList() {
        ArrayIntList theList = new ArrayIntList();

        // test it throws illegalStateException when list is empty
        // if you don't use the exactly you could throw a subtype of the illegalStateException as well
        // .class gives metadata for exception
        assertThrowsExactly(IllegalStateException.class,
                // lambda to tell it the code to run that should throw the exception
                () -> {theList.removeBack();});
                // can also be method reference - theList::removeBack
                // method reference passes the metadata for the method as well as the class
                // but if you need to do more than one thing to cause the exception, this only allows it to run once
                // so you would need to change it to a lambda expression
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingleItemList() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(1);

        // remove the item at the back
        theList.removeBack();
        // test - index is 0, since the one added item was index 0
        // size - 1 as we've been using would give us an error, which we might also test
        assertEquals(theList.get(0), 0);
        }


    @org.junit.jupiter.api.Test
    void removeBackFromListOfTen() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10 ; i++) {
            theList.addBack(i);
        }
        // remove the item at the back
        theList.removeBack();
        // test
        assertEquals(theList.get(theList.size() - 1), 8);
    }


    @org.junit.jupiter.api.Test
    void removeFromListOfOne() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(1);
        theList.remove(0);

        // should return 0
        assertEquals(theList.get(theList.size() - 1), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFromMiddle() {
        ArrayIntList theList = new ArrayIntList();

        theList.addBack(1);
        theList.addBack(42);
        theList.addBack(52);
        theList.remove(1);

        // should return 0
        assertEquals(theList.get(1), 52);
    }

    @org.junit.jupiter.api.Test
    void removeOutOfBounds() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        // should throw error
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
                // lambda to tell it the code to run that should throw the exception
                () -> {
                    theList.remove(10);
                });

    }


    @org.junit.jupiter.api.Test
    void getBeginning() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.get(0), 0);
    }

    @org.junit.jupiter.api.Test
    void getMiddle() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.get(5), 5);
    }

    @org.junit.jupiter.api.Test
    void getEnd() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.get(9), 9);
    }

    @org.junit.jupiter.api.Test
    void containsAtEnd() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.contains(9), true);
    }


    @org.junit.jupiter.api.Test
    void containsNotFound() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.contains(42), false);
    }

    @org.junit.jupiter.api.Test
    void containsAtBeginning() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.contains(0), true);
    }

    @org.junit.jupiter.api.Test
    void indexOfMiddle() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(5), 5);
    }

    @org.junit.jupiter.api.Test
    void indexOfBeginning() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(0), 0);
    }

    @org.junit.jupiter.api.Test
    void indexOfEnd() {
        ArrayIntList theList = new ArrayIntList();
        // fill it with ten items
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.indexOf(9), 9);
    }

    @org.junit.jupiter.api.Test
    void isEmptyTrue() {
        ArrayIntList theList = new ArrayIntList();

        assertEquals(theList.isEmpty(), true);
    }

    @org.junit.jupiter.api.Test
    void isEmptyListofOne() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);

        assertEquals(theList.isEmpty(), false);
    }

    @org.junit.jupiter.api.Test
    void isEmptyMultiList() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }

        assertEquals(theList.isEmpty(), false);
    }

    // TODO: add tests
    @org.junit.jupiter.api.Test
    void size() {
    }
    // TODO: add tests
    @org.junit.jupiter.api.Test
    void clear() {
    }
    // TODO: add tests
    @org.junit.jupiter.api.Test
    void iterator() {
    }
    // TODO: add tests
    @org.junit.jupiter.api.Test
    void forEach() {
    }
    // TODO: add tests
    @org.junit.jupiter.api.Test
    void testToString() {
    }
}