package cacheLFU_;

public class Main {
    public static void main(String[] args) {
        int cacheSize=3;
        CacheLFU lfu=new CacheLFU(cacheSize);
        FibronacciLFU fibronacciLFU=new FibronacciLFU();
        int test=45;
        int resultado=(fibronacciLFU.fibonacciLFU(test, lfu));
        System.out.println("Fibronacci[LFU] resultado de:"+test+"="+resultado);
       
    }
    
}
