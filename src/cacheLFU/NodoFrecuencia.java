package cacheLFU;

public class NodoFrecuencia {
    public ListaDobleLFU lista;
    public NodoFrecuencia next;
    public NodoFrecuencia prev;
    int frecuencia;

    public NodoFrecuencia(int frecuencia){
        this.lista= new ListaDobleLFU();
        this.next=null;
        this.prev=null;
        this.frecuencia=frecuencia;
    }
}
