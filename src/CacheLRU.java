public class CacheLRU {
    public static void main(String[] args) {
        HashingDiccionario tabla= new HashingDiccionario(3);
        tabla.insertar(10);
        tabla.insertar(20);
        tabla.insertar(30);
        tabla.imprimirA();
        System.out.println("ingresar un elemento de mas");
        tabla.insertar(40);
        tabla.imprimirA();
        System.out.println("insertando uno nuevo");
        tabla.insertar(50);
        tabla.imprimirA();
        System.out.println("consultando por 30 "+tabla.buscar(30));
        tabla.imprimirA();

    }
}
