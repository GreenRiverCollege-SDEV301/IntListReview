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
    void addWithEmptyLinkedIntListToFront() {
        LinkedIntList ll = getEmptyLinkedIntList();
        ll.add(0, 5);
        assertEquals(ll.get(0), 5);
    }

    @Test
    void addWithEmptyLinkedIntListToMiddle() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> ll.add(1, 5));
    }

    @Test
    void addWithNonEmptyLinkedIntListToFront() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.add(0, 5);
        assertEquals(ll.get(0), 5);
        assertEquals(ll.get(1), 1);
    }

    @Test
    void addWithNonEmptyLinkedIntListToMiddle() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.add(2, 5);
        assertEquals(ll.get(1), 2);
        assertEquals(ll.get(2), 5);
        assertEquals(ll.get(3), 3);
    }

    @Test
    void addWithNonEmptyLinkedIntListToEnd() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.add(4, 10);
        assertEquals(ll.get(3), 4);
        assertEquals(ll.get(4), 10);
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
    void removeFromEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> ll.get(0));
    }

    @Test
    void removeFromEmptyLinkedIntListWithNegativeIndex() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> ll.get(-1));
    }

    @Test
    void removeFromNonEmptyLinkedIntListAtFront() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.remove(0);
        assertEquals(ll.get(0), 2);
    }

    @Test
    void removeFromNonEmptyLinkedIntListAtMiddle() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.remove(2);
        assertEquals(ll.get(1), 2);
        assertEquals(ll.get(2), 4);
    }

    @Test
    void removeFromNonEmptyLinkedIntListAtEnd() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        ll.remove(3);
        assertEquals(ll.get(2), 3);
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
    void containsWithEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertFalse(ll.contains(5));
    }

    @Test
    void containsWithNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        assertTrue(ll.contains(3));
    }

    @Test
    void indexOfWithEmptyLinkedIntList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        assertEquals(ll.indexOf(5), -1);
    }

    @Test
    void indexOfWithNonEmptyLinkedIntList() {
        LinkedIntList ll = getLinkedIntListWithFourValues();
        assertEquals(ll.indexOf(3), 2);
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