import java.util.LinkedList;

public class HashingEncadenado {

    private static final int size = 10;
    private LinkedList<Elements>[] table;

    public HashingEncadenado() {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<Elements>();
        }
    }

    /*
     * mod de la funcion hash para que acepte String en key
     * private int hash(String key) {
     * return Math.abs(key.hashCode()) % size;
     * 
     * }/*
     */

    private int hash(int key) {
        return key % size;
    }

    public void insertar(int keyData) {
        int index = hash(keyData);
        Elements elem = new Elements((index), keyData);
        table[index].add(elem);// insertar con Elements <key, data>
    }

    public boolean buscar(int keyData) {
        int index = hash(keyData);
        if (table[index].isEmpty()) {
            return false;
        }
        for (Elements element : table[index]) {
            if (element.data==(keyData)) {
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int keyData) {
        int index = hash(keyData);
        if (table[index].isEmpty()) {
            return false;
        }
        for (Elements element : table[index]) {
            if (element.data==(keyData)) {
                table[index].remove(element);
                return true;
            }
        }
        return false;
    }

    
    public void imprimir() {
        for (int i = 0; i < size; i++) {
            if (table[i].isEmpty()) {
                System.out.println("bloque " + i + " null");
            } else {
                System.out.print("bloque " + i + ": ");
                for (Elements element : table[i]) {
                    System.out.print(element.data);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
    
    //hashing debe aceptar clave, elemento <int,int>
    public class Elements {
        int key;
        int data;

        public Elements(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public int getKey() {
            return key;
        }

        public int getData() {
            return data;
        }
    }

}
