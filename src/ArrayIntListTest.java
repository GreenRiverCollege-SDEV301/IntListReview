import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest
{

    ArrayIntList theList = new ArrayIntList();


    @org.junit.jupiter.api.Test
    void addFrontToEmptyList()
    {
        theList.addFront(42);
        assertEquals(1, theList.size(), "Size should be 1 after adding to empty list.");
        assertEquals(42, theList.get(0), "The first element should be 42.");
    }

    @org.junit.jupiter.api.Test
    void addFrontToNonEmptyList()
    {
        theList.addFront(1); // Assuming addFront works as expected.
        theList.addFront(42); // Now adding 42 to the front.

        assertEquals(2, theList.size(), "Size should be 2 after adding two elements.");
        assertEquals(42, theList.get(0), "42 should be at the front of the list.");
        assertEquals(1, theList.get(1), "1 should be the second element.");
    }


    @org.junit.jupiter.api.Test
    void addFrontWithResizing()
    {
        // Assuming initial buffer size is 10, adjust if different.
        for (int i = 0; i < 10; i++) {
            theList.addFront(i);
        }

        // List is now full, next addFront should trigger resize.
        theList.addFront(42);

        assertEquals(11, theList.size(), "Size should be 11 after adding the 11th element.");
        assertEquals(42, theList.get(0), "42 should be at the front of the list after resizing.");
        assertEquals(9, theList.get(1), "The element '9' should be at index 1 after adding '42' at the front.");
        assertEquals(0, theList.get(10), "The last element should now be 0.");
    }


    @org.junit.jupiter.api.Test
    void addBackWithEmptyList()
    {

        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
//        int count = theList.size();
//        assertEquals(theList.get(0),42);


        String out = theList.toString();
        assertEquals(out,"[42]");
    }

    @org.junit.jupiter.api.Test
    void addBackWithNonEmptyList()
    {

        theList.addBack(1);
//        int count = theList.size();
//        assertEquals(theList.get(0),42);

        theList.addBack(3);
        theList.addBack(2);
        theList.addBack(42);

        assertEquals(theList.get(theList.size() -1), 42);
        String out = theList.toString();
//        assertEquals(out,"[1, 2, 3, 42]");
    }


    @org.junit.jupiter.api.Test
    void addBackWithResizeList()
    {


        // fill the list with INITIAL_CAPTIVITY or 10 items

        for (int i = 0; i < 10; i++)
        {
            theList.addBack(i);
        }

        // now add item 11:

        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }


    @org.junit.jupiter.api.Test
    void addBackWithMultipleResizeList()
    {

        ArrayIntList theList = new ArrayIntList();
        // fill the list with INITIAL_CAPTIVITY or 10 items

        for (int i = 0; i < 1000000; i++)
        {
            theList.addBack(i);
        }

        // now add item 11:

        theList.addBack(42);
        assertEquals(theList.get(theList.size()-1), 42);
    }


//    @org.junit.jupiter.api.Test
//    void add()
//    {
//    }

    @org.junit.jupiter.api.Test
    void addToListWithValidIndex()
    {
        // Adding to an empty list
        theList.add(0, 42);
        assertEquals(42, theList.get(0), "Element 42 should be at index 0.");

        // Adding to the beginning of the list
        theList.add(0, 1);
        assertEquals(1, theList.get(0), "Element 1 should be at index 0.");

        // Adding to the end of the list
        theList.add(2, 24);
        assertEquals(24, theList.get(2), "Element 24 should be at the end of the list.");

        // Adding to the middle of the list
        theList.add(1, 10);
        assertEquals(10, theList.get(1), "Element 10 should be at index 1.");
    }


    @org.junit.jupiter.api.Test
    void addAtIndexZeroToNonEmptyList()
    {
        theList.addBack(1);
        theList.addBack(3);
        theList.add(0, 2); // Adding 2 at the front
        assertEquals(2, theList.get(0), "Element 2 should be at index 0.");
        assertEquals(3, theList.get(2), "Element 3 should be now at index 2.");
    }


    @org.junit.jupiter.api.Test
    void addToListCausingResize()
    {
        // Assuming initial buffer size is 10, adjust if different.
        for (int i = 0; i < 10; i++) {
            theList.addBack(i);
        }
        theList.add(5, 42);
        assertEquals(42, theList.get(5), "Element 42 should be at index 5 after resizing.");
    }


    @org.junit.jupiter.api.Test
    void addWithInvalidIndex()
    {
        // Adding with an invalid negative index
        assertThrows(IndexOutOfBoundsException.class, () -> theList.add(-1, 42));

        // Adding with an index greater than the size
        assertThrows(IndexOutOfBoundsException.class, () -> theList.add(theList.size() + 1, 42));
    }

//    @org.junit.jupiter.api.Test
//    void removeFront()
//    {
//    }


    @org.junit.jupiter.api.Test
    void removeFrontFromSingleElementList()
    {
        theList.addBack(42); // Add a single element
        theList.removeFront(); // Remove the element at the front

        assertEquals(0, theList.size(), "List should be empty after removing the only element.");
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromMultipleElementList()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3); // List is now [1, 2, 3]

        theList.removeFront(); // Removes the front element, which is '1'

        assertEquals(2, theList.size(), "List should have 2 elements after removing the front.");
        assertEquals(2, theList.get(0), "The first element should now be '2'.");
        assertEquals(3, theList.get(1), "The second element should be '3'.");
    }

    @org.junit.jupiter.api.Test
    void removeFrontFromEmptyList()
    {
        theList.removeFront(); // Removing from an empty list should not fail

        assertEquals(0, theList.size(), "Empty list should remain empty after attempting to remove from front.");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromEmptyList()
    {

        assertThrows(IllegalStateException.class, () -> {
            throw new IllegalStateException();
        });
    }

    @org.junit.jupiter.api.Test
    void removeBackFromSingleLIst()
    {

        theList.addBack(42); // Add a single element
        theList.removeBack(); // Remove the element at the back

        assertEquals(0, theList.size(), "List should be empty after removing the only element.");
    }

    @org.junit.jupiter.api.Test
    void removeBackFromListOf10()
    {

        ArrayIntList theList = new ArrayIntList();
        // fill this with 10 items (0, 1, 2, 3, 4, 5, 6, 7, 8)
        for (int i = 0; i < 10; i++)
        {

            theList.addBack(i);

        }

        // remove the item in the back
        theList.removeBack();

        String out = theList.toString();
        assertEquals(out, "[0, 1, 2, 3, 4, 5, 6, 7, 8]");
    }


//    @org.junit.jupiter.api.Test
//    void remove()
//    {
//    }

    @org.junit.jupiter.api.Test
    void removeElementFromBeginningOfList()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3); // List is [1, 2, 3]
        int removedElement = theList.remove(0); // Remove the first element

        assertEquals(1, removedElement, "The removed element should be 1.");
        assertEquals(2, theList.size(), "Size should be 2 after removal.");
        assertEquals(2, theList.get(0), "The first element should now be 2.");
        assertEquals(3, theList.get(1), "The second element should now be 3.");
    }

