package cacheLRU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
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
