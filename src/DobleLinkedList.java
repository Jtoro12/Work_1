public class DobleLinkedList {
    private Node head;
    private Node tail;
    // lista doblemente enlazada

    private static class Node {
        String key;
        String data;
        Node next;
        Node prev;

        Node(String key, String data) {
            this.key = key;
            this.data = data;
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertar(String key, String data) {
        Node newNode = new Node(key, data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean buscar(String x) {
        Node auNode = head;
        do {
            if (auNode.data.equals(x)) {
                return true;
            }
            auNode = auNode.next;

        } while (auNode != head);
        return false;
    }

    public void eliminar(Node aux) {
        if (aux == head) {
            head = aux.next;
        } else {
            aux.prev.next = aux.next;
        }
        if (aux == tail) {
            tail = aux.prev;
        } else {
            aux.next.prev = aux.prev;
        }
    }

    public void imprimir() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Node aux = head;
        while (aux != null) {
            System.out.print(aux.data + " ");
            aux = aux.next;
        }
        System.out.println("");
    }

    public void moverFinal(Node nod) {
        if (nod == tail) {
            return;
        }
        if (nod.prev != null) {
            nod.prev.next = nod.next;
        }
        if (nod.next != null) {
            nod.next.prev = nod.prev;
        }
        insertar(nod.key, nod.data);
    }

    public Node eliminarPrimero() {
        Node aux = head;
        if (aux != null) {
            head = aux.next;
            if (head != null) {
                head.prev = null;
                aux.next = null;
            }
        }
        return aux;

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

}
