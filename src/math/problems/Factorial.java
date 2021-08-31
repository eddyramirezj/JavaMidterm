package math.problems;

public class Factorial {

    /*
     Write a method to return the Factorial of any given number using Recursion as well as Iteration

     Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {

        System.out.println(iterationFactorial(7));

        System.out.println(recursionFactorial(7));

    }

    public static int recursionFactorial(int number) {
        int x = 0;

        if (number <= 1) {
            return number;
        }

        x = x + (number * recursionFactorial(number-1 ) );

       return x;
    }

    public static int iterationFactorial(int number) {
        int x = 0;
        if (number <= 1) {
            return number;
        }

        for (int y = number - 1; y > 0; y--) {
            if (x > 0) {
                x = x * y;
            }
            else if (x == 0) {
                x += number * y;
            }
        }
        return x;
    }
}
