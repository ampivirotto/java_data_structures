import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class homework {

    public static <E> boolean unique(List<E> list){  //takes in generic list and returns true if all items unique
        for (int i = 0; i < list.size(); i++) { //start with item 1 in list
            for(int j = i +1; j<list.size(); j++){ //check it against all other items
                if (list.get(i).equals(list.get(j))){ //compare items, if not equal return false
                    return false;
                }
            }
        }
        return true; //if nothing is the same, return true  - quadratic
    }

    public static List<Integer> allMultiples(List<Integer> list, int num){ //loop through items to check for multiples of num
        List<Integer> updateList = new ArrayList<>(); //create empty array list to add to
        for (Integer item : list) { //loop through each item in list
            if (item % num == 0) { //check to see if item in list is divisible by num
                updateList.add(item);  //if so add to updated list
            }
        }
        return updateList; //return updated list  - linear
    }

    public static List<String> allStringsOfSize(List<String> list, int num) { //loop through items and add all strings of size num to new list
        List<String> updateList = new ArrayList<>(); // create empty list to add to

        for (String s : list) { //loop through each item in list
            if (s.length() == num) { //if item is the size num
                updateList.add(s); //add item to updatedList
            }
        }
        return updateList; //return updated list  - linear
    }

    public static List<String> stringToListOfWords(String word){ //take string and divide it into its words
        List<String> newList = new ArrayList<>(); //create empty list to add to
        String[] list = word.split("\\s"); //strip the space between these words
        for (String s : list) { //goes through the list word by word
            newList.add(s.replaceAll("[^a-zA-Z]", "")); //adds it to a new list with punctuation stripped
        }
        return newList; //return newList
    }

    public static <E> void removeAllInstances(List<E> list, E item){ //takes in a list and removes instances of item
        boolean repeat = true;  //set repeat to be true initially to start loop
        while(repeat) { //while repeat is true stay in loop
            repeat = false; //each time around repeat is set to false unless if statement trips
            for (int i = 0; i < list.size(); i++) { //for each item in list
                if (list.get(i).equals(item)) { //if item in list equals generic item parameter
                    list.remove(i); //remove item
                    repeat = true; //then set repeat to true to loop back through again to catch any repeats that may have been missed by indices changing
                }//end if
            }//end for
        }//end while
    }//end method

    public static void main(String[] args) {

        //test uniqueness 2.1
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 3, 4));
        boolean output1 = unique(list1);

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("hi", "hello", "ciao"));
        boolean output2 = unique(list2);

        System.out.println(list1 + " " + output1);
        System.out.println(list2 + " " + output2);

        //test allMultiples 2.2
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(10, 11, 22, 30, 50, 67));
        ArrayList<Integer> outputList = new ArrayList<>(allMultiples(list3, 10));
        System.out.println(outputList);

        //test allStringsOfSize 2.3
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("you", "been", "four", "six"));
        ArrayList<String> outputList2 = new ArrayList<>(allStringsOfSize(list4, 4));
        System.out.println(outputList2);


        //test stringToListOfWords 2.4
        String sentence = "Hi, how are you doing today? I am fine.";
        ArrayList<String> outputList3 = new ArrayList<>(stringToListOfWords(sentence));
        System.out.println(outputList3);

        //test removeAllInstances 2.5
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1, 4, 5, 6, 5, 5, 2, 4, 3, 3, 5, 5, 5, 5, 6));
        removeAllInstances(list5, 5);
        System.out.println(list5);

    }
}
