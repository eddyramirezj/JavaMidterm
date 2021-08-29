package algorithm;

import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UnitTestSorting {



    /*
      This class is used to help with unit testing of sorting algorithms from the Sort class
     */
    public static void main(String[] args) {
        Sort sortArgo = new Sort();

        int[] arr = {10,15,16,12,11,20,19,13,14,18,17};
        sortArgo.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }






//        int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
//        int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};
//
//        // Create instance of Sort class
//        Sort sort = new Sort();
//
//        // Pass the unsorted array to selectionSort() method from Sort class
//        sort.selectionSort(unSortedArray);
//
//        // Verify if the unsorted array is sorted by the selectionSort() method
//        try {
//            Assert.assertEquals(sortedArray, unSortedArray, "ARRAY IS NOT SORTED... YET!\n***YOU GOT THIS!***");
//        } catch (Exception ex) {
//            ex.getMessage();
//        }

        // Implement Unit test for rest of the sorting algorithms below

    }

