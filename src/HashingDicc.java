import java.util.ArrayList;
public class HashingDicc{
    private int size;
    private ArrayList<Elemento>[] table;

    public HashingDicc(int size) {
        this.size = size;
        table = new ArrayList[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public boolean insert(int Datakey) {
        int index = hash(Datakey);
        int indexStart = index;
        Elemento elem = new Elemento(Datakey, Datakey);
        for (int i = 0; i < size; i++) {
            if (table[index] == null) {
                table[index] = new ArrayList<Elemento>();
                return true;
            }
            if (table[index].isEmpty()) {
                table[index].add(elem);
                return true;
            } else {
                index = hash(index + 1);
                if (index == indexStart) {
                    return false;
                }

            }
        }
        return false;

    }

    public boolean buscar(int data) {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                return false;
            } else {
                for (Elemento elemnt : table[i]) {
                    if (elemnt.getData()==(data)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean delete(int key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Elemento elem : table[index]) {
                if (elem.getKey() == key) {
                    table[index].remove(elem);
                    return true;
                }
            }
        }
        return false;
    }

    public int get(int key){
        int index = hash(key);
        if (table[index] != null) {
            for (Elemento elem : table[index]) {
                if (elem.getKey() == key) {
                    return elem.getData();
                }
            }
        }
        return -1;
    }

    public void imprimir() {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                System.out.println("bloque " + i + " null");
            } else {
                System.out.print("bloque " + i + ": ");
                for (Elemento element : table[i]) {
                    System.out.print(element.data + " ");
                }
                System.out.println();
            }
        }
    }

    public class Elemento {
        int key;
        int data;
        Elemento next;

        public Elemento(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

        public int getData() {
            return data;
        }
    }

}
