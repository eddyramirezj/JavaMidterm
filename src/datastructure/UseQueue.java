package datastructure;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UseQueue {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Queue that includes add, peek, remove & poll elements.
         * Use For-Each loop and While-Loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        Queue<Integer> myQueue = new PriorityQueue<>();

        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(40);
        myQueue.add(50);

        System.out.println("IN A QUEUE, WE CAN ONLY PEEK AT THE FIRST ELEMENT: ");

            System.out.print(myQueue.peek());


        myQueue.remove();

        System.out.println("\nIN A QUEUE, WE CAN ONLY REMOVE THE FIRST ELEMENT, AND SO ON (HENCE, FIRST IN, FIRST OUT. SEE HOW AFTER REMOVE() METHOD, THE FIRST VALUE IS NOW 20): ");

            System.out.print(myQueue.peek());

        System.out.println("\nYOU CAN ONLY PEEK THE FIRST ELEMENT, BUT YOU CAN STILL ITERATE THROUGH ALL THE ELEMENTS OF THE QUEUE WITH AN ITERATOR: ");

        Iterator<Integer> myIterator = myQueue.iterator();

        for (int number : myQueue) {
            System.out.println(myIterator.next());
        }

    }

}
