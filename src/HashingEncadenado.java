import java.util.LinkedList;

public class HashingEncadenado {

    private int size;
    private LinkedList<Node>[] table;

    public HashingEncadenado(int size) {
        this.size=size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<Node>();
        }
    }


    private int hash(int key) {
        return key % size;
    }

    public boolean insert(int keyData) {
        int index = hash(keyData);
        if (containsKey(keyData)) {
            return false; // clave ya existe, no se inserta
        }
        Node elem = new Node((index), keyData);
        table[index].add(elem);
        return true; // clave insertada con éxito
    }
    
    private boolean containsKey(int keyData) {
        int index = hash(keyData);
        for (Node node : table[index]) {
            if (node.getKey() == keyData) {
                return true; // clave encontrada
            }
        }
        return false; // clave no encontrada
    }

    public boolean buscar(int keyData) {
        int index = hash(keyData);
        if (table[index].isEmpty()) {
            return false;
        }
        for (Node node : table[index]) {
            if (node.data==(keyData)) {
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
        for (Node node : table[index]) {
            if (node.data==(keyData)) {
                table[index].remove(node);
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            if (table[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    
    public void imprimir() {
        for (int i = 0; i < size; i++) {
            if (table[i].isEmpty()) {
                System.out.println("bloque " + i + " null");
            } else {
                System.out.print("bloque " + i + ": ");
                for (Node node : table[i]) {
                    System.out.print(node.data);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    class Node {
        int key;
        int data;
        Node prev;
        Node next;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public int getKey(){
            return key;
        }
        public int getData(){
            return  data;
        }
    }


}
