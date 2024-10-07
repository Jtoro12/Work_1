package cacheLRU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class HashingLRU {
    private NodoHashing[] T;
    private int size;

    public HashingLRU(int tamanio) {
        T = new NodoHashing[tamanio];
        this.size = 0;
    }

    private int h(int key) {
        return key % T.length;
    }

    private int hi(int hash, int i) {
        return (hash + i) % T.length;
    }

    //Inserta el nodo en la tabla hash
    public void insertar(NodoHashing node) {
        if (size >= T.length) {
            return; // tabla llena
        }
        int h = h(node.clave);
        int i = 0;
        int index;
        while (i < T.length) {
            index = hi(h, i);
            if (T[index] == null) {
                NodoHashing newNodo = new NodoHashing(node.nodo, node.clave);
                T[index] = newNodo;
                size++;
                return;
            }
            i++;
        }
    }


    //Verifica si la clave se encuentra en la tabla hash
    public boolean containsKey(int clave) {
        int index = h(clave);
        if (T[index] != null) {
            for (NodoHashing nodoHashing : T) {
                if (nodoHashing!=null && nodoHashing.nodo.clave == clave) {
                    return true;
                }
            }
        }
        return false;
    }

    //Busca el nodo utilizando la clave y retorna el nodo al que tiene el puntero en la lista enlazada
    public NodoLista buscarNodo(int clave) {
        int h = h(clave);
        int i = 0;
        int index;
        while (i < T.length) {
            index = hi(h, i);
            if (T[index] == null)
                return null;
            if (T[index].clave == clave) {
                return T[index].nodo;
            }
            i++;
        }
        return null;
    }

    //Elimina el nodo de la tabla hash utilizando la clave
    public boolean eliminar(int clave) {
        int h = h(clave);
        int i = 0;
        int index;
        while (i < T.length) {
            index = hi(h, i);
            if (T[index] == null)
                return false;
            if (T[index].clave == clave) {
                NodoHashing current = T[index];
                T[index] = null;
                size--;
                return true;
            }
            i++;
        }
        return false;
    }

    public NodoHashing buscar(int clave) {
        int h = h(clave);
        int i = 0;
        int index;
        while (i < T.length) {
            index = hi(h, i);
            if (T[index] == null)
                return null;
            if (T[index].clave == clave) {
                return T[index];
            }
            i++;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < T.length; i++) {
            if (T[i] != null) {
                System.out.println("Clave: " + T[i].clave + ", Valor: " + T[i].nodo.resultado);
            }
        }
    }
}
