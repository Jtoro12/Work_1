import java.util.ArrayList;

public class HashingDiccionario {
    private int size;
    private ArrayList<Node>[] table;
    private ListaDobleEnlazada lista;

    public HashingDiccionario(int size) {
        this.size = size;
        lista = new ListaDobleEnlazada();
        table = new ArrayList[size];

    }

    private int hash(int key) {
        return key % size;
    }

    public boolean insertar(int fibronacci) {
        int index = hash(fibronacci);
        int indexStart = index;
        Node elem = new Node(fibronacci);
        for (int i = 0; i < size; i++) {
            if (table[index] == null) {
                table[index] = new ArrayList<Node>();
            }
            if (table[index].isEmpty()) {
                table[index].add(elem);
                lista.add(fibronacci);
                return true;
            } else {
                index = hash(index + 1);
                if (index == indexStart) {
                    lista.deleteLast();// elimina el menos usado
                    return false;
                }

            }
        }
        return false;

    }

    public boolean buscar(int fibronacci) {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                return false;
            } else {
                for (Node elemnt : table[i]) {
                    if (elemnt.getData() == (fibronacci)) {
                        lista.delete(fibronacci);
                        lista.add(fibronacci);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean eliminar(int fibronacci) {
        int index = hash(fibronacci);
        if (table[index] != null) {
            table[index].clear();
            lista.delete(fibronacci);
            return true;
        }
        return false;
    }

    public void imprimirTabla() {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                System.out.println("bloque " + i + " null");
            } else {
                System.out.print("bloque " + i + ": ");
                for (Node element : table[i]) {
                    System.out.print(element.data + " ");
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
        Node node;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        HashingDiccionario tabla= new HashingDiccionario(3);
        tabla.insertar(10);
        tabla.insertar(20);
        tabla.insertar(30);
        tabla.imprimirTabla();
        tabla.imprimirLista();
        tabla.buscar(10);
        System.out.println("despues de buscar");
        tabla.imprimirLista();
        System.out.println("eliminar 20");
        tabla.eliminar(20);
        tabla.imprimirLista();
        tabla.imprimirTabla();
    }

}
