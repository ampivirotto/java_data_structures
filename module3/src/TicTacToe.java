public class TicTacToe {
    private String[][] board;
    private boolean isXTurn;
    private String winner;
    int counter;
    private int[] used = {9, 9, 9, 9, 9, 9, 9, 9, 9};

    // initialize board and move
    public TicTacToe(String[][] board) {
        this.board = board;
        this.isXTurn = true;
        initializeBoard();
    }

    // initalize board to space numbers so they can know what choices for moves
    public void initializeBoard(){
        int counter = 0;
        for (int i = 0; i < this.board.length; i++) {
            for(int j = 0; j< this.board[i].length; j++){
                this.board[i][j] = "" + counter;
                counter ++;
            }
        }
    }

    public void addMove(int choice){
        // figure out which player is making the move and what to add to board
        String move;
        if(this.isXTurn == true) {
            move = "X";
            this.isXTurn = false;
        }else{
            move = "O";
            this.isXTurn = true;
        }

        // make sure what they chose wasn't already taken
        for (int i = 0; i < used.length; i++) {
            if(used[i] == choice){
                choice = 10;
            }else if (i == used.length -1){
                used[counter] = choice;
            }
        }


        // for each choice update the board
        if(choice == 0){
            this.board[0][0] = move;
        }else if (choice == 1){
            this.board[0][1] = move;
        }else if (choice == 2){
            this.board[0][2] = move;
        }else if (choice == 3){
            this.board[1][0] = move;
        }else if (choice == 4){
            this.board[1][1] = move;
        }else if (choice == 5){
            this.board[1][2] = move;
        }else if (choice == 6){
            this.board[2][0] = move;
        }else if (choice == 7){
            this.board[2][1] = move;
        }else if (choice == 8){
            this.board[2][2] = move;
        }else{
            System.out.println("Invalid move, forfeit turn.");
        }
        counter ++;
    }

    public void displayBoard(){
        // loop through board to display each thing in 2d array
        for (int i = 0; i < this.board.length; i++) {
            for(int j = 0; j< this.board[i].length; j++){
                System.out.print("[" + this.board[i][j] + "]\t");
                //System.out.println(board[i][j]);
            }
            System.out.println("\n");
        }
    }

    public void whoTurn(){
        // tells who's turn it is
        if(this.isXTurn == true){
            System.out.println("X plays: ");
        }else{
            System.out.println("O plays: ");
        }
    }

    public boolean isWinner(){

        for (int i = 0; i < this.board.length; i++) {
            // check rows
           if (this.board[i][0].equals(this.board[i][1])) {
               if (this.board[i][0].equals(this.board[i][2])) {
                   winner = this.board[i][0];
                   return true;
               }
           }
           // check first diagnonal
           if(i == 0){
               if (this.board[i][0].equals(this.board[i+1][1])) {
                    if (this.board[i][0].equals(this.board[i+2][2])) {
                        winner = this.board[i][0];
                        return true;
                    }
                }
            }

           if (i == 2){
                if (this.board[i][0].equals(this.board[i-1][1])) {
                    if (this.board[i][0].equals(this.board[i-2][2])) {
                        winner = this.board[i][0];
                        return true;
                    }
                }
            }
        }

        // check columns
        for(int j = 0; j < this.board[0].length; j++){
            if (this.board[0][j].equals(this.board[1][j])){
                if (this.board[0][j].equals(this.board[2][j])){
                    winner = this.board[0][j];
                    return true;
                }
            }
        }
        return false;
    }

    public String whoWinner(){
        // returns which player is the winner
        return this.winner;
    }

    public void restart(){
        // returns the board to numbers
        initializeBoard();
        // sets winner to empty
        this.winner = "";
        //sets x to first turn and turns counter back to zero
        this.isXTurn = true;
        this.counter = 0;
    }
}
