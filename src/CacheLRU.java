public class CacheLRU {
    
    
    public static void main(String[] args) {
        HashingDiccionario tabla= new HashingDiccionario(2);
        System.out.println("");
        tabla.insertar(1, 0);
        tabla.insertar(3, 0);
        tabla.imprimirTabla();
        tabla.imprimirLista();
        System.out.println("nueva tabla");
        tabla.insertar(4, 0);
        tabla.imprimirTabla();
        tabla.imprimirLista();
        //int x=tabla.valor(4);
        //System.out.println("valor fibronacci de _ es: "+x);

        


        /*System.out.println("ingresar un elemento de mas 40 ");
        
        tabla.imprimirLista();
        tabla.imprimirTabla();

        /*System.out.println("insertando uno nuevo 50");
        tabla.insertar(50);
        tabla.imprimirLista();
        tabla.imprimirTabla();
        /* */

    }
}