//    @org.junit.jupiter.api.Test
//    void removeElementFromEndOfList() {
//        theList.addBack(1);
//        theList.addBack(2);
//        theList.addBack(3); // List is [1, 2, 3]
//        int removedElement = theList.remove(theList.size() - 1); // Remove the last element
//
//        assertEquals(3, removedElement, "The removed element should be 3.");
//        assertEquals(2, theList.size(), "Size should be 2 after removal.");
//        assertThrows(IndexOutOfBoundsException.class, () -> theList.get(2),
//                "Accessing beyond the end should throw exception.");
//    }



    @org.junit.jupiter.api.Test
    void removeElementFromMiddleOfList() {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3); // List is [1, 2, 3]
        int removedElement = theList.remove(1); // Remove from the middle

        assertEquals(2, removedElement, "The removed element should be 2.");
        assertEquals(2, theList.size(), "Size should be 2 after removal.");
        assertEquals(1, theList.get(0), "The first element should still be 1.");
        assertEquals(3, theList.get(1), "The second element should now be 3.");
    }


    @org.junit.jupiter.api.Test
    void removeWithIndexOutOfBounds() {
        theList.addBack(1);
        theList.addBack(2);

        assertThrows(IndexOutOfBoundsException.class, () -> theList.remove(-1), "Removing with negative index should throw exception.");
        assertThrows(IndexOutOfBoundsException.class, () -> theList.remove(theList.size()), "Removing with index equal to size should throw exception.");
    }


