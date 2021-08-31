package math.problems;

public class Fibonacci {

    /*
    Write a method that will print or return at least 40 Fibonacci numbers

      0,1,1,2,3,5,8,13
     */

    public static void main(String[] args) {

        fibonacciNumbers(40);

    }

    public static void fibonacciNumbers(int number) {
        int a = 0;
        int b = 1;
        int c;

        System.out.print(a + ",");
        System.out.print(b + ",");
        c = a + b;
        System.out.print(c + ",");
        a = c;
        c = a + b;
        System.out.print(c + ",");
        a = c;
        b += a;
        System.out.print(b + ",");
        for (int x = 0; x <= number; x++) {
            c = a + b;
            System.out.print(c + ",");
            a = c;

            c = a + b;
            System.out.print(c + ",");
            b = c;

            c = a + b;
            System.out.print(c + ",");
            a = c;

            c = a + b;
            System.out.print(c + ",");
            b = c;
            }
        }


    }


