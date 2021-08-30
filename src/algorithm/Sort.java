package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    long executionTime = 0;

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

            //NEED TO DEBUG THIS SORTING ALGORITHM:
    public int[] quickSort(int[] array, int low, int high) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        if(low >= high) return list;
        int pivotPosition = quick(array, low, high);
        quickSort(array,low, pivotPosition-1);
        quickSort(array, pivotPosition+1, high);

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        buildHeap(array);
        int sizeOfHeap = array.length-1;
        for (int i = sizeOfHeap; i > 0; i--) {
            exchange(array, 0, i);
            sizeOfHeap = sizeOfHeap - 1;
            heap (array, 0, sizeOfHeap);
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

            //NEED TO DEBUG THIS SORTING ALGORITHM:
    public void bucketSort(int[] array, int noOfBuckets){
        final long startTime = System.currentTimeMillis();
        List<Integer>[] buckets = new List[noOfBuckets];

        for(int i = 0; i < noOfBuckets; i++){
            buckets[i] = new LinkedList<>();
        }

        for(int num : array){

            buckets[hash(num)].add(num);
        }

        for(List<Integer> bucket : buckets){
            Collections.sort(bucket);
        }
        int i = 0;

        for(List<Integer> bucket : buckets){
            for(int num : bucket){
                array[i++] = num;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
    }

    public void shellSort(int[] array, int length) {
        final long startTime = System.currentTimeMillis();
        for (int interval = length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < length; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
    }


/*
        HELPER METHODS:
 */

        //HELPER METHOD FOR MERGESORT:
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle-left+1;
        int n2 = right-middle;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0;i < n1; i++) {
            L[i] = array[left+i];
        }
        for(int i = 0;i < n2; i++) {
            R[i] = array[middle+1+i];
        }
        int i = 0, j = 0, k =left;
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

        //HELPER METHOD FOR QUICKSORT:
    public static int quick(int[] array, int low, int high) {
        int pivot = array[high];
        int left = low, right = high-1;
        while(left < right) {
            while(array[left]<pivot) {
                left++;
            }
            while(array[right]>pivot) {
                right--;
            }
            if(left >= right) {
                break;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        int temp = array[left];
        array[left] = array[high];
        array[high] = temp;
        return left;
    }

       //HELPER METHODS FOR HEAPSORT:
    public static void heap(int[] array, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max;
        if (left <= size && array[left] > array[i]) {
            max = left;
        } else {
            max = i;
        }
        if (right <= size && array[right] > array[max]) {
            max = right;
        }
        if (max != i) {
            exchange(array, i, max);
            heap(array, max, size);
        }
    }

    public static void buildHeap(int[] array) {

        for(int i = (array.length-1) / 2; i >= 0; i--){
            heap(array, i, array.length-1);
        }
    }

    public static void exchange(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

        //HELPER METHOD FOR BUCKETSORT:
    public static int hash(int num){
        return num/10;
    }

}




