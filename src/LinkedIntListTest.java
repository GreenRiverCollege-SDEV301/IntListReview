import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    // List of zero
    @Test
    void addEmptyFront()
    {
        // List of one
        LinkedIntList testList1 = new LinkedIntList();
        testList1.addFront(-42);
        String out = testList1.toString();
        assertEquals(out, "[-42]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.addFront(0);
        out = testList2.toString();
        assertEquals(out, "[0]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.addFront(420000);
        out = testList3.toString();
        assertEquals(out, "[420000]");
    }
    // List of one
    @Test
    void addToListOfOneFront()
    {
        LinkedIntList testList1 = new LinkedIntList();
        testList1.addFront(0);
        testList1.addFront(-42);
        String out = testList1.toString();
        assertEquals(out, "[-42, 0]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.addFront(0);
        testList2.addFront(0);
        out = testList2.toString();
        assertEquals(out, "[0, 0]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.addFront(0);
        testList3.addFront(420000);
        out = testList3.toString();
        assertEquals(out, "[420000, 0]");
    }
    // List of large
    @Test
    void addToListOfManyFront()
    {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
        testList1.addBack(-42);
        String out = testList1.toString();
        assertEquals(out, "[-42]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.addBack(0);
        out = testList2.toString();
        assertEquals(out, "[0]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.addBack(420000);
        out = testList3.toString();
        assertEquals(out, "[420000]");
    }

    @Test
    void addToListOfOneBack()
    {
        LinkedIntList testList1 = new LinkedIntList();
        testList1.addBack(0);
        testList1.addBack(-42);
        String out = testList1.toString();
        assertEquals(out, "[0, -42]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.addBack(0);
        testList2.addBack(0);
        out = testList2.toString();
        assertEquals(out, "[0, 0]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.addBack(0);
        testList3.addBack(420000);
        out = testList3.toString();
        assertEquals(out, "[0, 420000]");
    }
    @Test
    void addToListOfManyBack() {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
        testList1.add(0,-42);
        String out = testList1.toString();
        assertEquals(out, "[-42]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.add(0,0);
        out = testList2.toString();
        assertEquals(out, "[0]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.add(0,420000);
        out = testList3.toString();
        assertEquals(out, "[420000]");
    }

    @Test
    void removeFrontEmptyList() {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
        testList1.add(0,-42);
        testList1.removeFront();
        String out = testList1.toString();
        assertEquals(out, "[]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.add(0,0);
        testList2.removeFront();
        out = testList2.toString();
        assertEquals(out, "[]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.add(0,420000);
        testList3.removeFront();
        out = testList3.toString();
        assertEquals(out, "[]");

    }
    @Test
    void removeFrontLargeList() {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
        testList1.add(0,-42);
        testList1.removeBack();
        String out = testList1.toString();
        assertEquals(out, "[]");

        LinkedIntList testList2 = new LinkedIntList();
        testList2.add(0,0);
        testList2.removeBack();
        out = testList2.toString();
        assertEquals(out, "[]");

        LinkedIntList testList3 = new LinkedIntList();
        testList3.add(0,420000);
        testList3.removeBack();
        out = testList3.toString();
        assertEquals(out, "[]");

    }
    @Test
    void removeBackLargeList()
    {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
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
        assertEquals(true, testList1.contains(0));
        assertEquals(false, testList1.contains(24));
        assertEquals(true, testList1.contains(-31));
        assertEquals(true, testList1.contains(10000000));

        String out = testList1.toString();
        assertEquals(out, "[0, -42, -51, -41, -31, -21, -11, -1, 0, 1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 1000, 10000, 100000, 1000000, 10000000]");
    }

    @Test
    void indexOf() {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
        assertEquals(true, testList1.isEmpty());
        testList1.add(0,-42);
        assertEquals(false, testList1.isEmpty());
        testList1.removeBack();
        assertEquals(true, testList1.isEmpty());
        String out = testList1.toString();
        assertEquals(out, "[]");

        LinkedIntList testList2 = new LinkedIntList();
        assertEquals(true, testList2.isEmpty());
        testList2.add(0,-42);
        assertEquals(false, testList2.isEmpty());
        testList2.removeFront();
        assertEquals(true, testList2.isEmpty());
        out = testList2.toString();
        assertEquals(out, "[]");
    }

    @Test
    void size() {
        LinkedIntList testList1 = new LinkedIntList();
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
        LinkedIntList testList1 = new LinkedIntList();
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