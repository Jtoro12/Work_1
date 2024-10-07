package cacheLFU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class CacheLFU {
    HashingLFU tabla;
    NodoFrecuencia listaFrec;
    int tamanio;

    public CacheLFU(int tamanio) {
        this.tamanio = tamanio;
        this.tabla = new HashingLFU(tamanio);
        this.listaFrec = new NodoFrecuencia(0);
    }

    //Retorna el resultado del fibonnci en la cache
    public int get(int clave) {
        NodoHashing nodo = tabla.buscar(clave);
        if (nodo == null)
            return -1;
        NodoLista current = nodo.nodo;
        aumentarFrec(current);
        return current.resultado;
    }


    //Inserta la clave y el resultado del fibonacci
    public void put(int clave, int resultado) {
        if (tamanio == 0) return;
        NodoHashing nodo = tabla.buscar(clave);
        if (nodo != null) {
            NodoLista current = nodo.nodo;
            current.resultado = resultado;
            aumentarFrec(current);
        } else {
            if (tabla.size() >= tamanio)
                eliminarMinNodo();
            NodoLista current = new NodoLista(clave, resultado);
            NodoHashing nodoHash = new NodoHashing(current, clave);
            //si es la primera frecuencia en insertar o si la lista de frecuencia no es 1
            if (listaFrec.next == null || listaFrec.next.frecuencia != 1) {
                NodoFrecuencia nodoFrec = new NodoFrecuencia(1);
                nodoFrec.next = listaFrec.next;
                if (listaFrec.next != null)
                    listaFrec.next.prev = nodoFrec;
                listaFrec.next = nodoFrec;
                nodoFrec.prev = listaFrec;
            }
            listaFrec.next.lista.insertar(current);
            current.frecPadre = listaFrec.next;
            tabla.insertar(nodoHash);
        }
    }

    //Aumenta la frecuencia del nodo del resultado de fibonacci
    private void aumentarFrec(NodoLista nodo) {
        if (nodo == null || nodo.frecPadre == null) return;
        NodoFrecuencia current = nodo.frecPadre;
        NodoFrecuencia siguiente = current.next;

        current.lista.eliminar(nodo);
        if (current.lista.size == 0)
            current.eliminarFrecuencia(); //si la frecuencia esta vacia, se elimina el nodo de frecuencia

        if (siguiente == null || siguiente.frecuencia != current.frecuencia + 1) //si la siguiente frecuencia es null o no es current+1, entonces crea una nueva frecuencia
            siguiente = current.crearFrecuencia(current.frecuencia + 1);

        siguiente.lista.insertar(nodo);
        nodo.frecPadre = siguiente;
    }

    //Elimina el ultimo nodo de la primera frecuencia
    private void eliminarMinNodo() {
        if (listaFrec.next == null) return;
        NodoFrecuencia menor = listaFrec.next;
        NodoLista nodo = menor.lista.Cola;
        menor.lista.eliminar(nodo);
        tabla.eliminar(nodo.clave);
        if (menor.lista.size == 0)
            menor.eliminarFrecuencia();
    }
}
