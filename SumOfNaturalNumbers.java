public class SumOfNaturalNumbers {
    // Time Complexity: O(n), Space Complexity: O(n)
    public int sumOfNaturalNumbersRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumOfNaturalNumbersRecursive(n - 1);
    }

    // Time Complexity: O(n), Space Complexity: O(1)
    // The loop uses a constant amount of space regardless of the input size.
    public int sumOfNaturalNumbersIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Time Complexity: O(1), Space Complexity: O(1)
    public int sumOfNaturalNumbersFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        double now = System.currentTimeMillis();

        SumOfNaturalNumbers demo = new SumOfNaturalNumbers();
        int n = 1000000; // Example input for performance testing
        System.out.println(demo.sumOfNaturalNumbersFormula(n));

        System.out.println("Time taken - " + (System.currentTimeMillis() - now) + " ms");
    }
}
