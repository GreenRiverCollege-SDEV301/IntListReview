import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest
{

    @Test
    void addFront()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        String out = "[2]";
        assertEquals(out, theList.toString());
    }

    @Test
    void addBack()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        String out = "[2, 18]";
        assertEquals(out, theList.toString());
    }

    @Test
    void add()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.add(1, 8);
        String out = "[2, 8, 18]";
        assertEquals(out, theList.toString());

    }

    @Test
    void removeFront()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.removeFront();
        String out = "[18]";
        assertEquals(out, theList.toString());
    }

    @Test
    void removeBack()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.removeBack();
        String out = "[2]";
        assertEquals(out, theList.toString());

    }

    @Test
    void remove()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.remove(0);
        String out = "[18]";
        assertEquals(out, theList.toString());
    }

    @Test
    void get()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        int out = 2;
        assertEquals(out, theList.get(0));

    }

    @Test
    void contains()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        assertEquals(true, theList.contains(10));
    }

    @Test
    void indexOf()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        assertEquals(3, theList.indexOf(10));
    }

    @Test
    void isEmpty()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        assertEquals(false, theList.isEmpty());

    }

    @Test
    void size()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        assertEquals(4, theList.size());
    }

    @Test
    void clear()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        theList.clear();
        assertEquals("[]", theList.toString());
    }

    @Test
    void iterator()
    {
    }

    @Test
    void print()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        String out = "[2, 18, 30, 10]";
        theList.print();

    }

    @Test
    void testToString()
    {
        LinkedIntList theList = new LinkedIntList();
        theList.addFront(2);
        theList.addBack(18);
        theList.addBack(30);
        theList.addBack(10);
        String out = "[2, 18, 30, 10]";
        assertEquals(out, theList.toString());
    }
}