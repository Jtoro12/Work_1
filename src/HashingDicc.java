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

    public void insert(int key, String data) {
        int index = hash(key);
        int indexStart = index;
        Elemento elem = new Elemento(key, data);
        for (int i = 0; i < size; i++) {
            if (table[index] == null) {
                table[index] = new ArrayList<Elemento>();
            }
            if (table[index].isEmpty()) {
                table[index].add(elem);
                break;
            } else {
                index = hash(index + 1);
                if (index == indexStart) {
                    System.out.println("tabla llena");
                    break;
                }

            }
        }

    }

    public boolean buscar(String data) {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                return false;
            } else {
                for (Elemento elemnt : table[i]) {
                    if (elemnt.getData().equals(data)) {
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

    public String get(int key){
        int index = hash(key);
        if (table[index] != null) {
            for (Elemento elem : table[index]) {
                if (elem.getKey() == key) {
                    return elem.getData();
                }
            }
        }
        return null;
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
        String data;
        Elemento next;

        public Elemento(int key, String data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

        public String getData() {
            return data;
        }
    }

}
