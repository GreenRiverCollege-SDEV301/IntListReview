import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {
    //Helper methods (creating LinkedIntList's for tests)

    //Create an empty list
    public LinkedIntList getEmptyLinkedIntList() {
        return new LinkedIntList();
    }

    //Create a list with 4 values
    public LinkedIntList getLinkedListWithFourValues() {
        LinkedIntList ll = new LinkedIntList();
        ll.addBack(1);
        ll.addBack(2);
        ll.addBack(3);
        ll.addBack(4);
        return ll;
    }

    @Test
    void addFrontWithEmptyLinkedList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        ll.addFront(1);
        assertEquals(ll.get(0), 1);
    }

    @Test
    void addFrontWithNonEmptyLinkedList() {
        LinkedIntList ll = getLinkedListWithFourValues();
        ll.addFront(0);
        assertEquals(ll.get(0), 0);
    }

    @Test
    void addBackWithEmptyLinkedList() {
        LinkedIntList ll = getEmptyLinkedIntList();
        ll.addBack(1);
        ll.addBack(2);
        assertEquals(ll.get(1), 2);
    }

    @Test
    void addBackWithNonEmptyLinkedList() {
        LinkedIntList ll = getLinkedListWithFourValues();
        ll.addBack(5);
        assertEquals(ll.get(4), 5);
    }

    @Test
    void add() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
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
        LinkedIntList ll = getLinkedListWithFourValues();
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
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }
}