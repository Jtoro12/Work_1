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

    public int get(int key) {//metodo similar a buscar
        if (!cache.containsKey(key)) {
            return -1;
        }
        NodoLista nodoLista = cache.buscarNodo(key);
        lista.removeNode(nodoLista);// mover el nodo al principio
        lista.addNode(nodoLista);

        return nodoLista.resultado;
    }

    public void put(int key, int data) {//metodo insertar
        if (cache.containsKey(key)) {
            NodoLista node = cache.buscarNodo(key);
            lista.removeNode(node);
        }

        if (lista.size() >= capacidad) {//remover el nodo menos usado 
            NodoLista lastNode = lista.getLast();
            lista.removeNode(lastNode);
            cache.eliminar(lastNode.clave);
        }

        NodoLista newNode = new NodoLista(key, data);
        lista.addNode(newNode);
        NodoHashing cacheNode = new NodoHashing(newNode, key);
        cache.insertar(cacheNode);
    }

    public void print() {
        System.out.println("Estado Cache");
        cache.print();
        System.out.println("Estado Lista");
        lista.print();
        System.out.println("");
    }

}
