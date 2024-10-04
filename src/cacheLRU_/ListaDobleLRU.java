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

    public void insertar(NodoLista nodo) {
        if (Cabeza == null && Cola == null) {
            Cabeza = nodo;
            Cola = Cabeza;
        } else {
            NodoLista current = this.Cabeza;
            Cabeza = nodo;
            Cabeza.next = current;
            current.prev = Cabeza;
        }
        size++;
    }

    public void eliminarCola() {
        if (Cola != null) {
            if (Cabeza == Cola) {
                Cabeza = null;
                Cola = null;
            } else {
                Cola = Cola.prev;
                Cola.next = null;
            }
            size--;
        }
    }

    public int getLast() {
        NodoLista current = this.Cabeza;
        if (Cabeza == null && Cola == null) {
            return -1;
        }
        while (current.next != null) {
            current = current.next;
        }
        return current.clave;
    }

    public void eliminar(NodoLista nodo) {
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

    public void print() {
        NodoLista nodoCurrent = this.Cabeza;
        while (nodoCurrent != null) {
            System.out.print("(" + nodoCurrent.clave + ";" + nodoCurrent.resultado + ")");
            nodoCurrent = nodoCurrent.next;
        }
    }
}
