public class tic2driver {
        public static void main(String[] args) {
            String[][] board = new String[3][3];
            tic2 thisGame = new tic2(board);

            System.out.println("Do you want to play a game?");
            System.out.println("Good, lets play Tic Tac Toe");
            System.out.println("\n");
            System.out.println("Here is the game board!");
            System.out.println("\n");
            thisGame.printBoard();

            System.out.println("There will be two players, X and Y");
            System.out.println("Player X will be up first");
            System.out.println("\n");

            int count = 0;
            while(count < 9){
                thisGame.whoTurn();
                thisGame.addMove();
                thisGame.printBoard();
                if(thisGame.winner() == true){
                    thisGame.restartGame();
                    count = 0;
                }
                count ++;
            }

        }
    }
