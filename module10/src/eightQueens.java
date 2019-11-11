public class eightQueens {
    public static boolean valid(int[][] board, int row, int pos){
        // check just rows above the row you're on
        int counter = 1;
        for (int i = row-1; i >= 0 ; i--) {
            if(row != 0){
                //checks things directly above the pos
                if(board[i][pos] == 1){
                    return false;
                }
                //checks things on the left diagonal
                if(pos> 0 && (pos - counter >= 0)) {
                    if (board[i][pos - counter] == 1) {
                        return false;
                    }
                }
                //checks things on the right diagonal
                if(pos<board.length-1 && (pos + counter < board.length)){
                    if(board[i][pos+counter] == 1){
                        return false;
                    }
                }
                counter ++;
            }
        }
        //if nothing returns false, then return true
        return true;
    }

    public static boolean solve(int[][] board, int row){
        if(row>= board.length){
            return true;
        }
        for (int i = 0; i < board[row].length; i++) {
            if(valid(board, row, i)){
                board[row][i] = 1;
                if(solve(board, row+1) == true){
                    return true;
                }
            }
        }
        for (int i = 0; i < board[row].length; i++) {
            if(board[row][i] == 1){
                board[row][i] = 0;
            }
            if(board[row-1][i] == 1){
                board[row-1][i] = 0;
            }
        }
        //print(board);
        return false;
    }
    public static void print(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for(int j =0; j< board[i].length; j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("");

        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        boolean solved = solve(board, 0);
        print(board);
        System.out.println(solved);
    }
}
