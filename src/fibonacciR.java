import java.math.BigInteger;
public class fibonacciR {
    public static void main(String[] args) {

        int fibonacci = 75;

        long start = System.currentTimeMillis();
        for (int i = 0; i <= fibonacci; i++) {
            BigInteger resultado = (fibonacci(i));
            System.out.println("Fibronacci[LRU] resultado de:" + i + "=" + resultado);
        }
        long end = System.currentTimeMillis();
        System.out.println("Tiempo " + (end - start) + " ms");

    }

    private static BigInteger fibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
        return result;
    }

}
