package cacheLFU_;

import java.math.BigInteger;

/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class Main {
    public static void main(String[] args) {
        int cacheSize = 8;
        int fibonaci = 60;
        CacheLFU lfu = new CacheLFU(cacheSize);
        FibonacciLFU fibronacciLFU = new FibonacciLFU();

        long start = System.nanoTime();
        for (int i = 0; i <= fibonaci; i++) {
            BigInteger resultado = (fibronacciLFU.fibonacci(i,lfu));
            System.out.println("Fibronacci[LFU] resultado de:" + i + "=" + resultado);
        }
        long end = System.nanoTime();
        System.out.println("Tiempo "+ (end-start)/1_000_000);

    }

}
