package cacheLRU_;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//haceer uno similar 

public class HashingD<K, V> {
    // Tamaño por defecto de la tabla hash
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Nodo<K, V>>[] table;
    private int size;  // Número de elementos almacenados

    // Constructor con tamaño por defecto
    public HashingD() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    // Método hash para calcular el índice en la tabla
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (LinkedList<Nodo<K, V>> bucket : table) {
            if (bucket != null) {
                for (Nodo<K, V> entry : bucket) {
                    keys.add(entry.key);  // Añadir la clave de cada entrada al conjunto
                }
            }
        }
        return keys;  // Retornar el conjunto de claves
    }
    public void put(K key, V value) {
        int index = hash(key);

        // Inicializamos el bucket si no existe
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Nodo<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new Nodo<>(key, value));
        size++;
    }


    public V get(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Nodo<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Nodo<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return true;  // Eliminación exitosa
                }
            }
        }
        return false;  // No se encontró la clave
    }

    public boolean containsKey(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Nodo<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para obtener el tamaño del HashMap
    public int size() {
        return size;
    }

    // Clase interna para almacenar las entradas (pares clave-valor)
    private static class Nodo<K, V> {
        K key;
        V value;

        public Nodo(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}