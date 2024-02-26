import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {
    //Helper methods (creating LinkedIntList's for tests)

    //Create an empty list
    public LinkedIntList getEmptyLinkedList() {
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
    }

    @Test
    void addFrontWithNonEmptyLinkedList() {

    }

    @Test
    void addBackWithEmptyLinkedList() {
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
    void get() {
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