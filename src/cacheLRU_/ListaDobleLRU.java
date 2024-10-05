package cacheLRU_;

public class ListaDobleLRU {
    public NodoLista Cabeza;
    public NodoLista Cola;
    public int size;

    public ListaDobleLRU() {
        this.Cabeza = null;
        this.Cola = null;
        this.size = 0;
    }

    public void addNode(NodoLista node) {
        if (Cabeza == null) {
            Cabeza = node;
            Cola = node;
        } else {
            node.next = Cabeza;
            Cabeza.prev = node;
            Cabeza = node;
        }
    }

    public void removeNode(NodoLista nodo) {
        if (nodo == Cabeza && nodo == Cola) {
            Cabeza = null;
            Cola = null;
        } else if (nodo == Cabeza) {
            Cabeza = nodo.next;
            Cabeza.prev = null;
        } else if (nodo == Cola) {
            Cola = Cola.prev;
            Cola.next = null;
        } else {
            nodo.next.prev = nodo.prev;
            nodo.prev.next = nodo.next;
        }
        size--;
    }

    public NodoLista getLast() {
        NodoLista current = this.Cabeza;
        if (Cabeza == null && Cola == null) {
            return null;
        }
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        int cont = 0;
        NodoLista current = this.Cabeza;
        while (current != null) {
            cont++;
            current = current.next;

        }
        return cont;
    }

    public void print() {
        NodoLista nodoCurrent = this.Cabeza;
        while (nodoCurrent != null) {
            System.out.print("(" + nodoCurrent.clave + ";" + nodoCurrent.resultado + ")");
            nodoCurrent = nodoCurrent.next;
        }
        System.out.println("");
    }

}
