package cacheLFU_;

public class Main {
    public static void main(String[] args) {
        int cacheSize=35;
        CacheLFU lfu=new CacheLFU(cacheSize);
        FibronacciLFU fibronacciLFU=new FibronacciLFU();
        int test=46;
        int resultado=(fibronacciLFU.fibonacciLRU(test, lfu));
        System.out.println("Fibronacci[LFU] resultado de:"+test+"="+resultado);
       
    }
    
}
