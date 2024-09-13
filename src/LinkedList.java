public class LinkedList {
    private Node head;
    private Node tail;
    // lista doblemente enlazada

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertar(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean buscar(int x) {
        Node auNode = head;
        do {
            if (auNode.data == x) {
                return true;
            }
            auNode = auNode.next;

        } while (auNode != head);
        return false;
    }

    public boolean eliminar(int index) {
        if (index < 1) {
            System.out.println("valor no identificado");
            return false;
        }
        if (index == 1 && head.next == null) {
            head = null;
            tail = null;
            return true;
        } else if (index == 1) {
            head=head.next;
            return true;
        } else {
            Node aux = head;
            Node prev = null;
            for (int i = 1; i < index; i++) {
                prev = aux;
                aux = aux.next;

            }
            prev.next = aux.next;
            aux = null;
        }
        return true;
    }

    public int size() {
        int count = 1;
        Node aux = head;
        while (aux != tail) {
            count++;
            aux = aux.next;
        }
        return count;
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

    

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }


}

    
