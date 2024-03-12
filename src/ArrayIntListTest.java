import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ArrayIntListTest {
    @Test
    void addFrontEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        assertEquals(1, list.size());
        assertEquals("[1]", list.toString());
    }

    @Test
    void addFrontMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        list.addFront(2);
        assertEquals(2, list.size());
        assertEquals("[2, 1]", list.toString());
    }

    @Test
    void addBack() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(42);
        String out = theList.toString();
        assertEquals("[42]", out);
    }
    @Test
    void addBackWithNonEmptyList() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(3);
        theList.addBack(96);
        theList.addBack(1);
        theList.addBack(42);
        String out = theList.toString();
        assertEquals("[3, 96, 1, 42]", out);
    }
    @Test
    void addBackWithResize() {
        ArrayIntList theList = new ArrayIntList();
        theList.addBack(3);
        theList.addBack(96);
        theList.addBack(1);
        theList.addBack(42);
        theList.addBack(3);
        theList.addBack(96);
        theList.addBack(1);
        theList.addBack(42);
        theList.addBack(3);
        theList.addBack(96);
        theList.addBack(1);
        theList.addBack(42);
        String out = theList.toString();
        assertEquals("[3, 96, 1, 42, 3, 96, 1, 42, 3, 96, 1, 42]", out);
    }
    @Test
    void addBackLargeAmount() {
        ArrayIntList theList = new ArrayIntList();
        for (int i = 0; i < 1000000; i++) {
            theList.addBack(i);
        }
        assertEquals(theList.size(), 1000000);
    }

    @Test
    void addToEmpty() {
        ArrayIntList empty = new ArrayIntList();
        empty.add(0, 1);
        assertEquals(empty.size(), 1);
    }

    @Test
    void addToSingle() {
        ArrayIntList list = new ArrayIntList();
        list.add(0,1);
        list.add(0,2);
        String out = list.toString();
        assertEquals(out,"[2, 1]");
    }

    @Test
    void addToMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        list.addFront(2);
        list.addFront(4);
        list.add(1, 3);
        assertEquals("[4, 3, 2, 1]", list.toString());
    }

    @Test
    void addToEndSingle() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.add(1, 2);
        assertEquals(2, list.size());
    }

    @Test
    void addToEndMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
    }


    @Test
    void removeFrontEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeFront());
    }

    @Test
    void removeFrontSingle() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.removeFront();
        assertEquals(0, list.size());
    }

    @Test
    void removeFrontMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        list.removeFront();
        assertEquals(2, list.size());
        assertEquals("[2, 3]", list.toString());
        list.removeFront();
        assertEquals(1, list.size());
        assertEquals("[3]", list.toString());
    }

    @Test
    void removeBackEmpty() {
        ArrayIntList empty = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class,
                () -> empty.removeBack());
    }
// const function = () => {console.log("45")}
// function print() {console.log("45")}
    @Test
    void removeBackSingle() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        assertEquals(list.size(), 1);
        list.removeBack();
        assertEquals(list.size(), 0);
    }

    @Test
    void removeBackMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        list.removeBack();
        list.removeBack();
        list.removeBack();


        assertEquals(0, list.size());
    }

    @Test
    void removeEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void removeSingle() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(1);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void removeMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals("[1, 3]", list.toString());
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("[3]", list.toString());
    }

    @Test
    void getEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void getSingle() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertEquals(1, list.get(0));
    }

    @Test
    void getMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        assertEquals(3, list.get(2));
        assertEquals(2, list.get(1));
    }


    @Test
    void containsEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertFalse(list.contains(1));
    }

    @Test
    void containsFull() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertTrue(list.contains(1));
    }

    @Test
    void notContains() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertFalse(list.contains(2));
    }

    @Test
    void indexOfEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(-1, list.indexOf(1));
    }

    @Test
    void indexOfSingle() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertEquals(0, list.indexOf(1));
    }

    @Test
    void indexOfMultiple() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    void isEmptyTrue() {
        ArrayIntList list = new ArrayIntList();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void sizeEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(0, list.size());
    }

    @Test
    void sizeNotEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertEquals(1, list.size());
    }

    @Test
    void clear() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        list.clear();
        assertEquals("[]", list.toString());
    }

    @Test
    void testToString() {
        ArrayIntList list = new ArrayIntList();
        assertEquals("[]", list.toString());
        list.addBack(1);
        assertEquals("[1]", list.toString());
    }

    @Test
    void testIteratorEmpty() {
        ArrayIntList empty = new ArrayIntList();
    }
}
