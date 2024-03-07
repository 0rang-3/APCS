public class App {
    public static void main(String[] args) {
        System.out.println("Fibonacci Recursion ---------->");
        for (int i = 0; i < 30; i++) {
            System.out.println("f(" + i + ") = " + fib(i));
        }

        System.out.println("");

        System.out.println("Factorial Recursion ---------->");
        for (int i = 1; i < 30; i++) {
            System.out.println("f(" + i + ") = " + fact(i));
        }
    }

    public static long fib(long n) {
        if(n <= 1) return 1;
        long a = fib(n-1);
        long b = fib(n-2);
        return a+b;
    }

    public static long fact(long n) {
        if(n == 1) return 1;
        return n*fact(n-1);
    }
}