class CustomHashMap {
    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    private Node[] map;
    private int capacity = 1000;
    public CustomHashMap() {
        map = new Node[capacity];
    }
    private int hash(int key) {
        return key % capacity;
    }
    public void put(int key, int value) {
        int index = hash(key);
        Node node = new Node(key, value);
        if (map[index] == null) {
            map[index] = node;
        } else {
            Node current = map[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = node;
        }
    }
    public int get(int key) {
        int index = hash(key);
        Node current = map[index];
        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return -1; 
    }
    public void remove(int key) {
        int index = hash(key);
        Node current = map[index];
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    map[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(1001, 30);
        System.out.println(map.get(1));  
        System.out.println(map.get(2));  
        System.out.println(map.get(1001));
        map.remove(2);
        System.out.println(map.get(2));  
    }
}
