import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;

public class sortingMethods {
    // static variables to keep track of
    private static int numComparisons = 0;
    private static int numExchanges = 0;
    private static long runTime = 0;

    private static int[] InsertionSort(int[] list) {
        // modified from Koffman and Wolfgang
        long startTime = System.nanoTime();
        for (int nextPos = 1; nextPos < list.length; nextPos++) {  // loop through items 1 through n-1 to sort each one
            int nextVal = list[nextPos]; //set value of item to sort
            while (nextPos > 0 && list[nextPos - 1] > nextVal) { // compare to all items before it in the list
                list[nextPos] = list[nextPos - 1];
                nextPos--;
                numComparisons ++;
            }
            list[nextPos] = nextVal; // when eventually the thing before it isn't less than it, trade it
            numExchanges ++;
        }
        long endTime = System.nanoTime();
        runTime = endTime-startTime;
        return list;
    }

    private static int[] QuickSort(int[] list){
        // modified from Koffman and Wolfgang
        long startTime = System.nanoTime();
        list = QuickSort(list, 0, list.length -1);
        long endTime = System.nanoTime();
        runTime = endTime-startTime;
        return list;
    }

    private static int[] QuickSort(int[] list, int first, int last){
        // modified from Koffman and Wolfgang
        if(first < last) {
            //partition
            int pivotIndex = partition(list, first, last);
            //sort left half
            QuickSort(list, first, pivotIndex-1);
            //sort right half
            QuickSort(list, pivotIndex+1, last);
        }
        return list;
    }

    private static int partition(int[] list, int first, int last){
        // modified from Koffman and Wolfgang and from
        // variety of websites including https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.html
        int pivot = list[first];
        int up = first+1;
        int down = last;
        int temp;

        if (up == down){
            if (list[up] < pivot){
                numComparisons++;
                list[first] = list[up];
                list[up] = pivot;
                numExchanges++;
                return up;
            }
        }
        while (up<down) {
            numComparisons++;
            if (list[up] >= pivot && list[down] < pivot) {
                numExchanges++;
                temp = list[up];
                list[up] = list[down];
                list[down] = temp;
            } else if ((up < last) && (list[up]) <= pivot) {
                up++;
            } else if ((down > first) && (list[down] > pivot)) {
                down--;
            }
        }
        temp = list[first];
        list[first] = list[up-1];
        list[up-1] = temp;
        numExchanges++;
        return up-1;
    }

    private static int[] TimSort(int[] list){
        // modified from Koffman and Wolfganga and websites: https://www.geeksforgeeks.org/timsort/ and https://hackernoon.com/timsort-the-fastest-sorting-algorithm-youve-never-heard-of-36b28417f399
        // TimSort is a combination of Insertion Sort and Merge Sort Algorithm
        // if less than the length of run - just run insertion sort
        // else in 1st pass reverse all runs of decreasing elements - should sort of runs of min size run
        // then merge all runs together
        long startTime = System.nanoTime();
        int run = 32;
        //sort individual arrays of size run (32 in my case) or less
        for (int i = 0; i < list.length; i+= run) { //use insertion sort for 32 len subarray
            TimInsertionSort(list, i, Math.min((i+31), (list.length-1)));
        }
        //merge arrays
        for(int size = run; size< list.length; size = 2 *size){ //each time size increases by double
            for(int left = 0; left< list.length; left+=2*size){
                int middle = Math.min((left + size -1), (list.length-1));  // choose minimum either actual middle or its at the end
                int right = Math.min((left + 2 * size -1), (list.length-1)); // choose minimum either actual end or the end of list
                TimMerge(list, left, middle, right);  // call tim Merge method
            }
        }

        long endTime = System.nanoTime();
        runTime = endTime-startTime;
        return list;
    }

