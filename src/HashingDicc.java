import java.util.ArrayList;
public class HashingDicc{
    private int size;
    private ArrayList<Elemento>[] table;

    public HashingDicc(int size) {
        this.size = size;
        table = new ArrayList[size];
    }

    public int hash(int key) {
        return key % size;
    }

    public boolean insertar(int Datakey) {
        int index = hash(Datakey);
        int indexStart = index;
        Elemento elem = new Elemento(index, Datakey);
    
        while (true) {
            if (index >= size) {
                index = 0; // wrap around to beginning of table
            }
    
            if (table[index] == null) {
                table[index] = new ArrayList<Elemento>();
                table[index].add(elem);
                return true;
            }
    
            if (table[index].isEmpty()) {
                table[index].add(elem);
                return true;
            }
    
            index = (index + 1) % size; 
            if (index == indexStart) {
                return false; // table is full
            }
        }
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

    public boolean contiene(int data) {
        int index = hash(data);
        if (table[index] != null) {
            for (Elemento elem : table[index]) {
                if (elem.getData() == data) {
                    return true;
                }
            }
        }
        return false;
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
