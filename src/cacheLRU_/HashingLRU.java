package cacheLRU_;

public class HashingLRU {
    private NodoHashing[] T;
    private int size;

    public HashingLRU(int tamanio) {
        T = new NodoHashing[tamanio];
        NodoLista node = new NodoLista(0, 0);
        for (int i = 0; i < T.length; i++) {
            T[i] = new NodoHashing(node, 0);
        }
        this.size = 0;
    }

    private int h(int key) {
        return key % T.length;
    }

    private int hi(int hash, int i) {
        return (hash + i) % T.length;
    }

    public void insertar(NodoHashing nodo) {
        if (size >= T.length)
            return; // tabla llena
        int h = h(nodo.clave);
        int i = 0;
        int index;
        while (i < T.length) {
            index = hi(h, i);
            if (T[index] == null) {
                T[index] = nodo;
                size++;
                return;
            }
            i++;
        }
    }

    public boolean containsKey(int clave) {
        int index = h(clave);
        if (T[index] != null) {
            for (NodoHashing nodoHashing : T) {
                if (nodoHashing.nodo.clave == clave) {
                    return true;
                }
            }
        }
        return false;
    }

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
