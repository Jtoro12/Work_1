package cacheLRU_;
public class Main {
    public static void main(String[] args) {
        int cacheSize = 3;
        LRUCache lruCache = new LRUCache(cacheSize);
        FibonacciLRU fibonacciLRU=new FibonacciLRU();
        System.out.println("valor de 7");
        System.out.println(fibonacciLRU.fibonacciLRU(7,lruCache));
        System.out.println("valor de 8");
        System.out.println(fibonacciLRU.fibonacciLRU(8,lruCache));
        
        System.out.println("Cache");
        lruCache.print();
    }
}
