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

    public void removeNode(NodoLista node) {
        NodoLista prev=node.prev;
        NodoLista next=node.next;
        prev.next=next;
        next.prev=prev;
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

    public int size(){
        return this.size;
    }

    public void print() {
        NodoLista nodoCurrent = this.Cabeza;
        while (nodoCurrent != null) {
            System.out.print("(" + nodoCurrent.clave + ";" + nodoCurrent.resultado + ")");
            nodoCurrent = nodoCurrent.next;
        }
    }

}
