import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
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
    void add() {
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
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
    void remove() {

        fail();
    }

    @org.junit.jupiter.api.Test
    void get() {
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
    void forEach() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}