import java.util.LinkedList;


public class HashingEncadenado {

    private int size;
    private LinkedList<Node>[] table;
    private ListaDobleEnlazada lista;

    public HashingEncadenado(int size) {
        this.size=size;
        lista=new ListaDobleEnlazada();
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public boolean insertar(int fibronacci) {
        int index = hash(fibronacci);
        if (contieneClave(fibronacci)) {
            lista.deleteLast();
            return false; // clave ya existe, no se inserta de nuevo, se elimina el menos usado
        }
        Node elem = new Node(fibronacci);
        table[index].add(elem);
        lista.add(fibronacci);
        return true; // clave insertada con éxito
    }
    
    private boolean contieneClave(int keyData) {
        int index = hash(keyData);
        for (Node node : table[index]) {
            if (node.getData() == keyData) {
                return true; // clave encontrada
            }
        }
        return false; // clave no encontrada
    }


    public boolean buscar(int fribonacci) {
        int index = hash(fribonacci);
        if (table[index].isEmpty()) {
            return false;
        }
        for (Node node : table[index]) {
            if (node.data==(fribonacci)) {
                lista.delete(fribonacci);
                lista.add(fribonacci);
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
                lista.delete(keyData);
                return true;
            }
        }
        return false;
    }

    public void imprimirTabla() {
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

    public void imprimirLista(){
        System.out.println("Lista: "+lista.toString());
    }

    class Node {
        int data;
        Node next;
        

        public Node( int data){
            this.data = data;
        }

        public int getData(){
            return  data;
        }

        public Node getNode(){
            return this;
        }
    }
    public static void main(String[] args) {
        HashingEncadenado tabla= new HashingEncadenado(3);
        tabla.insertar(10);
        tabla.insertar(20);
        tabla.insertar(30);
        tabla.insertar(40);
        tabla.imprimirTabla();
        tabla.imprimirLista();

        /*tabla.buscar(10);
        System.out.println("despues de buscar");
        tabla.imprimirLista();
        System.out.println("eliminar 20");
        tabla.eliminar(20);
        tabla.imprimirLista();
        tabla.imprimirTabla();*/
    }

}
