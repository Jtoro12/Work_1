package cacheLFU_;
/**
 * @author Javier Toro Toro
 * @author Sebastián Cádiz Quezada
 * @author Boris Arenas Bastías
 **/
public class Main {
    public static void main(String[] args) {
        int cacheSize = 3;
        CacheLFU lfu = new CacheLFU(cacheSize);
        FibonacciLFU fibronacciLFU = new FibonacciLFU();
        int test = 45;
        int resultado = (fibronacciLFU.fibonacciLFU(test, lfu));
        System.out.println("Fibronacci[LFU] resultado de:" + test + "=" + resultado);

    }

}
