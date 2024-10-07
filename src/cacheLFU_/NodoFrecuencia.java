package cacheLFU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class NodoFrecuencia {
    public ListaDobleLFU lista;
    public NodoFrecuencia next;
    public NodoFrecuencia prev;
    int frecuencia;

    public NodoFrecuencia(int frecuencia) {
        this.lista = new ListaDobleLFU();
        this.next = null;
        this.prev = null;
        this.frecuencia = frecuencia;
    }

    public NodoFrecuencia crearFrecuencia(int frecuencia) {
        NodoFrecuencia newFrec = new NodoFrecuencia(frecuencia);
        newFrec.next = this.next;
        if (this.next != null)
            this.next.prev = newFrec;
        this.next = newFrec;
        newFrec.prev = this;
        return newFrec;
    }

    public void eliminarFrecuencia() {
        if (this.next != null)
            this.next.prev = this.prev;
        if (this.prev != null)
            this.prev.next = this.next;
    }
}
