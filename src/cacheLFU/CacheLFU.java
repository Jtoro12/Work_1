package cacheLFU;

public class CacheLFU {
    HashingLFU tabla;
    NodoFrecuencia listaFrec;
    int tamanio;

    public CacheLFU(int tamanio){
        this.tamanio=tamanio;
        this.tabla= new HashingLFU(tamanio);
        this.listaFrec= new NodoFrecuencia(0);
    }

    public int get(int clave){
        NodoHashing nodo = tabla.buscar(clave);
        if (nodo==null)
            return -1;
        NodoLista current = nodo.nodo;
        aumentarFrec(current);
        return current.resultado;
    }

    public void insertar(int clave, int resultado){
        if (tamanio==0) return;
        NodoHashing nodo = tabla.buscar(clave);
        if (nodo!=null){

        }
    }


    private void aumentarFrec(NodoLista nodo){
        NodoFrecuencia current = nodo.frecPadre;
        NodoFrecuencia siguiente = current.next;
        current.lista.eliminar(nodo);
        if (current.lista.size==0) eliminarFrec(current); //si la frecuencia esta vacia, se elimina el nodo de frecuencia
        if (siguiente==null || siguiente.frecuencia!=current.frecuencia+1){
            NodoFrecuencia newFrec = new NodoFrecuencia(current.frecuencia+1);
            newFrec.next=siguiente;
            if (siguiente!=null)
                siguiente.prev=newFrec;
            newFrec.prev=current;
            current.next=newFrec;
            siguiente=newFrec;
        }
        siguiente.lista.insertar(nodo);
        nodo.frecPadre=siguiente;
    }
    private void eliminarFrec(NodoFrecuencia nodo){
        if (nodo.next!=null)
            nodo.next.prev=nodo.prev;
        if (nodo.prev!=null)
            nodo.prev.next=nodo.next;
    }

}
