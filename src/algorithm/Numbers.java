package algorithm;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import databases.ConnectToSqlDB;

public class Numbers {

    /*
     * Show all the different kind of sorting algorithm by applying into (num array).
     * Display the execution time for each sorting.Example in below.

     * At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
     *
        /*
        Can you come to conclusion about which sorting algorithm is most efficient, given the size of the data set?
         */


    public static void main(String[] args) throws Exception {

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

        try {
            int[] num = new int[1000];
            storeRandomNumbers(num);

            // Selection Sort
            Sort algo = new Sort();
            algo.selectionSort(num);
            long selectionSortExecutionTime = algo.executionTime;
            System.out.println("Total Execution Time of " + num.length + " numbers in Selection Sort took: "
                    + selectionSortExecutionTime + " milliseconds");

            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "selection_sort", "sorted_numbers");
            List<String> sortedNumbers = connectToSqlDB.readDataBase("selection_sort", "sorted_numbers");
            // printValue(sortedNumbers);


            int n = num.length;
            randomize(num, n);

            // Insertion Sort
            algo.insertionSort(num);
            long insertionSortExecutionTime = algo.executionTime;
            System.out.println("Total Execution Time of " + num.length + " numbers in insertion Sort took: "
                    + insertionSortExecutionTime + " milliseconds");

            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "insertion_sort", "sorted_numbers");
            List<String> insertionNumbers = connectToSqlDB.readDataBase("insertion_sort", "sorted_numbers");
            // printValue(insertionNumbers);

            randomize(num, n);

            // bubble Sort
            algo.bubbleSort(num);
            long bubbleSortExecutionTime = algo.executionTime;
            System.out.println("Total Execution Time of " + num.length + " numbers in bubble Sort took: "
                    + bubbleSortExecutionTime + " milliseconds");

            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "bubble_sort", "sorted_numbers");
            List<String> bubbleNumbers = connectToSqlDB.readDataBase("bubble_sort", "sorted_numbers");
            // printValue(bubbleNumbers);

            randomize(num, n);

            // merge Sort
            algo.mergeSort(num, 0, num.length - 1);
            long mergeSortExecutionTime = algo.executionTime;
            System.out.println("Total Execution Time of " + num.length + " numbers in merge Sort took: "
                    + mergeSortExecutionTime + " milliseconds");

            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "merge_sort", "sorted_numbers");
            List<String> mergeNumbers = connectToSqlDB.readDataBase("merge_sort", "sorted_numbers");
            // printValue(mergeNumbers);

            randomize(num, n);

            // quick Sort
//            algo.quickSort(num, 0, num.length - 1);
//            long quickSortExecutionTime = algo.executionTime;
//            System.out.println("Total Execution Time of " + num.length + " numbers in quick Sort took: "
//                    + quickSortExecutionTime + " milliseconds");
//
//            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "quick_sort", "sorted_numbers");
//            List<String> quickNumbers = connectToSqlDB.readDataBase("quick_sort", "sorted_numbers");
            // printValue(quickNumbers);

            randomize(num, n);

            // heap Sort
            algo.heapSort(num);
            long heapSortExecutionTime = algo.executionTime;
            System.out.println("Total Execution Time of " + num.length + " numbers in heap Sort took: "
                    + heapSortExecutionTime + " milliseconds");

            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "heap_sort", "sorted_numbers");
            List<String> heapNumbers = connectToSqlDB.readDataBase("heap_sort", "sorted_numbers");
            // printValue(heapNumbers);

            randomize(num, n);

            // bucket Sort
//            algo.bucketSort(num, num.length);
//            long bucketSortExecutionTime = algo.executionTime;
//            System.out.println("Total Execution Time of " + num.length + " numbers in bucket Sort took: "
//                    + bucketSortExecutionTime + " milliseconds");
//
//            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "bucket_sort", "sorted_numbers");
//            List<String> bucketNumbers = connectToSqlDB.readDataBase("bucket_sort", "sorted_numbers");
            // printValue(bucketNumbers);

            randomize(num, n);

            // shell Sort
            algo.shellSort(num, num.length);
            long shellSortExecutionTime = algo.executionTime;
            System.out.println("Total Execution Time of " + num.length + " numbers in shell Sort took: "
                    + shellSortExecutionTime + " milliseconds");

            connectToSqlDB.sortInsertDataFromArrayToSqlTable(num, "shell_sort", "sorted_numbers");
            List<String> shellNumbers = connectToSqlDB.readDataBase("shell_sort", "sorted_numbers");
            // printValue(shellNumbers);


        }
        catch (SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
            }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }



    /*
    HELPER METHODS
     */

    public static void storeRandomNumbers(int[] num) {
        Random rand = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(1000000);
        }
    }

    public static void randomize(int[] arr, int n) {
        Random r = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void printValue(List<String> array) {
        for (String st : array) {
            System.out.println(st);
        }
    }
}
