import java.util.HashMap;

class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    private final int capacity;
    private final HashMap<Integer,Node> cache ;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0, 0);  // Nodo ficticio al principio
        tail = new Node(0, 0);  // Nodo ficticio al final
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        // Añadir nodo justo después de head
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        // Remover el nodo de la lista
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        removeNode(node);  // Mover el nodo al principio
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {// Cuando la clave existe entra
            removeNode(cache.get(key));//lo borrra
        }
        Node node = new Node(key, value);
        addNode(node);
        cache.put(key, node);//cambia la el nodo de la clave existente

        if (cache.size() > capacity) {
            // Eliminar el último nodo
            Node lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }
    public void print() {
        System.out.println("Estado actual de la cache:");
        System.out.println("Tabla Hash:");
        for (Integer key : cache.keySet()) {
            System.out.println("Clave: " + key + ", Valor: " + cache.get(key).getValue());
        }

        System.out.println("Lista doblemente enlazada   :");
        Node current = head.next;
        while (current != tail) {
            System.out.print("(" + current.key + ":" + current.value + ") ");
            current = current.next;
        }
        System.out.println("\n----------------------------");
    }
}
