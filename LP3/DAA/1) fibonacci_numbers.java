class Main {

    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static void nonRecursiveFibonacci(int n) {
        int first = 0;
        int second = 1;
        
        System.out.println(first);
        System.out.println(second);

        while (n - 2 > 0) {
            int third = first + second;
            first = second;
            second = third;
            System.out.println(third);
            n--;
        }
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.println(recursiveFibonacci(i));
        }

        System.out.println("\nNon-Recursive Fibonacci:");
        nonRecursiveFibonacci(n);
    }
}
