public class multiples {
    public static void main(String[] args) {
        int total = 0; // set total variable
        for(int i = 0; i< 1000; i++){ // loop while i is less than 1000
            if((i % 3 == 0) || (i % 5 == 0)){ // if divisible by 3 or 5 add to total
                total += i;
            }
        }
        System.out.println(total); //output total
    }
}
