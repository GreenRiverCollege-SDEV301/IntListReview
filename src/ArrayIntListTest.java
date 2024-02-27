import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    @Test
    void addEmptyFront()
    {
        // List of one
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addFront(-42);
        String out = testList1.toString();
        assertEquals(out, "[-42]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.addFront(0);
        out = testList2.toString();
        assertEquals(out, "[0]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.addFront(420000);
        out = testList3.toString();
        assertEquals(out, "[420000]");
    }
    // List of one
    @Test
    void addToListOfOneFront()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addFront(0);
        testList1.addFront(-42);
        String out = testList1.toString();
        assertEquals(out, "[-42, 0]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.addFront(0);
        testList2.addFront(0);
        out = testList2.toString();
        assertEquals(out, "[0, 0]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.addFront(0);
        testList3.addFront(420000);
        out = testList3.toString();
        assertEquals(out, "[420000, 0]");
    }
    // List of large
    @Test
    void addToListOfManyFront()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addFront(0);
        testList1.addFront(-42);
        testList1.addFront(-51);
        testList1.addFront(-41);
        testList1.addFront(-31);
        testList1.addFront(-21);
        testList1.addFront(-11);
        testList1.addFront(-1);
        testList1.addFront(0);
        testList1.addFront(1);
        testList1.addFront(11);
        testList1.addFront(21);
        testList1.addFront(31);
        testList1.addFront(41);
        testList1.addFront(51);
        testList1.addFront(61);
        testList1.addFront(71);
        testList1.addFront(81);
        testList1.addFront(91);
        testList1.addFront(101);
        testList1.addFront(1000);
        testList1.addFront(10000);
        testList1.addFront(100000);
        testList1.addFront(1000000);
        testList1.addFront(10000000);
        String out = testList1.toString();
        assertEquals(out, "[10000000, 1000000, 100000, 10000, 1000, 101, 91, 81, 71, 61, 51, 41, 31, 21, 11, 1, 0, -1, -11, -21, -31, -41, -51, -42, 0]");
    }

    @Test
    void addEmptyBack()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(-42);
        String out = testList1.toString();
        assertEquals(out, "[-42]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.addBack(0);
        out = testList2.toString();
        assertEquals(out, "[0]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.addBack(420000);
        out = testList3.toString();
        assertEquals(out, "[420000]");
    }

    @Test
    void addToListOfOneBack()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        String out = testList1.toString();
        assertEquals(out, "[0, -42]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.addBack(0);
        testList2.addBack(0);
        out = testList2.toString();
        assertEquals(out, "[0, 0]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.addBack(0);
        testList3.addBack(420000);
        out = testList3.toString();
        assertEquals(out, "[0, 420000]");
    }
    @Test
    void addToListOfManyBack() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
    }

    @Test
    void addToEmpty() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.add(0,-42);
        String out = testList1.toString();
        assertEquals(out, "[-42]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.add(0,0);
        out = testList2.toString();
        assertEquals(out, "[0]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.add(0,420000);
        out = testList3.toString();
        assertEquals(out, "[420000]");
    }

    @Test
    void removeFrontEmptyList() {
        ArrayIntList testList1 = new ArrayIntList();
        try
        {
            testList1.removeFront();
        }
        catch(Exception e)
        {
            assertEquals(e.getClass(), IndexOutOfBoundsException.class);
            assertEquals(e.getMessage(), "Attempt to remove from empty arrayList.");
        }
    }
    @Test
    void removeFrontListOfOne() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.add(0,-42);
        testList1.removeFront();
        String out = testList1.toString();
        assertEquals(out, "[]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.add(0,0);
        testList2.removeFront();
        out = testList2.toString();
        assertEquals(out, "[]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.add(0,420000);
        testList3.removeFront();
        out = testList3.toString();
        assertEquals(out, "[]");

    }
    @Test
    void removeFrontLargeList() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        testList1.removeFront();
        String out = testList1.toString();
        assertEquals(out, "[-42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
    }

    @Test
    void removeBackEmptyList()
    {
        ArrayIntList testList1 = new ArrayIntList();
        try
        {
            testList1.removeBack();
        }
        catch(Exception e)
        {
            assertEquals(e.getClass(), IndexOutOfBoundsException.class);
            assertEquals(e.getMessage(), "Attempt to remove from empty arrayList.");
        }
    }
    @Test
    void removeBackListOfOne()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.add(0,-42);
        testList1.removeBack();
        String out = testList1.toString();
        assertEquals(out, "[]");

        ArrayIntList testList2 = new ArrayIntList();
        testList2.add(0,0);
        testList2.removeBack();
        out = testList2.toString();
        assertEquals(out, "[]");

        ArrayIntList testList3 = new ArrayIntList();
        testList3.add(0,420000);
        testList3.removeBack();
        out = testList3.toString();
        assertEquals(out, "[]");

    }
    @Test
    void removeBackLargeList()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        testList1.removeBack();
        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000]");
    }

    @Test
    void remove()
    {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        assertEquals(0, testList1.remove(0));
        String out = testList1.toString();
        assertEquals(out, "[-42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");

        assertEquals(10000000, testList1.remove(23));
        out = testList1.toString();
        assertEquals(out, "[-42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000]");

        assertEquals(21, testList1.remove(10));
        out = testList1.toString();
        assertEquals(out, "[-42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000]");
    }

    @Test
    void get() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        assertEquals(0, testList1.get(0));
        assertEquals(10000000, testList1.get(24));
        assertEquals(-11, testList1.get(6));
        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
    }

    @Test
    void contains() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        assertTrue(testList1.contains(0));
        assertFalse(testList1.contains(24));
        assertTrue(testList1.contains(-31));
        assertTrue(testList1.contains(10000000));

        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
    }

    @Test
    void indexOf() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        assertEquals(0, testList1.indexOf(0));
        assertEquals(-1, testList1.indexOf(24));
        assertEquals(4, testList1.indexOf(-31));
        assertEquals(24, testList1.indexOf(10000000));

        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
    }

    @Test
    void isEmpty() {
        ArrayIntList testList1 = new ArrayIntList();
        assertTrue(testList1.isEmpty());
        testList1.add(0,-42);
        assertFalse(testList1.isEmpty());
        testList1.removeBack();
        assertTrue(testList1.isEmpty());
        String out = testList1.toString();
        assertEquals(out, "[]");

        ArrayIntList testList2 = new ArrayIntList();
        assertTrue(testList2.isEmpty());
        testList2.add(0,-42);
        assertFalse(testList2.isEmpty());
        testList2.removeFront();
        assertTrue(testList2.isEmpty());
        out = testList2.toString();
        assertEquals(out, "[]");
    }

    @Test
    void size() {
        ArrayIntList testList1 = new ArrayIntList();
        assertEquals(0, testList1.size());
        testList1.addBack(0);
        assertEquals(1, testList1.size());
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        assertEquals(25, testList1.size());

        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
        testList1.clear();
        assertEquals(0, testList1.size());
    }

    @Test
    void clear() {
        ArrayIntList testList1 = new ArrayIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        testList1.addBack(-51);
        testList1.addBack(-41);
        testList1.addBack(-31);
        testList1.addBack(-21);
        testList1.addBack(-11);
        testList1.addBack(-1);
        testList1.addBack(0);
        testList1.addBack(1);
        testList1.addBack(11);
        testList1.addBack(21);
        testList1.addBack(31);
        testList1.addBack(41);
        testList1.addBack(51);
        testList1.addBack(61);
        testList1.addBack(71);
        testList1.addBack(81);
        testList1.addBack(91);
        testList1.addBack(101);
        testList1.addBack(1000);
        testList1.addBack(10000);
        testList1.addBack(100000);
        testList1.addBack(1000000);
        testList1.addBack(10000000);
        testList1.clear();

        String out = testList1.toString();
        assertEquals(out, "[]");
    }
}