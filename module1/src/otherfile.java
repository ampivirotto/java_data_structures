import java.sql.SQLOutput;

public class otherfile {
    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i != 0) {
                return true;
            }//end if
        }// end for
        return false;
    }//end method

    public static void main(String[] args) {
        boolean pr = isPrime(10);
        System.out.println(pr);
    }

}
