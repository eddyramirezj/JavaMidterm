package datastructure;

import java.util.ArrayList;
import java.util.Iterator;

public class UseArrayList {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use ArrayList that includes using the add, peek, remove & retrieve methods.
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        ArrayList<Integer> myArrayList = new ArrayList<>();

        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        System.out.println("THE ELEMENTS OF THE ARRAYLIST AFTER ADDING ELEMENTS WITH THE ADD() METHOD: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + ",");
        }

        myArrayList.remove(3);

        System.out.println("\nTHE ELEMENTS OF THE ARRAYLIST AFTER DELETING AN ELEMENT WITH THE REMOVE() METHOD: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i)+ ",");
        }

        System.out.println("\nRETRIEVING AN ELEMENT OF THE ARRAYLIST BY ITS INDEX, USING THE GET() METHOD: " + myArrayList.get(0));

        System.out.println("\nITERATING THROUGH THE ELEMENTS OF THE ARRAYLIST WITH AN ITERATOR: ");

        Iterator<Integer> myIterator = myArrayList.iterator();

        for (int number : myArrayList) {
            System.out.println(myIterator.next());
        }

    }



}
