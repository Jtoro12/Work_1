package cacheLFU;

public class NodoFrecuencia {
    ListaDobleLFU lista;
    NodoFrecuencia next;
    NodoFrecuencia prev;
    int frecuencia;

    public NodoFrecuencia(int frecuencia){
        this.lista= new ListaDobleLFU();
        this.next=null;
        this.prev=null;
        this.frecuencia=frecuencia;
    }
}
