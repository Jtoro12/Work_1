package cacheLRU_;

import java.math.BigInteger;

/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class Main {
    public static void main(String[] args) {
        int cacheSize = 3;
        int fibonacci = 100;
        LRUCache lruCache = new LRUCache(cacheSize);

        long start = System.currentTimeMillis();
        for (int i = 0; i <= fibonacci; i++) {
            BigInteger resultado = (fibonacciLRU(i, lruCache));
            System.out.println("Fibronacci[LRU] resultado de:" + i + "=" + resultado);
        }
        long end = System.currentTimeMillis();
        System.out.println("Tiempo "+(end-start)+" ms");

        /*
         * System.out.println("estados");
         * lruCache.print();
         */
    }

    private static BigInteger fibonacciLRU(int n, LRUCache cache) {

        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        if (!cache.get(n).equals(BigInteger.valueOf(-1))) {// si ya esta en el cache el valor
            return cache.get(n);
        }
        BigInteger result = fibonacciLRU(n - 1, cache).add(fibonacciLRU(n - 2, cache));// caso general retorna el valor
        cache.put(n, result);
        return result;
    }
}
