/**
 * Fibonacci
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 9;
        int fibN = fibonacci(n);
        System.out.println(fibN);
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}