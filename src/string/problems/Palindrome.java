package string.problems;

import java.util.Arrays;
import java.util.Locale;

public class Palindrome {

    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called a palindrome.
            Example: MOM, DAD, MADAM are palindromes.

            Write a method to check if a given String is a palindrome or not.
         */

        String word = "madam";


        System.out.println(isPalindrome(word));

    }
    public static boolean isPalindrome(String word) {
        boolean isPalindrome;

        char[] wordChars = word.toCharArray();

        char temp;

        for (int i = 0; i < word.length()/2; i++) {
            temp = wordChars[i];
            wordChars[i] = wordChars[word.length() - 1 - i];
            wordChars[word.length() - 1 - i] = temp;
        }

        char[] wordChars2 = word.toCharArray();

        if (Arrays.equals(wordChars2, wordChars)) {
            isPalindrome = true;
        }
        else {
            isPalindrome = false;
        }



        return isPalindrome;


    }

    }

