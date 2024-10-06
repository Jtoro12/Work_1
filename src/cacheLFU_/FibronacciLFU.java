package cacheLFU_;
public class FibronacciLFU {
     public int fibonacciLFU(int n, CacheLFU cache) {
        long start=System.currentTimeMillis();
        if (n <= 1) {
            return n;
        }
        if (cache.get(n) != -1) {// si ya esta en el cache el valor
            return cache.get(n);
        }
        int result = fibonacciLFU(n - 1, cache) + fibonacciLFU(n - 2, cache);// caso geenran retorna el valor
        cache.insertar(n, result);
        long finisg=System.currentTimeMillis();
        System.out.println("time ms; "+(finisg-start));
        return result;
    }
}
