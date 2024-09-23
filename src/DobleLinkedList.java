public class DobleLinkedList {
    private Node head;
    private Node tail;
    // lista doblemente enlazada

    public static class Node {
        int key;
        int data;
        Node next;
        Node prev;

        Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertar(int key, int data) {
        Node newNode = new Node(key, data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head;
            head = newNode;
        }
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
        nod.prev=tail;
        nod.next=null;
        tail.next=nod;
        tail=nod;
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

    public boolean buscarLista(int x) {
        Node auNode = head;
        do {
            if (auNode.data == (x)) {
                return true;
            }
            auNode = auNode.next;

        } while (auNode != head);
        return false;
    }

    public Node buscarNodo(int x) {
        if (head == null) {
            return null; // lista vacía
        }
        Node auNode = head;
        do {
            if (auNode == null) {
                break; // salir del bucle si auNode es null
            }
            if (auNode.data == x) {
                return auNode;
            }
            auNode = auNode.next;
        } while (auNode != head);
        return null; // no se encontró el nodo
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
            System.out.print("<K:"+aux.key+", D:"+aux.data + ">");
            aux = aux.next;
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

}
