package cacheLRU_;

import java.math.BigInteger;

/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class NodoLista {
    NodoLista next;
    NodoLista prev;
    int clave;
    BigInteger resultado;

    public NodoLista(int clave, BigInteger resultado) {
        this.next = null;
        this.prev = null;
        this.clave = clave;
        this.resultado = resultado;
    }

}
