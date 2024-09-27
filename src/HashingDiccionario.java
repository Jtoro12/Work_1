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

    public boolean insertar(int fibronacci, int resultado) {

        int index = hash(fibronacci);
        int indexStart = index;
        Node elementTabla = new Node(fibronacci);

        for (int i = 0; i < size; i++) {
            if (table[index] == null) {
                table[index] = new ArrayList<Node>();
            }

            if (table[index].isEmpty()) {
                table[index].add(elementTabla);// se añade a la tabla <index>
                lista.add((resultado), fibronacci);// se añade a la lista <data, index>
                return true;

            } else {
                index = hash(index + 1);

                // caso de la tabla llena
                if (index == indexStart) {
                    int last = lista.getData();
                    lista.deleteLast();// elimina el menos usado de la lista

                    eliminar(last);// elimina de la tabla
                    lista.add((resultado), fibronacci);// insetar el nuevo elemento a la lista <data,index>

                    table[index].add(elementTabla);// se actualiza el index
                    return false;
                }

            }
        }
        return false;

    }


    public boolean eliminar(int data) {
        int index = hash(data);
        if (table[index] != null) {
            
            table[index].clear();
            return true;
        }
        
        return false;
    }

    public boolean buscar(int data) {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                return false;
            } else {
                for (Node elemnt : table[i]) {
                    if (elemnt.getData() == (data)) {
                        lista.delete(data);
                        lista.add((data), data);
                        return true;
                    }
                }
            }
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

    public void imprimirLista() {
        System.out.println("Lista: " + lista.toString());
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

}
