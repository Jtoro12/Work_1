package cacheLRU_;
public class Main {
    public static void main(String[] args) {
        int cacheSize = 3;
        LRUCache lruCache = new LRUCache(cacheSize);
        FibonacciLRU fibonacciLRU=new FibonacciLRU();
        int test=2;
        int result=(fibonacciLRU.fibonacciLRU(test,lruCache));
        System.out.println("Fibronacci resultado de:"+test+"="+result);
       System.out.println("estados");
       lruCache.print();
    
        
        
    }
}
