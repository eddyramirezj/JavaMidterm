package math.problems;

import algorithm.Sort;

import java.util.Arrays;

public class FindLowestDifference {

    public static void main(String[] args) {
        /*
         Write a method to return the lowest difference between these two arrays
            HINT: The lowest difference between these arrays is 1
        */

        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};

        Sort algo = new Sort();
        System.out.println(Arrays.toString(algo.selectionSort(array1)));
        System.out.println(Arrays.toString(algo.selectionSort(array2)));

        System.out.println("This is the lowest difference between these two arrays: " +lowestDifference(array1, array2));

    }

    public static int lowestDifference(int[] array1, int[] array2) {
        int lowestDifference = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {

                if (lowestDifference == 0) {
                    if (((array1[i]) < (array2[j]))) {
                        lowestDifference = array1[i];
                    } else if (((array1[i]) > (array2[j]))) {
                        lowestDifference = array2[j];
                    }
                } else if (lowestDifference > 0) {

                    if (((array1[i]) < (array2[j])) && (lowestDifference > array1[i])) {
                        lowestDifference = array1[i];
                    } else if (((array1[i]) > (array2[j])) && (lowestDifference > array2[j])) {
                        lowestDifference = array2[j];
                    }

                }

            }

        }
        return lowestDifference;
    }
}

