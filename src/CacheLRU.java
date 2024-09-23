
public class CacheLRU {
    DobleLinkedList listaLinked = new DobleLinkedList();
    HashingDicc tablaHash = new HashingDicc(3);

    public void insercion(int data) {
        if (!tablaHash.contiene(data)) {// verifica si existe el elemento dentro de la tabla
            tablaHash.insertar(data);
            int indTabla = tablaHash.hash(data);
            listaLinked.insertar(indTabla, data);// inserta en la linkedlist <key,data> al principio
        }
        /*if (tablaHash.contiene(data)) {
            listaLinked.moverFinal(listaLinked.buscarNodo(data));// si el elemento se repite envia el nodo de la lista al final
        }*/
    }

    public void imprimir() {
        System.out.println("lista");
        listaLinked.imprimir();
        System.out.println("tabla");
        tablaHash.imprimir();
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        CacheLRU cache = new CacheLRU();
        for (int i = 0; i < a.length; i++) {
            cache.insercion(a[i]);
        }
        cache.imprimir();

    }
}
