public class fibonacciR {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            long start = System.currentTimeMillis();
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            long finish = System.currentTimeMillis();
            System.out.println("Time " + (finish - start) + " mS");
            return result;
        }
    }
    public static void main(String[] args) {
        int x=36;
        System.out.println("fibonacci de:"+x+"="+fibonacci(x));
    }
    
}