//    @org.junit.jupiter.api.Test
//    void get()
//    {
//    }

    @org.junit.jupiter.api.Test
    void getValidIndex()
    {
        // Test a range of valid indices
        for(int i = 0; i < theList.size(); i++)
        {
            assertEquals(i, theList.get(i), "Element at index " + i + " should be " + i + ".");
        }
    }


//    @org.junit.jupiter.api.Test
//    void getIndexOutOfBounds()
//    {
//        // Test index below 0
//        assertThrows(IndexOutOfBoundsException.class, () -> theList.get(-1),
//                "Accessing index -1 should throw an IndexOutOfBoundsException.");
//
//        // Test index equal to size
//        assertThrows(IndexOutOfBoundsException.class, () -> theList.get(theList.size()),
//                "Accessing index equal to size should throw an IndexOutOfBoundsException.");
//
//        // Test index above size
//        assertThrows(IndexOutOfBoundsException.class, () -> theList.get(theList.size() + 1),
//                "Accessing index greater than size should throw an IndexOutOfBoundsException.");
//    }

//    @org.junit.jupiter.api.Test
//    void contains()
//    {
//    }


    @org.junit.jupiter.api.Test
    void containsValueInList()
    {
        theList.addBack(1); // Assuming addBack correctly adds an element to the list
        theList.addBack(2);
        theList.addBack(3);

        assertTrue(theList.contains(1), "List should contain 1.");
        assertTrue(theList.contains(2), "List should contain 2.");
        assertTrue(theList.contains(3), "List should contain 3.");
    }

    @org.junit.jupiter.api.Test
    void doesNotContainValueNotInList()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);

        assertFalse(theList.contains(4), "List should not contain 4.");
    }

    @org.junit.jupiter.api.Test
    void doesNotContainValueInEmptyList()
    {
        assertFalse(theList.contains(1), "Empty list should not contain 1.");
    }


//    @org.junit.jupiter.api.Test
//    void indexOf()
//    {
//    }

    @org.junit.jupiter.api.Test
    void indexOfValueAtBeginning()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        assertEquals(0, theList.indexOf(1), "Index of 1 should be 0.");
    }


    @org.junit.jupiter.api.Test
    void indexOfValueAtEnd()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        assertEquals(2, theList.indexOf(3), "Index of 3 should be 2.");
    }

    @org.junit.jupiter.api.Test
    void indexOfValueInMiddle()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        assertEquals(1, theList.indexOf(2), "Index of 2 should be 1.");
    }

    @org.junit.jupiter.api.Test
    void indexOfValueNotPresent()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(3);
        assertEquals(-1, theList.indexOf(4), "Index of 4 should be -1 since it is not in the list.");
    }


    @org.junit.jupiter.api.Test
    void indexOfMultipleInstances()
    {
        theList.addBack(1);
        theList.addBack(2);
        theList.addBack(2);
        theList.addBack(3);
        assertEquals(1, theList.indexOf(2), "Index of 2 should be 1, the first occurrence.");
    }


    @org.junit.jupiter.api.Test
    void indexOfValueInEmptyList()
    {
        assertEquals(-1, theList.indexOf(1), "Index of 1 should be -1 in an empty list.");
    }




//    @org.junit.jupiter.api.Test
//    void isEmpty()
//    {
//    }

    @org.junit.jupiter.api.Test
    void isEmptyOnInitialization()
    {
        assertTrue(theList.isEmpty(), "List should be empty upon initialization.");

    }

    @org.junit.jupiter.api.Test
    void isNotEmptyAfterAdd() {
        theList.addBack(1); // Assuming addBack method adds an element
        assertFalse(theList.isEmpty(), "List should not be empty after adding elements.");
    }

    @org.junit.jupiter.api.Test
    void isEmptyAfterRemoveAll() {
        theList.addBack(1);
        theList.remove(0); // Assuming remove method removes an element at index
        assertTrue(theList.isEmpty(), "List should be empty after removing all elements.");
    }


