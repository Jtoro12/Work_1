public class CacheLRU {
    HashingDicc table=new HashingDicc(3);
    DobleLinkedList lista=new DobleLinkedList();

    public void insertar(int data) {
        table.insert(data);
        int indexTable=table.get(data);
        lista.insertar(indexTable, data);

        if(table.insert(data)){
            System.out.println("Se inserto data");
        }else{
            System.out.println("tabla llena ");
           
        }
        System.out.println("lista");
        lista.imprimir();

    }

    public static void main(String[] args) {
        int[]a={1,2,3,4};
        CacheLRU cache=new CacheLRU();
        for (int i = 0; i < a.length; i++) {
            cache.insertar(i);
        }
    }
}
