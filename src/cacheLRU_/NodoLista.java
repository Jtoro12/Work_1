package cacheLRU_;

public class NodoLista {
    NodoLista next;
    NodoLista prev;
    int clave;
    int resultado;

    public NodoLista(int clave, int resultado) {
        this.next = null;
        this.prev = null;
        this.clave = clave;
        this.resultado = resultado;
    }

}
