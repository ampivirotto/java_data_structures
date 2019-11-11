public class permutation {

    public static void printPerms(String word){
        printPerms("", word);
    }

    private static void printPerms(String done, String rest){
        if(rest.equals("")){
            System.out.println(done);
        }else{
            for (int i = 0; i < rest.length(); i++) {
                printPerms(done + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        printPerms("helio");
    }
}

