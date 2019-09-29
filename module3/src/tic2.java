import java.util.Scanner;

public class tic2 {
    private String[][] board;
    private boolean isXTurn;
    private String marker;
    private boolean winner;

    public void makeBoard(){
        int counter = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = "" + (counter);
                counter ++;

            }
        }
    }

    // make the game and initialize
    public tic2(String[][] board) {
        this.board = board;
        this.isXTurn = true;
        makeBoard();
    }

    // add move
    public void addMove() {
        System.out.println("Input a number between 0 and 8");
        Scanner posOfPlayer = new Scanner(System.in);
        String move = posOfPlayer.nextLine();
        if(move.equalsIgnoreCase("0")){
            this.board[0][0] = marker;
        }else if(move.equalsIgnoreCase("1")){
            this.board[0][1] = marker;
        }else if(move.equalsIgnoreCase("2")){
            this.board[0][2] = marker;
        }else if(move.equalsIgnoreCase("3")){
            this.board[1][0] = marker;
        }else if(move.equalsIgnoreCase("4")){
            this.board[1][1] = marker;
        }else if(move.equalsIgnoreCase("5")){
            this.board[1][2] = marker;
        }else if(move.equalsIgnoreCase("6")){
            this.board[2][0] = marker;
        }else if(move.equalsIgnoreCase("7")){
            this.board[2][1] = marker;
        }else if(move.equalsIgnoreCase("8")){
            this.board[2][2] = marker;
        }

    }

    // whos turn
    public void whoTurn(){
        if(isXTurn){
            System.out.println("X is up");
            marker = "X";
            isXTurn = false;
        } else{
            System.out.println("Y is up");
            marker = "O";
            isXTurn= true;

        }
    }

    // print the board
    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print("[" + this.board[i][j] + "]");
            }

            System.out.println("\n");
        }
    }

    // detect if winner
    public boolean winner(){
        // row check
        for (int i = 0; i < this.board.length; i++) {
            if(this.board[i][0].equals(this.board[i][1])){
                if(this.board[i][0].equals(this.board[i][2])){
                    winner = true;
                    return winner;
                }
            }
        }
        // column check
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[1].length; j++) {
                if(this.board[0][j].equals(this.board[1][j])){
                    if(this.board[0][j].equals(this.board[1][j])){
                        winner = true;
                        return winner;
                    }

                }

            }
        }

        // check crosses one way
        if(this.board[0][0].equals(this.board[2][2])){
            if(this.board[0][0].equals(this.board[1][1])){
                winner = true;
                return winner;
            }

        }

        // check crosses another way
        if(this.board[0][2].equals(this.board[2][0])){
            if(this.board[0][2].equals(this.board[1][1])){
                winner = true;
                return winner;
            }

        }
        return false;
    }


    // tell who winner is
    public void isWinner() {
        if(winner){
            if(isXTurn){
                System.out.println("Player X won!");
            }else{
                System.out.println("Player Y won!");
            }
        }else{
            whoTurn();
        }
    }

    // restart game
    public void restartGame(){
        // you probably want to ask
        if(winner){
            System.out.println("done");
            makeBoard();
            printBoard();
        }else{
            whoTurn();
        }
    }
}

