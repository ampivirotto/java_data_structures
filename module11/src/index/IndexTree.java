
package index;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree() {
	}

	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root = add(this.root, word, lineNumber);
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if( root == null){
			return new IndexNode(word, lineNumber);
		}
		int compare = word.compareTo(root.word);
		if( compare == 0){
			root.occurences ++;
			root.list.add(lineNumber);
			return root;
		}else if (compare < 0){
			root.left = add(root.left, word, lineNumber);
			return root;
		}else{
			root.right = add(root.right, word, lineNumber);
			return root;
		}
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
		return contains(this.root, word);
	}

	public boolean contains(IndexNode root, String word){
		if(root == null){
			return false;
		}
		int Comparison = word.compareTo(root.word);
		if(Comparison == 0){
			return true;
		} else if (Comparison < 0){
			return contains(root.left, word);
		} else {
			return contains(root.right, word);
		}
	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root = this.delete(this.root, word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
		if(root == null){
			return null;
		}
		int compare = word.compareTo(root.word);
		if (compare < 0){
			root.left = delete(root.left, word);
			return root;
		}else if (compare > 0){
			root.right = delete(root.right, word);
			return root;
		}else{
			if(root.left == null && root.right == null){
				return null;
			}else if (root.left != null && root.right == null){
				return root.left;
			}else if (root.left == null && root.right != null){
				return root.right;
			}else{
				IndexNode current = root.left;
				while( current.right != null){
					current = current.right;
				}
				root.word = current.word;
				root.occurences = current.occurences;
				root.list = current.list;
				root.left = delete(root.left, root.word);
				return root;
			}
		}
	}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		inorderTraverse(this.root, 1);
	}

	private void inorderTraverse(IndexNode root, int depth){
		if (root == null){
			for (int i = 1; i < depth; i++) {
				System.out.print("\t");; // indentation
			}
			System.out.println("null");
		}else{
			inorderTraverse(root.left, depth+1);
			for (int i = 1; i < depth; i++) {
				System.out.print("\t");; // indentation
			}
			System.out.println(root.toString());
			inorderTraverse(root.right, depth+1);
		}
	}
	
	public static void main(String[] args){
		IndexTree index = new IndexTree();
		
		// add all the words to the tree
		String fileName = "pg100.txt";

		try {
			Scanner scanner = new Scanner(new File(fileName));
			int LineNum = 1;
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] words = line.split("\\s+");
				for(String word : words) {
					word = word.replaceAll("\\p{Punct}", "");
					if (word.compareTo("") != 0) {
						index.add(word, LineNum);
					}
				}
				LineNum ++;
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// print out the index
		index.printIndex();

		// test removing a word from the index
		index.delete("winds");
		//index.printIndex();
		
	}
}
