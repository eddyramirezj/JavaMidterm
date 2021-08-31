package math.problems;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {
        /*
        Write a method to print the list of prime numbers from 2 to 1,000,000
            Solving the problem should be your first priority, however bonus points if you can figure out how to
            improve algorithmic efficiency

         Print out the prime numbers in the given range.
         */

        System.out.println(primeNumbers(1000000));

    }

        public static List<Integer> primeNumbers(int maxNumber) {
        List<Integer> primeNumbers = new ArrayList<>();

            if (maxNumber >= 2) {
                primeNumbers.add(2);
            }
            for (int i = 3; i <= maxNumber; i += 2) {
                if (isPrime(i)) {
                    primeNumbers.add(i);
                }
            }
            return primeNumbers;
        }

        //HELPER METHOD:

        private static boolean isPrime(int number) {
            for (int i = 2; i*i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;

            }


        }






