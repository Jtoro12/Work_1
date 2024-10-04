package cacheLRU_;
public class Main {
    public static void main(String[] args) {
        int cacheSize = 5;
        LRUCache lruCache = new LRUCache(cacheSize);
        FibonacciLRU fibonacciLRU=new FibonacciLRU();
        System.out.println("valor de 2");
        System.out.println(fibonacciLRU.fibonacciLRU(2,lruCache));  // Resultado de Fibonacci para N=10 con LRU y cache 5 
        System.out.println("Estados de los cache");
        lruCache.print();
    }
}
