package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int maxLimit = 2000;
    private static final int minLimit = 1000;
    private static final int structerSize = 1000;
    private static final int ELEMS = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        final List<Integer> num = new ArrayList<>();
        for(int i = minLimit; i < maxLimit; i++) {
            num.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
         final List<Integer> num2 = new LinkedList<>(num);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int tmp = num.get(0);
        num.set(0, num.get(structerSize - 1));
        num.set(structerSize - 1, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int i : num) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        
            UseListsAndMaps.executeTimeReading(num);
            UseListsAndMaps.executeTimeReading(num2);


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        int readingTime = 1000;
        long time = System.nanoTime();

        for(int i = 0; i < readingTime; i++) {
            System.out.println(num.get(num.size()/2));
        }

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println("Reading " + readingTime + " time a data require for an arrayList:" + millis + "ms");

        /*-------------------------------------------------------------- */
        long time2 = System.nanoTime();

        for(int i = 0; i < readingTime; i++) {
            System.out.println(num.get(num.size()/2));
        }

        time2 = System.nanoTime() - time2;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time2);

        System.out.println("Reading " + readingTime + " time a data require for an linkedlist:" + millis1 + "ms");



        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

         final Map<String, Long> continents = new HashMap<>();

         continents.put("Africa", 1110653000L);
         continents.put("Americas", 972005000L);
         continents.put("Antarctica", 0L);
         continents.put("Asia", 4298723000L);
         continents.put("Europe", 742452000L);
         continents.put("Oceania", 38304000L);
            
         
        /*
         * 8) Compute the population of the world
         */
         long populationSum = 0;
        for ( Long i : continents.values()) {
            populationSum += i;
        }

        System.out.println("Max population is: " + populationSum);
    }

    private static void addElementToDataStructure(List<Integer> dataStracture) {
        
        for (int i = 0; i < ELEMS; i++) {
           dataStracture.add(i);
        }
    }

    private static void printOutResult(List<Integer> dataStructure, final long time, final long millis) {

        System.out.println(// NOPMD
            "Inserting "
                + dataStructure.size()
                + " integer elements into arraylist as first and linked list as second"
                + time
                + "ns ("
                + millis
                + "ms)"
        );

    }

    private static void executeTimeReading(List<Integer> dataStructure) {
        long time = System.nanoTime();
        
        UseListsAndMaps.addElementToDataStructure(dataStructure);        
       
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        
        UseListsAndMaps.printOutResult(dataStructure, time, millis);


    }
}
