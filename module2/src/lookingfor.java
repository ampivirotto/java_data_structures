import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class lookingfor {
    public static int countDigits(int num) {
        //take absolute value
        int newnum = Math.abs(num);

        //log of number
        double lognum = Math.log10(newnum);

        int n = 0;

        //figure out how many digits
        int counter = 1;
        while(counter < 100){
            if(lognum < counter){
                n = counter;
                break;
            }else{
                counter+=1;
            }
        }
        return n;
    }

    public static int nthDigitBack(int n, int num){
        //first got to split the number into its digits
        //find number of digits
        int numdigits = countDigits(num);

        //make sure n falls within the number of digits
        if (n>= numdigits){
            return 0;
        }
        //make an empty array
        int[] digits = new int[numdigits];

        // add to array
        for (int i = 0; i < numdigits; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits[n];

    }

    public static int nthDigit(int n, int num){
        //first got to split the number into its digits
        //find number of digits
        int numdigits = countDigits(num);

        //make sure n falls within the number of digits
        if (n>= numdigits){
            return 0;
        }
        //make an empty array
        int[] digits = new int[numdigits];

        // add to array - opposite direction of nthDigitBack
        for (int i = numdigits-1; i >=0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits[n];
    }

    public static void updateTally(int n, int num, int[] tally){
        // find the digit of choice
        int digit = nthDigit(n, num);
        tally[digit] +=1;
    }

    public static void nthDigitTally(int n, int[] nums, int[] tally){
        // might be able to make tally variable a global variable so that it can be seen
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            updateTally(n, num, tally);
        }
    }

    public static int[] readMysteriousNumbers(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);

        int counter = 1;
        int[] fin = new int[counter];

        while(scan.hasNextInt()){
            int[] temp = new int[counter];
            for (int i = 0; i < temp.length-1; i++) {
                temp[i] = fin[i];
            }
            temp[counter-1] = scan.nextInt();
            fin = temp;
            counter +=1;
        }
        return fin;
    }

    public static void printTally(int[] tally){
        for (int i = 0; i < tally.length; i++) {
            System.out.println(i + ": " + tally[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        // read in n from user
        System.out.println("Please give me a whole number: ");
        int n = scan.nextInt();

        // read in filename from user
        String filename = "grape_data.txt";

        // get list from file
        int[] filenums = readMysteriousNumbers(filename);

        // get tally
        int[] tally = new int[10];
        nthDigitTally(n, filenums, tally);

        //print
        printTally(tally);

    }
}
