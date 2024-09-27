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
                    lista.deleteLast();// elimina el menos usado de la lista
                    eliminar(fibronacci);// elimina de la tabla
                    lista.add((resultado), fibronacci);// insetar el nuevo elemento a la lista <data,index>
                    table[index].add(elementTabla);// se actuliza el index
                    return false;
                }

            }
        }
        return false;

    }

    public int valor(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            int sumando1 = n - 1;
            int sumando2 = n - 2;
            if (buscar(sumando1)) {
                sumando1 = lista.getNodo(sumando1).data;
            } else {
                sumando1 = calculoManual(sumando1);
                insertar(sumando1,n);
            }
            if (buscar(n - 2)) {
                sumando2 = lista.getNodo(sumando2).data;
            } else {
                sumando2 = calculoManual(sumando2);
                insertar(sumando1,n);
            }
            return sumando1 + sumando2;
        }

    }

    public int calculoManual(int n) {
        int fibronacci = 0;
        int fibronacci2 = 1;
        for (int i = 2; i <= n; i++) {
            int suma = fibronacci;
            fibronacci += fibronacci2;
            fibronacci2 = suma;
        }
        return fibronacci;
    }

    public boolean buscar(int fibronacci) {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                return false;
            } else {
                for (Node elemnt : table[i]) {
                    if (elemnt.getData() == (fibronacci)) {
                        lista.delete(fibronacci);
                        lista.add(valor(fibronacci), fibronacci);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean buscarIndex(int fibronacci) {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                return false;
            } else {
                for (Node elemnt : table[i]) {
                    if (elemnt.getData() == (fibronacci)) {
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
