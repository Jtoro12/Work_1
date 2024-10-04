package cacheLRU_;

public class LRUCache {
    int capacidad;
    HashingLRU cache;
    ListaDobleLRU lista;
    int size;

    public LRUCache(int capacidad) {
        this.capacidad = capacidad;
        this.cache = new HashingLRU(capacidad);
        this.lista=new ListaDobleLRU();
        this.size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        NodoLista nodoLista = cache.buscarNodo(key);
        lista.eliminar(nodoLista);// mover el nodo al principio
        lista.insertar(nodoLista);

        return nodoLista.resultado;
    }

    public void put(int key, int data) {
        if (cache.containsKey(key)) { // cuando la clave existe,entra
            lista.eliminar(cache.buscarNodo(key));// lo borra
        }
        NodoLista nodoLista = new NodoLista(key, data);
        lista.insertar(nodoLista);
        NodoHashing nodoCache = new NodoHashing(nodoLista, key);
        cache.insertar(nodoCache);// cambia algo del nodo existente

        if (cache.size() > capacidad) {
            int clave = lista.getLast();
            // eliminar el ultimo nodo lista
            lista.eliminarCola();
            // eliminar el nodo del cache
            cache.eliminar(clave);
        }
    }



    public void print(){
        System.out.println("Estado Cache");
        cache.print();
        System.out.println("Estado Lista");
        lista.print();
        System.out.println("");
    }

}
