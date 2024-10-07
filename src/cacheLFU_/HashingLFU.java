package cacheLFU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class HashingLFU {
    private NodoHashing[] T;
    private int size;

    public HashingLFU(int tamanio) {
        T = new NodoHashing[tamanio];
        this.size = 0;
    }

    private int h(int key) {
        return key % T.length;
    }

    private int hi(int hash, int i) {
        return (hash + i) % T.length;
    }

    public void insertar(NodoHashing nodo) {
        if (size >= T.length) return; //tabla llena
        int h = h(nodo.clave);
        int i = 0;
        while (i < T.length) {
            int index = hi(h, i);
            if (T[index] == null) {
                T[index] = nodo;
                size++;
                return;
            }
            i++;
        }
    }

    //Elimina el nodo del hashing
    public boolean eliminar(int clave) {
        int h = h(clave);
        int i = 0;
        while (i < T.length) {
            int index = hi(h, i);
            if (T[index] == null) return false;
            if (T[index].clave == clave) {
                //NodoHashing current = T[index];
                T[index] = null;
                size--;
                return true;
            }
            i++;
        }
        return false;
    }


    //Retorna el nodo del hashing
    public NodoHashing buscar(int clave) {
        int h = h(clave);
        int i = 0;
        while (i < T.length) {
            int index = hi(h, i);
            if (T[index] == null) return null;
            if (T[index].clave == clave) return T[index];
            i++;
        }
        return null;
    }

    public int size() {
        return size;
    }
}
