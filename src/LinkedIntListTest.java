import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {
    //Helper methods (creating LinkedIntList's for tests)

    //Create an empty list
    public LinkedIntList getEmptyLinkedIntList() {
        return new LinkedIntList();
    }

    //Create a list with 4 values
    public LinkedIntList getLinkedIntListWithFourValues() {
        LinkedIntList ll = new LinkedIntList();
        ll.addBack(1);
        ll.addBack(2);
        ll.addBack(3);
        ll.addBack(4);
        return ll;
    }

    @Test
    void addFrontWithEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        ll.addFront(1);
        assertEquals(ll.get(0), 1);
    }

    @Test
    void addFrontWithNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.addFront(0);
        assertEquals(ll.get(0), 0);
    }

    @Test
    void addBackWithEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        ll.addBack(1);
        ll.addBack(2);
        assertEquals(ll.get(1), 2);
    }

    @Test
    void addBackWithNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.addBack(5);
        assertEquals(ll.get(4), 5);
    }

    @Test
    void add() {
    }

    @Test
    void removeFrontFromEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertThrows(IllegalStateException.class, ll::removeFront);
    }

    @Test
    void removeFrontFromNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.removeFront();
        assertEquals(ll.get(0), 2);
    }

    @Test
    void removeBackFromEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertThrows(IllegalStateException.class, ll::removeBack);
    }

    @Test
    void removeBackFromNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.removeBack();

        LinkedIntList.Node currentNode = ll.head;
        //Get the last node that has data
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        assertEquals(currentNode.data, 3);
    }

    @Test
    void remove() {
    }

    @Test
    void getDataFromEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> ll.get(0));
    }

    @Test
    void getDataFromNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        assertEquals(ll.get(0), 1);
        assertEquals(ll.get(1), 2);
        assertEquals(ll.get(3), 4);
        assertThrows(IndexOutOfBoundsException.class, () -> ll.get(4));
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void isEmptyWithEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertTrue(ll.isEmpty());
    }

    @Test
    void isEmptyWithNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        assertFalse(ll.isEmpty());
    }

    @Test
    void sizeWithEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertEquals(ll.size(), 0);
    }

    @Test
    void sizeWithNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        assertEquals(ll.size(), 4);
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }
}