package cacheLRU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class Main {
    public static void main(String[] args) {
        int cacheSize = 35;
        LRUCache lruCache = new LRUCache(cacheSize);
        FibonacciLRU fibonacciLRU = new FibonacciLRU();
        int test = 46;
        int result = (fibonacciLRU.fibonacciLRU(test, lruCache));
        System.out.println("Fibronacci[LRU] resultado de:" + test + "=" + result);
        /*
         * System.out.println("estados");
         * lruCache.print();
         */

    }
}
