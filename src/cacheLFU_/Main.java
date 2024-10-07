package cacheLFU_;

import java.math.BigInteger;

/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class Main {
    public static void main(String[] args) {
        int cacheSize = 100;
        CacheLFU lfu = new CacheLFU(cacheSize);
        FibonacciLFU fibronacciLFU = new FibonacciLFU();
        int test = 47;
        BigInteger resultado = (fibronacciLFU.fibonacci(test,lfu));
        System.out.println("Fibronacci[LFU] resultado de:" + test + "=" + resultado);

    }

}