//    @org.junit.jupiter.api.Test
//    void size()
//    {
//    }

    @org.junit.jupiter.api.Test
    void sizeOfNewList() {
        assertEquals(0, theList.size(), "New list should have size 0.");
    }

    @org.junit.jupiter.api.Test
    void sizeAfterAddingElements() {
        theList.addBack(1); // Assuming addBack adds an element
        assertEquals(1, theList.size(), "List should have size 1 after adding one element.");

        theList.addBack(2);
        assertEquals(2, theList.size(), "List should have size 2 after adding another element.");
    }

    @org.junit.jupiter.api.Test
    void sizeAfterRemovingElements() {
        theList.addBack(1);
        theList.addBack(2);
        theList.remove(0); // Assuming remove removes the element at the specified index
        assertEquals(1, theList.size(), "List should have size 1 after removing one element.");

        theList.remove(0);
        assertEquals(0, theList.size(), "List should have size 0 after removing all elements.");
    }

    @org.junit.jupiter.api.Test
    void sizeAfterClearingList() {
        theList.addBack(1);
        theList.addBack(2);
        theList.clear(); // Assuming clear empties the list
        assertEquals(0, theList.size(), "List should have size 0 after being cleared.");
    }


//    @org.junit.jupiter.api.Test
//    void clear()
//    {
//    }


    @org.junit.jupiter.api.Test
    void clearEmptyList() {
        assertEquals(0, theList.size(), "New list should have size 0.");
        theList.clear();
        assertEquals(0, theList.size(), "Clearing an empty list should leave the size as 0.");
    }

    @org.junit.jupiter.api.Test
    void clearNonEmptyList() {
        theList.addBack(1); // Assuming addBack method adds an element
        theList.addBack(2);
        assertEquals(2, theList.size(), "List should have size 2 after adding elements.");

        theList.clear();
        assertEquals(0, theList.size(), "List should have size 0 after clearing.");
    }

    @org.junit.jupiter.api.Test
    void clearAndAddAgain() {
        theList.addBack(1);
        theList.clear();
        assertEquals(0, theList.size(), "List should have size 0 after clearing.");

        theList.addBack(2);
        assertEquals(1, theList.size(), "List should have size 1 after adding an element post-clearing.");
        assertEquals(2, theList.get(0), "Element '2' should be at index 0 after re-adding elements.");
    }

//    @org.junit.jupiter.api.Test
//    void iterator()
//    {
//    }

    @org.junit.jupiter.api.Test
    void iteratorOnEmptyList() {
        Iterator<Integer> it = theList.iterator();
        assertFalse(it.hasNext(), "Iterator should have no next on an empty list.");
    }

    @org.junit.jupiter.api.Test
    void iterateOverElements()
    {
        for (int i = 0; i < 3; i++)
        {
            theList.addBack(i);
        }
        Iterator<Integer> it = theList.iterator();
        for (int i = 0; i < theList.size(); i++)
        {
            assertTrue(it.hasNext(), "Iterator should have a next element at index " + i);
            assertEquals(Integer.valueOf(i), it.next(), "Iterator should return the correct element at index " + i);
        }
        assertFalse(it.hasNext(), "Iterator should have no more elements after the end of the list.");
    }

    @org.junit.jupiter.api.Test
    void nextWithoutHasNext()
    {
        theList.addBack(10);
        Iterator<Integer> it = theList.iterator();
        assertEquals(Integer.valueOf(10), it.next(), "Calling next without hasNext should return first element.");
    }


//    @org.junit.jupiter.api.Test
//    void testToString()
//    {
//
//    }


    @org.junit.jupiter.api.Test
    void toStringEmptyList() {
        assertEquals("[]", theList.toString(), "Empty list should return \"[]\".");
    }

    @org.junit.jupiter.api.Test
    void toStringSingleElementList() {
        theList.addBack(42); // Assuming addBack method adds an element to the list
        assertEquals("[42]", theList.toString(), "List with single element should return \"[42]\".");
    }

    @org.junit.jupiter.api.Test
    void toStringMultipleElementsList() {
        int[] elements = {1, 2, 3, 4, 5};
        for (int elem : elements) {
            theList.addBack(elem); // Assuming addBack method adds elements to the list
        }
        assertEquals("[1, 2, 3, 4, 5]", theList.toString(), "List with multiple elements should return \"[1, 2, 3, 4, 5]\".");
    }
}