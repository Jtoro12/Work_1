package cacheLFU_;

import java.math.BigInteger;

/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class Main {
    public static void main(String[] args) {
        int cacheSize = 34;
        int fibonaci = 75;
        CacheLFU lfu = new CacheLFU(cacheSize);

        long start = System.currentTimeMillis();
        for (int i = 0; i <= fibonaci; i++) {
            BigInteger resultado = (fibonacciLFU(i,lfu));
            System.out.println("Fibronacci[LFU] resultado de:" + i + "=" + resultado);
        }
        long end = System.currentTimeMillis();
        System.out.println("Tiempo "+ (end-start)+" ms");

    }

    public static BigInteger fibonacciLFU(int n, CacheLFU cache) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        if (!cache.get(n).equals(BigInteger.valueOf(-1))) {// si ya esta en el cache el valor
            return cache.get(n);
        }
        BigInteger result = fibonacciLFU(n - 1, cache).add(fibonacciLFU(n - 2, cache));// caso
        //general retorna el valor
        cache.put(n, result);
        return result;
    }

}
