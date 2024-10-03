package cacheLRU_;
public class Main {
    public static void main(String[] args) {
        int cacheSize = 5;
        LRUCache lruCache = new LRUCache(cacheSize);
        FibonacciLRU fibonacciLRU=new FibonacciLRU();

        System.out.println(fibonacciLRU.fibonacciLRU(10,lruCache));  // Resultado de Fibonacci para N=10 con LRU
        System.out.println(fibonacciLRU.fibonacciLRU(11, lruCache));  // Resultado de Fibonacci para N=10 con LRU
        lruCache.print();
        System.out.println("valor de 12");
        System.out.println(fibonacciLRU.fibonacciLRU(12, lruCache));
        lruCache.print();
    }
}
