package cacheLFU_;

public class ListaDobleLFU {
    public NodoLista Cabeza;
    public NodoLista Cola;
    public int size;

    public ListaDobleLFU(){
        this.Cabeza=null;
        this.Cola=null;
        this.size=0;
    }

    public void insertar(NodoLista nodo){
        if (Cabeza==null && Cola==null){
            Cabeza=nodo;
            Cola=Cabeza;
        }else{
            NodoLista current = this.Cabeza;
            Cabeza=nodo;
            Cabeza.next=current;
            current.prev=Cabeza;
        }
        size++;
    }

    public void eliminarCola(){
        if (Cola!=null){
            if (Cabeza==Cola){
                Cabeza=null;
                Cola=null;
            }else{
                Cola=Cola.prev;
                Cola.next=null;
            }
            size--;
        }
    }

    public void eliminar(NodoLista nodo){
        if (nodo==Cabeza && nodo==Cola){
            Cabeza=null;
            Cola=null;
        }else if (nodo==Cabeza){
            Cabeza=nodo.next;
            Cabeza.prev=null;
        }else if (nodo==Cola){
            Cola=Cola.prev;
            Cola.next=null;
        }else {
            nodo.next.prev=nodo.prev;
            nodo.prev.next=nodo.next;
        }
        size--;
    }
}
