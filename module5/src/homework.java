import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class homework {

    public static <E> boolean unique(ArrayList<E> list){  //takes in generic list and returns true if all items unique
        for (int i = 0; i < list.size(); i++) { //start with item 1 in list
            for(int j = i +1; j<list.size(); j++){ //check it against all other items
                if (list.get(i).equals(list.get(j))){ //compare items, if not equal return false
                    return false;
                }
            }
        }
        return true; //if nothing is the same, return true
    }

    public static ArrayList<Integer> allMultiples(ArrayList<Integer> list, int num){ //loop through items to check for multiples of num
        ArrayList<Integer> updateList = new ArrayList<>(); //create empty array list to add to
        for (int i = 0; i < list.size(); i++) { //loop through each item in list
            if(list.get(i) % num == 0){ //check to see if item in list is divisible by num
                updateList.add(list.get(i));  //if so add to updated list
            }
        }
        return updateList; //return updated list
    }

    public static ArrayList<String> allStringsOfSize(ArrayList<String> list, int num) { //loop through items and add all strings of size num to new list
        ArrayList<String> updateList = new ArrayList<>(); // create empty list to add to

        for (int i = 0; i < list.size(); i++) { //loop through each item in list
            if(list.get(i).length() == num) { //if item is the size num
                updateList.add(list.get(i)); //add item to updatedList
            }
        }
        return updateList; //return updated list
    }

    public static ArrayList<String> stringToListOfWords(String word){ //take string and divide it into its words
        ArrayList<String> newList = new ArrayList<>(); //create empty list to add to
        String[] list = word.split("\\s"); //strip the space between these words
        for (int i = 0; i < list.length; i++) { //goes through the list word by word
            newList.add(list[i].replaceAll("[^a-zA-Z]","")); //adds it to a new list with punctuation stripped
        }
        return newList; //return newList
    }

    public static <E> void removeAllInstances(ArrayList<E> list, int item){ //takes in a list and removes instances of item
        boolean repeat = true;
        while(repeat == true) {
            repeat = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    list.remove(i);
                    repeat = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        /*
        //test uniqueness
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 3, 4));
        boolean output1 = unique(list1);

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("hi", "hello", "ciao"));
        boolean output2 = unique(list2);

        System.out.println(list1 + " " + output1);
        System.out.println(list2 + " " + output2);

        //test allMultiples
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(10, 11, 22, 30, 50, 67));
        ArrayList<Integer> outputList = new ArrayList<>(allMultiples(list3, 10));
        System.out.println(outputList);

        //test allStringsOfSize
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("you", "been", "four", "six"));
        ArrayList<String> outputList2 = new ArrayList<>(allStringsOfSize(list4, 4));
        System.out.println(outputList2);

        String sentence = "Hi, how are you doing today? I am fine.";
        ArrayList<String> outputList3 = new ArrayList<>(stringToListOfWords(sentence));
        System.out.println(outputList3);

         */

        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1, 4, 5, 6, 5, 5, 2, 4, 3, 3, 5, 5, 5, 5, 6));
        removeAllInstances(list5, 5);
        System.out.println(list5);

    }
}
