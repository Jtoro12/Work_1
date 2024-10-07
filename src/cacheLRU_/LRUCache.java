package cacheLRU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
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

    //Devuelve el resultado del nodo, ademas si la clave esta presente, en la lista enlazada mueve el nodo al inicio
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        NodoLista nodoLista = cache.buscarNodo(key);
        lista.removeNode(nodoLista);// mover el nodo al principio
        lista.addNode(nodoLista);

        return nodoLista.resultado;
    }

    //Inserta el nodo, si la cache ya esta llena, elimina el ultimo nodo de la lista para poder agregar le nuevo nodo
    public void put(int key, int data) {
        if (cache.containsKey(key)) {
            NodoLista node = cache.buscarNodo(key);
            lista.removeNode(node);
        }

        if (lista.size() >= capacidad) {
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
