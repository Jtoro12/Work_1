package cacheLFU_;

public class FibonacciLFU {
    public int fibonacciLFU(int n, CacheLFU cache) {

        if (n <= 1) {
            return n;
        }
        if (cache.get(n) != -1) {// si ya esta en el cache el valor
            return cache.get(n);
        }
        int result = fibonacciLFU(n - 1, cache) + fibonacciLFU(n - 2, cache);
        cache.insertar(n, result);

        return result;
    }
}
