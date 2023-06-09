public class Helper {
    /**
     * Computes the factorial of a given integer. The factorial of a non-negative integer n is the product of all
     * positive integers less than or equal to n.
     * @param n The non-negative integer for which to compute the factorial.
     * @return The factorial of the given integer.
     */
    public static double factorial(int n) {
        double result = 1;  // Variable to store the factorial value

        for (int i = 2; i <= n; i++) {
            result *= i;  // Multiply the current value by the next integer in the range [2, n]
        }

        return result;
    }

    /**
     * Removes first two arguments.
     * @param functions Functions list.
     * @return Functions list without the first two.
     */
    public static Function[] removeFirstTwo(Function[] functions) {
        Function[] result = new Function[functions.length - 2];

        for (int i = 2; i < functions.length; i++){
            result[i-2] = functions[i];
        }

        return result;
    }
}