    private static void TimMerge(int[] list, int lft, int middle, int rt){
        // modified from Koffman and Wolfgang and websites: https://www.geeksforgeeks.org/timsort/ and https://hackernoon.com/timsort-the-fastest-sorting-algorithm-youve-never-heard-of-36b28417f399
        int leftHalf = middle - lft + 1;  //figure out lengths of arrays
        int rightHalf = rt - middle;

        //make arrays of these lengths
        int[] left = new int[leftHalf];
        int[] right = new int[rightHalf];
        //separate items to 2 arrays
        for (int i = 0; i < leftHalf; i++) {
            left[i] = list[lft + i]; // add items to left half array
        }
        for (int i = 0; i < rightHalf; i++) {
            right[i] = list[middle + 1 + i]; //add items to right half array
        }

        int i = 0, j = 0, k = lft;
        //compare arrays , then merge
        while( i< leftHalf && j < rightHalf){
            numComparisons++;
            if (left[i] <= right[j]){ //compare
                list[k] = left[i]; //add to list
                numExchanges++;
                i++;
            }else{
                list[k] = right[j]; //add to list
                j++;
            }
            k++;
        }
        //copy what's left of left and right arrays over into the list
        while(i<leftHalf){
            list[k] = left[i];
            k++;
            i++;
        }
        while(j<rightHalf){
            list[k] = right[j];
            k++;
            j++;
        }
    }

    private static void TimInsertionSort(int[] list, int start, int stop){
        //modified from Insertion method above, from Koffman and Wolfgang, and from https://www.geeksforgeeks.org/timsort/
        for (int nextPos = start+1; nextPos <= stop; nextPos++) {  // loop through items 1 through n-1 to sort each one
            int nextVal = list[nextPos]; //set value of item to sort
            while (nextPos > start && list[nextPos - 1] > nextVal) { // compare to all items before it in the list
                list[nextPos] = list[nextPos - 1];
                nextPos--;
                numComparisons ++;
            }
            list[nextPos] = nextVal; // when eventually the thing before it isn't less than it, trade it
            numExchanges ++;
        }
    }

    private static void printArray(int[] array){
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void reset(){ //used to reset static variables
        numExchanges = 0;
        numComparisons = 0;
        runTime = 0;
    }

    private static double average(int[] array){
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum/array.length;
    }

    private static double averagel(long[] array){
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum/array.length;
    }

    public static void main(String[] args) throws IOException {
        // getting file ready to write to
        FileWriter output = new FileWriter("sorting_data_output.csv");
        PrintWriter writer = new PrintWriter(output);
        //header
        String header = "Length of List, Type, NumCompare, NumExchange, RunTime\n";
        writer.write(header);

        // sorting
        Random rand = new Random();
        for (int num = 10; num <= 10000; num*=10) {  // numbers per array to try methods with different sized arrays
            String line = String.valueOf(num) + ", ";
            for(int z = 0; z <3; z++){ //which method to use
                String method = "";
                long[] runt = new long[100];
                int[] numComp = new int[100];
                int[] numEx = new int[100]; // set all lists to empty

                for (int j = 0; j < 100; j++) {
                    int[] array = new int[num];  // creating empty array
                    for (int i = 0; i < array.length; i++) {  // filling array with random ints
                        array[i] = rand.nextInt();
                    }
                    if(z == 0) {
                        method = "InsertionSort,";
                        int[] sortedArray = InsertionSort(array);
                        runt[j] = runTime;
                        numComp[j] = numComparisons;
                        numEx[j] = numExchanges;
                        reset();

                    }else if( z == 1){
                        method = "QuickSort, ";
                        int[] sortedArray = QuickSort(array);
                        runt[j] = runTime;
                        numComp[j] = numComparisons;
                        numEx[j] = numExchanges;
                        reset();

                    }else{
                        method = "TimSort, ";
                        int[] sortedArray = TimSort(array);
                        runt[j] = runTime;
                        numComp[j] = numComparisons;
                        numEx[j] = numExchanges;
                        reset();
                    }
                }
                line += method + String.valueOf(average(numComp)) + ", " + String.valueOf(average(numEx)) + ", " + String.valueOf(averagel(runt)) ;
                writer.write(line + "\n");
                line = String.valueOf(num) + ", ";
            }
        }

        // closing writer connection
        writer.close();
    }
}
