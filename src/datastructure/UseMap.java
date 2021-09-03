package datastructure;

import java.util.*;

public class UseMap {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */


        ArrayList<Integer> keys = new ArrayList<>();

        keys.add(10);
        keys.add(20);
        keys.add(30);
        keys.add(40);
        keys.add(50);

        ArrayList<String> values = new ArrayList<>();

        values.add("Ten");
        values.add("Twenty");
        values.add("Thirty");
        values.add("Forty");
        values.add("Fifty");

        Map<List<Integer>, List<String>> myHashMap = new HashMap<>();

        System.out.println("TO ENTER ALL THE ELEMENTS OF THE FIRST ARRAYLIST AS THE HASHMAP KEY AND ALL THE ELEMENTS OF THE SECOND ARRAYLIST AS THE HASHMAP VALUE: ");
        for(int key : keys) {
            myHashMap.put(keys, values);
        }
        System.out.println(myHashMap);

        Map<Integer, String> myHashMap2 = new HashMap<>();

        System.out.println("TO ENTER EACH ELEMENT OF THE FIRST ARRAYLIST AS THE HASHMAP KEYS AND EACH ELEMENT OF THE SECOND ARRAYLIST AS THE HASHMAP VALUES: ");
        // WHEN CONVERTING FROM ARRAYLIST TO HASHMAP, THE HASHMAP WILL NOT NECESSARILY FOLLOW THE SAME ORDER AS THE ARRAYLIST.
        int nextIndex = 0;
        for(int key : keys) {
            myHashMap2.put(key, values.get(nextIndex));
            nextIndex++;
        }

        System.out.println(myHashMap2);

    }

}
