package cacheLFU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class NodoHashing {
    NodoLista nodo;
    int clave;

    public NodoHashing(NodoLista nodo, int clave) {
        this.nodo = nodo;
        this.clave = clave;
    }
}
