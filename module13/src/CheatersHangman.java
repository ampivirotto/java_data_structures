import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CheatersHangman {

    static Set correctGuesses;
    static Set incorrectGuess;
    static int wordLength;
    static int numGuesses;


    public static Map<Integer, List> readDictionary(String filename){
        Map<Integer, List> mainDictionary = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line = line.strip();
                int charCount = line.length();

                if(mainDictionary.containsKey(charCount)){
                    List list =  mainDictionary.get(charCount);
                    list.add(line);
                    mainDictionary.put(charCount, list);
                }else{
                    List list = new ArrayList();
                    list.add(line);
                    mainDictionary.put(charCount, list);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return mainDictionary;
    }

    public static Integer playGame(Scanner input, Map<Integer, List> mainDict){
        //Introduction
        System.out.println("Welcome to Hangman!");
        System.out.println("How many guesses do you want to make?");
        numGuesses = input.nextInt();
        System.out.println("How long of a word do you want to guess?");
        wordLength = input.nextInt();

        //start word length
        String start = "";
        for (int i = 0; i < wordLength; i++) {
            start+= "_ ";
        }
        System.out.println(start);

        //rounds of Hangman
        for (int i = 0; i < numGuesses; i++) {
            System.out.println("What's your next guess? ");
            String guess = input.next();
            if(correctGuesses.contains(guess) || incorrectGuess.contains(guess)){
                System.out.println("You've already chosen that letter.");
            }else{

            }
        }

        // check to see if player wants to play again
        System.out.println("Do you want to play again?");

        String response = input.nextLine();
        if(response.toLowerCase() == "no"){
            return 0;
        }else{
            return 1;
        }
    }


    public static Map<Integer, List> generateWordFamilies(Set guesses, List wordList) {


    }


    public static List chooseNewWordList(Map<Integer, List> families){


    }

    public static void main(String[] args) {

        Map<Integer, List> mainDictionary = readDictionary("dictionary.txt");

        Scanner userInput = new Scanner(System.in);

        int continuePlaying = 1;

        while(continuePlaying == 1){
            continuePlaying = (userInput, mainDictionary);
        }

        System.out.println("Thanks for playing!");


    }
}
