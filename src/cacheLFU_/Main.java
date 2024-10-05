package cacheLFU_;

public class Main {
    public static void main(String[] args) {
        int cacheSize=3;
        CacheLFU lfu=new CacheLFU(cacheSize);
        FibronacciLFU fibronacciLFU=new FibronacciLFU();
        int test=2;
        int resultado=(fibronacciLFU.fibonacciLRU(test, lfu));
        System.out.println("Fibronacci[LFU] resultado de:"+test+"="+resultado);
       
    }
    
}
