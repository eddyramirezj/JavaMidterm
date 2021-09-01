package datastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import databases.ConnectToSqlDB;

public class DataReader {

    static String absolutePath = System.getProperty("user.dir");
    static String relativePath = "/src/data/self-driving-car.txt";
    static final String path = absolutePath + relativePath;
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static void main(String[] args) throws Exception {
        /*
         * Create an API to read the below textFile and print it to the console.
         *      HINT: Use BufferedReader class
         * Use try-catch block to handle Exceptions
         *
         * Store and retrieve the file to/from a database table.
         *
         * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
         * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
         * order from LinkedList and retrieve as FILO order from Stack.
         *
         * Demonstrate how to use Stack using push, peek, search & pop methods.
         * Use For-Each & While-loop with Iterator to retrieve data.
         */

        storeWords(path);


//        readFile(path);

    }


    static void readFile(String path) {
        String data = "";
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            try {
                while ((data = bufferedReader.readLine()) != null) {
                    System.out.println(data);
                }
            } catch (Exception e1) {
                System.out.println("Unable to read line");
            }

        } catch (Exception e) {
            System.out.println("File not found at path: " + path);

        } finally {

            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println("Unable to close buffered reader");
            }
        }
    }

    static void storeWords(String path) throws Exception {
        try {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

        fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();

        String[] words = line.split(" ");

        connectToSqlDB.readerInsertDataFromStringToSqlTable(words, "file_reader", "words");
        List<String> sortedNumbers = connectToSqlDB.readDataBase("file_reader", "words");
        System.out.println(sortedNumbers.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




