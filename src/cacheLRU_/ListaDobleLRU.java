package cacheLRU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class ListaDobleLRU {
    public NodoLista Cabeza;
    public NodoLista Cola;
    public int size;

    public ListaDobleLRU() {
        this.Cabeza = null;
        this.Cola = null;
        this.size = 0;
    }

    //Inserta el nodo al inicio de la lista
    public void addNode(NodoLista node) {
        if (Cabeza == null) {
            Cabeza = node;
            Cola = node;
        } else {
            node.next = Cabeza;
            Cabeza.prev = node;
            Cabeza = node;
        }
        size++;
    }

    //Elimina un nodo de la lista
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

    //Devuelve el ultimo nodo de la lista(Cola)
    public NodoLista getLast() {
        return Cola;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        NodoLista nodoCurrent = this.Cabeza;
        while (nodoCurrent != null) {
            System.out.print("(K:" + nodoCurrent.clave + "; V:" + nodoCurrent.resultado + ")");
            nodoCurrent = nodoCurrent.next;
        }
        System.out.println("");
    }

}
