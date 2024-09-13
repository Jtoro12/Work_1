public class ArraysList {
    private String[] elements;
    private int size;

    // ArrayList
    public ArraysList() {
        elements = new String[10];
        size = 0;
    }

    // insertar
    public void insertar(String data) {
        if (elements == null) {
            elements = new String[10];
        }
        if (size == elements.length) {
            String[] newElements = new String[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size] = data;
        size++;
    }
    // buscar
    public boolean buscar(String data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return true;
            }

        }
        return false;
    }
        // remove
    public void eliminar(String data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                elements[i] = elements[size - 1];
                size--;
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append("  ");
        }
        return sb.toString();
    }

   

}
