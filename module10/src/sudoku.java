public class sudoku {

    public static boolean valid(int[][] board, int row, int pos, int num){
        // check columns and rows
        for (int i = 0; i < board.length ; i++) {
            //checks things in col
            if(board[i][pos] == num){
                return false;
            }
            //checks things in row
            if(board[row][i] == num) {
                return false;
            }
        }
        //check boxes of nine
        if( row == 0 | row == 3 | row == 6) {
            for (int i = row; i < row + 3; i++) {
                if (pos == 0 || pos == 3 || pos == 6) { //start of box
                    if (board[i][pos + 1] == num || board[i][pos + 2] == num) {
                        return false;
                    }
                } else if (pos == 2 || pos == 5 || pos == 8) { //end of box
                    if (board[i][pos - 1] == num || board[i][pos - 2] == num) {
                        return false;
                    }
                } else {
                    if (board[i][pos - 1] == num || board[i][pos + 1] == num) {
                        return false;
                    }
                }
            }
        }else if( row == 2 | row == 5 | row == 8){
            for (int i = row; i > row -3; i--) {
                if (pos == 0 || pos == 3 || pos == 6) { //start of box
                    if (board[i][pos + 1] == num || board[i][pos + 2] == num) {
                        return false;
                    }
                } else if (pos == 2 || pos == 5 || pos == 8) { //end of box
                    if (board[i][pos - 1] == num || board[i][pos - 2] == num) {
                        return false;
                    }
                } else {
                    if (board[i][pos - 1] == num || board[i][pos + 1] == num) {
                        return false;
                    }
                }
            }
        }else{
            if (pos == 0 || pos == 3 || pos == 6) { //start of box
                if (board[row][pos + 1] == num || board[row][pos + 2] == num) {
                    return false;
                }
            } else if (pos == 2 || pos == 5 || pos == 8) { //end of box
                if (board[row][pos - 1] == num || board[row][pos - 2] == num) {
                    return false;
                }
            } else {
                if (board[row][pos - 1] == num || board[row][pos + 1] == num) {
                    return false;
                }
            }
            if (pos == 0 || pos == 3 || pos == 6) { //start of box
                if (board[row+1][pos + 1] == num || board[row+1][pos + 2] == num) {
                    return false;
                }
            } else if (pos == 2 || pos == 5 || pos == 8) { //end of box
                if (board[row+1][pos - 1] == num || board[row+1][pos - 2] == num) {
                    return false;
                }
            } else {
                if (board[row+1][pos - 1] == num || board[row+1][pos + 1] == num) {
                    return false;
                }
            }
            if (pos == 0 || pos == 3 || pos == 6) { //start of box
                if (board[row-1][pos + 1] == num || board[row-1][pos + 2] == num) {
                    return false;
                }
            } else if (pos == 2 || pos == 5 || pos == 8) { //end of box
                if (board[row-1][pos - 1] == num || board[row-1][pos - 2] == num) {
                    return false;
                }
            } else {
                if (board[row-1][pos - 1] == num || board[row-1][pos + 1] == num) {
                    return false;
                }
            }
        }

        //if nothing returns false, then return true
        return true;
    }

    public static boolean solve(int[][] board){
        // first we start nested for loops to go box by box of the sudoku puzzle
        //for row in rows
        for (int i = 0; i < board.length; i++) {
            //for col in each row
            for (int j = 0; j < board.length; j++) {
                //find out if the cell we're at is empty indicated with 0
                if (board[i][j] == 0) {
                    // then we can start looping through possible numbers
                    for (int num = 1; num < 10; num++) {
                        int row = i;
                        int column = j;
                        if (valid(board, row, column, num)) { //we check to see if its valid using function
                            board[i][j] = num;  //if valid set the position as number of interest
                            if (solve(board) == true) { // if true we're done - starts backtracking recursively
                                return true;
                            } else {
                                board[i][j] = 0;
                            }//end if else
                        }//end if check for validity
                    }//end for loop to find number
                    return false; //return false
                }// end if statement checking to see if cell of interest is empty
            }//end inner for loop col
        }//end outer for loop row
        return true; // return true, if gone through both for loops to end
    }

    public static void print(int[][] board){
        for (int i = 0; i < board.length; i++) {
            if (i == 0){
                System.out.println("_________________________________________________"); //print top
            }
            for(int j =0; j< board[i].length; j++){
                if(j == 0){
                    System.out.print("|\t");
                }
                System.out.print(board[i][j] + "\t");
                int threes = j + 1;
                if (threes % 3 == 0){
                    System.out.print("|\t"); //print lines between boxes vertically
                }
            }
            System.out.println("");
            int thr = i + 1;
            if(thr % 3 == 0) {
                System.out.println("_________________________________________________"); //print lines between boxes horizontally
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,3,0,2,0,6,0,0},
                {9,0,0,3,0,5,0,0,1},
                {0,0,1,8,0,6,4,0,0},
                {0,0,8,1,0,2,9,0,0},
                {7,0,0,0,0,0,0,0,8},
                {0,0,6,7,0,8,2,0,0},
                {0,0,2,6,0,9,5,0,0},
                {8,0,0,2,0,3,0,0,9},
                {0,0,5,0,1,0,3,0,0}};
        print(board);

        boolean solved = solve(board);
        System.out.println(solved);
        print(board);
    }
}
