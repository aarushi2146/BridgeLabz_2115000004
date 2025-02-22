import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }
    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }
    public int getSize(List<Integer> list) {
        return list.size();
    }
}
class ListManagerTest {
    ListManager listManager = new ListManager();
    List<Integer> list = new ArrayList<>();
    @Test
    void testAddElement() {
        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list));
        assertTrue(list.contains(5));
    }
    @Test
    void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.removeElement(list, 10);
        assertEquals(0, listManager.getSize(list));
        assertFalse(list.contains(10));
    }
    @Test
    void testGetSize() {
        listManager.addElement(list, 1);
        listManager.addElement(list, 2);
        listManager.addElement(list, 3);
        assertEquals(3, listManager.getSize(list));
    }
}