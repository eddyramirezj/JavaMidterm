package algorithm;

import java.util.Arrays;

public class Sort {

    long executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */

    public static void printSortedArray(int[] array) {
        System.out.print(Arrays.toString(array));
        }


    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        int temp;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while ((j > 0) && (array[j] < array[j-1])) {
                temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        int temp;

        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j-1] > list[j]) {
                    temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;
                }
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] mergeSort(int[] array, int l, int r) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        if (l < r) {
            int m = l + (r-l)/2;
            mergeSort(list, l, m);
            mergeSort(list, m+1, r);
            merge(list, l, m, r);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] quickSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }

    public int[] heapSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }

    public int[] bucketSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }

    public int[] shellSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }



        //HELPER METHOD FOR MERGESORT:
    public static void merge(int[] array, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0;i < n1; i++) {
            L[i] = array[l+i];
        }
        for(int i = 0;i < n2; i++) {
            R[i] = array[m+1+i];
        }
        int i = 0, j = 0, k =l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                array[k++] = L[i++];
            }
            else {
                array[k++] = R[j++];
            }
        }
        while(i < n1) {
            array[k++] = L[i++];
        }
        while(j < n2) {
            array[k++] = R[j++];
        }
    }
}
