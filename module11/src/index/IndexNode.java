package index;

import java.util.ArrayList;
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list =  new ArrayList<Integer>(); 
	
	
	
	IndexNode left;
	IndexNode right;
	
	
	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1

	public IndexNode(String word, int LineNum) {
		this.word = word;
		this.occurences = 1;
		list.add(LineNum);
	}

	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){
		return this.word + " appears on " + this.occurences + " lines.  Line numbers are " + this.list;
	}

}
