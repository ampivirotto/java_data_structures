public class fibonacci {
    public static void main(String[] args) {
        int eventot = 2; // variable to contain total of even number set to 2 to start
        int num1 = 1; // first number in sequence
        int num2 = 2; // second number in sequence
        int counter = 0; // counter to figure out which num should be replaced
        int temp = 0; // temp variable to contain next number in sequence
        while (temp < 4e6) { // loop until last number is over 4e6
            temp = num1 + num2; // find next variable in sequence
            if (temp % 2 == 0){ //if even add to total
                eventot += temp;
            }
            if (counter % 2 == 0){ // if counter is even replace num1
                num1 = temp;
            }else{ // if counter is odd replace num2
                num2 = temp;
            }
            counter ++; // next number in counter
        }
        System.out.println(eventot); // output total

    }
}
