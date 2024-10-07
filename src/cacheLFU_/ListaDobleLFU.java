package cacheLFU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class ListaDobleLFU {
    public NodoLista Cabeza;
    public NodoLista Cola;
    public int size;

    public ListaDobleLFU() {
        this.Cabeza = null;
        this.Cola = null;
        this.size = 0;
    }

    public void insertar(NodoLista nodo) {
        if (nodo == null) return;
        if (Cabeza == null && Cola == null) {
            Cabeza = nodo;
            Cola = Cabeza;
        } else {
            nodo.next = Cabeza;
            Cabeza.prev = nodo;
            Cabeza = nodo;
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

    public void eliminar(NodoLista nodo) {
        if (nodo == null) return;
        if (nodo == Cabeza && nodo == Cola) {
            Cabeza = null;
            Cola = null;
        } else if (nodo == Cabeza) {
            Cabeza = nodo.next;
            if (Cabeza != null) Cabeza.prev = null;
        } else if (nodo == Cola) {
            Cola = Cola.prev;
            if (Cola != null) Cola.next = null;
        } else {
            nodo.next.prev = nodo.prev;
            nodo.prev.next = nodo.next;
        }
        size--;
    }

    public void print() {
        NodoLista current = Cabeza;
        while (current != null) {
            System.out.println("[" + current.clave + "," + current.resultado + "]");
            current = current.next;
        }
    }
}
