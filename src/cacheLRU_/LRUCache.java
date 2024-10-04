package cacheLRU_;

public class LRUCache {
    int capacidad;
    HashingLRU cache;
    ListaDobleLRU lista;
    int size;

    public LRUCache(int capacidad) {
        this.capacidad = capacidad;
        this.cache = new HashingLRU(capacidad);
        this.lista = new ListaDobleLRU();
        this.size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        NodoLista nodoLista = cache.buscarNodo(key);
        lista.removeNode(nodoLista);// mover el nodo al principio
        lista.addNode(nodoLista);

        return nodoLista.resultado;
    }

    public void put(int key, int data) {
        if (cache.containsKey(key)) { // cuando la clave existe,entra
            NodoLista node = cache.buscarNodo(key);
            lista.removeNode(node);// lo borra
         } else {
            NodoLista nodoLista = new NodoLista(key, data);
            lista.addNode(nodoLista);
            NodoHashing nodoCache = new NodoHashing(nodoLista, key);
            cache.insertar(nodoCache);
        }

        if (lista.size() > capacidad) {
            NodoLista last = lista.getLast();
            // eliminar el ultimo nodo lista
            lista.removeNode(last);
            // eliminar el nodo del cache
            cache.eliminar(last.clave);
        }
    }

    public void print() {
        System.out.println("Estado Cache");
        cache.print();
        System.out.println("Estado Lista");
        lista.print();
        System.out.println("");
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4,4);
        cache.print();

    }

}
