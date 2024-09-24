public class CacheLRU {
    public static void main(String[] args) {
        HashingDiccionario tabla= new HashingDiccionario(3);
        tabla.insertar(10);
        tabla.insertar(20);
        tabla.insertar(30);
        tabla.imprimirTabla();
        tabla.imprimirLista();
        System.out.println("ingresar un elemento de mas");
        tabla.insertar(40);
        tabla.imprimirLista();
        tabla.imprimirTabla();
        System.out.println("insertando uno nuevo");
        tabla.insertar(50);
        tabla.imprimirLista();
        tabla.imprimirTabla();

    }
}
