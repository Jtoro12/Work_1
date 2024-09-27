public class ListaDobleEnlazada {
    private Nodo Cabeza;
    private Nodo Cola;

    public ListaDobleEnlazada() {
        Cabeza = null;
        Cola = null;
    }

    public void add(int data, int index) {
        if (this.Cabeza == null && this.Cola == null) {
            this.Cabeza = new Nodo(data, index);
            this.Cola = this.Cabeza;
        } else {
            Nodo current = this.Cabeza;
            Cabeza = new Nodo(data, index);
            Cabeza.next = current;
            current.prev = Cabeza;
        }
    }

    public void deleteLast() {
        if (this.Cabeza != null && this.Cola != null) {
            Nodo current = Cola.prev;
            current.next = null;
            Cola = current;
        }
    }

    public void delete(int data) {
        Nodo current = this.Cabeza;
        while (current != null) {
            if (current != Cabeza && current != Cola && current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            if (current == Cabeza && current != Cola && current.data == data) {
                current.next.prev = null;
                Cabeza = current.next;
                current.next = null;
            }
            if (current == Cola && current != Cabeza && current.data == data) {
                current.prev.next = null;
                Cola = current.prev;
            }
            current = current.next;
        }
    }

    public int getData(){
        Nodo current = Cabeza;
        while (current.next!= null) {
            current = current.next;
        }
        return current.data;
    }

    

    public Nodo getNodo(int index) {
        Nodo current = Cabeza;
        while (current.data != index) {
            current = current.next;
        }
        return current;
    }

    

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo current = Cabeza;
        while (current != null) {
            sb.append(current.index).append("-");
            current = current.next;
        }
        return sb.toString();
    }

    class Nodo {
        Nodo next;
        Nodo prev;
        int data;
        int index;

        Nodo(int data,int index) {
            this.data = data;
            this.index=index;
            next = null;
            prev = null;
        }

        public int getData(){
            return data;
        }
    }
}
