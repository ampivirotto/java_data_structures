import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/*
    Cheating Hangman
 */

public class CheatersHangman {
    static Set<String> correctGuesses = new HashSet<String>();
    static Set<String> incorrectGuess = new HashSet<String>();
    static int wordLength = -1;
    static int numGuesses = -1;
    static String key;
    private static List words;

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
                    list.add(line.toLowerCase());
                    mainDictionary.put(charCount, list);
                }else{
                    List list = new ArrayList();
                    list.add(line.toLowerCase());
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

    // need to use this to create the word family map //
    public static Map<String, List<String>> generateWordFamilies(String guess, List<String> words) {

        // this will be what is returned //
        HashMap<String, List<String>> wordChoices = new HashMap<>();

        // loop through possible words
        for(String word : words){
            // turn the key into a string from list
            List<String> stringList = new ArrayList<>();

            // make key for the word
            char[] ch = word.toCharArray();
            for (char c : ch) { // find the key
                char chLower = Character.toLowerCase(c);
                if (chLower == guess.charAt(0)) {
                    stringList.add(guess);
                } else if(!correctGuesses.isEmpty()){
                    String newchar = null;

                    for (String item : correctGuesses) {
                        if (chLower == item.charAt(0)) {
                            newchar = item;
                        }
                    }
                    if (newchar != null) {
                        stringList.add(newchar);
                    } else {
                        stringList.add("_");
                    }
                }else{
                    stringList.add("_");
                }
            }
            //turn key into string
            String listString = "";
            for(String item: stringList){
                listString += item;
            }

            // either add word to the key if it exists
            if(wordChoices.containsKey(listString)){
                wordChoices.get(listString).add(word);
            } else { // if key doesn't exist make the key and new list
                List<String> newList = new ArrayList<>();
                newList.add(word);
                wordChoices.put(listString, newList);
            }
        }
        return wordChoices;
    }

    public static void playGame(Scanner input, Map<Integer, List> mainDict){
        //start word length
        String start = "";
        //HashMap<String, List<String>> hash_map = new HashMap<String, List<String>>();
        Map<String, List<String>> hash_map = null;
        for (int i = 0; i < wordLength; i++) {
            start+= "_ ";
        }
        System.out.println(start);
        //rounds of Hangman
        for (int i = 1; i <= numGuesses; i++) {
            //start of turn
            System.out.println("CORRECT GUESSES: " + correctGuesses);
            System.out.println("INCORRECT GUESSES: " + incorrectGuess);
            System.out.println("What character would you like to guess? ");

            //get guess from user
            String guess = input.next();

            //check to see if that letter has been guessed already
            if(correctGuesses.contains(guess) || incorrectGuess.contains(guess)){ //if it has that's the end of your turn
                System.out.println("You've already guessed that letter.");
            }else{ //if not then we'll actually start the turn
                // need to add the magic of checking words and families for guess
                if (i == 1) {
                    // if this is the first round, we're still using the main dictionary
                    List wordsOfXLength = mainDict.get(wordLength);
                    hash_map = generateWordFamilies(guess, wordsOfXLength);
                    //get new List
                    words = chooseNewWordList(hash_map, guess);
                    //output key
                    System.out.println(key);
                } else {
                    //get word families
                    hash_map = generateWordFamilies(guess, words);
                    // get new list
                    words = chooseNewWordList(hash_map, guess);
                    System.out.println(key);
                }

            }
            System.out.println("Guesses left: " + (numGuesses - i));

            if(!key.contains("_")){
                System.out.println("You've won!  The word was " + key);
                break;
            }else{
                if(numGuesses  - i == 0){
                    System.out.println("You've lost.  The word was " + words.get(0));
                }
            }
        }
    }


    public static List chooseNewWordList(Map<String, List<String>> families, String guess){

        int max = 0;
        for (Map.Entry<String, List<String>> entry : families.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                key = entry.getKey();
            }
        }

        //add to incorrect or correct guesses
        Boolean guessCorrect = false;
        char[] ch = key.toCharArray();
        for (char c : ch) { // find the key
            char chLower = Character.toLowerCase(c);
            if (chLower == guess.charAt(0)) {
                correctGuesses.add(guess);
                guessCorrect = true;

            }
        }
        if (guessCorrect == false){
            incorrectGuess.add(guess);
        }
        return families.get(key);
    }

    public static void main(String[] args) {
        //System.out.println(mainDictionary);
        Scanner userInput = new Scanner(System.in);
        int continuePlaying = 1;
        // Read dictionary
        Map<Integer, List> mainDictionary = readDictionary("dictionary.txt");
        while(continuePlaying == 1){ // can change to boolean logic
            // Init.
            System.out.println("Welcome to Hangman!");
            System.out.println("How many guesses do you want to make?");
            numGuesses = userInput.nextInt();
            System.out.println("How long of a word do you want to guess?");
            wordLength = userInput.nextInt();

            //start playing the game
            playGame(userInput, mainDictionary);

            // check to see if player wants to play again // Move this..
            System.out.println("Do you want to play again?");
            String response = userInput.next();
            if (response.equalsIgnoreCase("no")) { //
                continuePlaying = 0;
            } else{
                continuePlaying = 1;
                correctGuesses.clear();
                incorrectGuess.clear();
            }
        }
        System.out.println("Thanks for playing!");
    }
}