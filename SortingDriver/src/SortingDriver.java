import java.util.*;

/**
 * Assignment 4 for CS 1410
 * This program evaluates the bubble and selection sorts versus each other.
 *
 * @author James Dean Mathias
 * and me too @ScoutJarmanA02259147 lol ;)
 */
public class SortingDriver {
    public static void main(String[] args) {
        //header for results
        System.out.printf("--- Timing Results ---\n\n");

        //start of the main loop to step through various sizes of loops
        for(int size = 1000; size <= 10000; size += 1000) {
            //initialize sorting stats objects for the 2 methods
            SortingStats bubbleStats = new SortingStats();
            SortingStats selectionStats = new SortingStats();

            //generates 2 random arrays
            int[] bubbleArray = generateNumbers(size);
            int[] selectionArray = generateNumbers(size);

            //sorts each array with the 2 methods
            bubbleStats = bubbleSort(bubbleArray);
            selectionStats = selectionSort(selectionArray);

            //reports the results
            System.out.printf("Number of items      : %d\n", size);
            System.out.printf("Bubble sort time     : %d ms\n", bubbleStats.getTimeInMs());
            System.out.printf("Selection sort time  : %d ms\n\n", selectionStats.getTimeInMs());

        }
    }

    /**
     * start of functions
     */

    //function that generates an array of random numbers between 0-100000
    public static int[] generateNumbers(int howMany) {
        int[] randomArray = new int[howMany];
        for(int position = 0; position < howMany; position++) {
            randomArray[position] = (int)(Math.random() * 100000);
        }
        return randomArray;
    }

    //function to sort an array with a bubble sort method
    public static SortingStats bubbleSort(int[] data) {
        //starts time for the sort
        long timeStart = System.currentTimeMillis();

        //initialize a sorting stat object to keep track of the stats
        SortingStats bubbleSortOBJ = new SortingStats();

        //deceleration of some variables used to keep track of swaps and length of array
        boolean didSwap = false;
        int end = data.length - 1;

        //starts the loop
        do {
            //this is to reset didSwap at the beginning of each loop
            didSwap = false;

            //for loop to go through the array and start swapping and such
            for(int item = 0; item < end; item++) {
                //checks if value at (item) is in correct position in respect to (item + 1)
                if(data[item] > data[item + 1]) {
                    //makes the switch if needed
                    int temp = data[item];
                    data[item] = data[item + 1];
                    data[item + 1] = temp;
                    didSwap = true;

                    //increments swap count after swap
                    bubbleSortOBJ.incrementSwapCount();
                }
                //increments comparison after comparaison
                bubbleSortOBJ.incrementCompareCount();
            }
            //decrements end so as to not check last value multiple times
            end--;
        } while (didSwap);

        //gets ending time, and reports difference
        long timeEnd = System.currentTimeMillis();
        bubbleSortOBJ.setTime(timeEnd - timeStart);

        //returns the sorting stats object
        return bubbleSortOBJ;

    }

    //function to sort an array with a selection sort method
    public static SortingStats selectionSort(int[] data) {
        //starts time
        long timeStart = System.currentTimeMillis();

        //initializes a sorting stat obj for selection sort
        SortingStats selectionSortOBJ = new SortingStats();

        //starts outer for loop for the selection sort
        for(int start = 0; start < data.length - 1; start++) {
            //variable to hold the lowest value (we assume the first element is the lowest value)
            int minpos = start;

            //start of next for loop to compare items
            for(int scan = start + 1; scan < data.length; scan++) {
                //checks to see if the item is smaller than minpos
                if(data[scan] < data[minpos]) {
                    minpos = scan;
                }
                //increments the compare value after comparison
                selectionSortOBJ.incrementCompareCount();
            }
            //makes the swap after comparisons
            int temp = data[start];
            data[start] = data[minpos];
            data[minpos] = temp;
            //increments swap after swap
            selectionSortOBJ.incrementSwapCount();
        }

        //gets end time, and reports difference
        long timeEnd = System.currentTimeMillis();
        selectionSortOBJ.setTime(timeEnd - timeStart);

        //returns the sorting stat class for the selection sort
        return selectionSortOBJ;
    }

}