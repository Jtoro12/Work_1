package cacheLRU_;

public class FibonacciLRU {
    
    public int fibonacciLRU(int n, LRUCache cache) {
        
        if (n <= 1) {
            return n;
        }
        if (cache.get(n) != -1) {// si ya esta en el cache el valor
            return cache.get(n);
        }
        int result = fibonacciLRU(n - 1, cache) + fibonacciLRU(n - 2, cache);
        cache.put(n, result);
        
        
        return result;
    }

}