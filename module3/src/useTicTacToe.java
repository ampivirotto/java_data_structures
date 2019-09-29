import java.util.Scanner;

public class useTicTacToe {
    public static void main(String[] args) {
        // start game
        TicTacToe game = new TicTacToe(new String[3][3]);
        System.out.println("Let's Play TicTacToe!  Here's our board:");
        game.displayBoard();
        System.out.println("When it's your turn select the space you want to put your marker.");
        System.out.println("Player 1 is X and Player 2 is O.");

        Scanner scan = new Scanner(System.in);

        // start loop for game
        while (true) {
            //game continues while there's turns left
            while (game.counter < 9) {
                game.displayBoard();
                game.whoTurn();
                int move = scan.nextInt();
                game.addMove(move);
                if (game.isWinner() == true){
                    break;
                }
            }
            // throwaway since I'm using nextInt nextLine
            String throwaway = scan.nextLine();
            // if its a tie
            if (game.isWinner() == false) {
                System.out.println("It's a tie!");
                System.out.println("Do you want to play again? [y/n]: ");
                String replay = scan.nextLine();
                if (replay.equalsIgnoreCase("y")) {
                    game.restart();
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            } else if (game.isWinner() == true) { //winner
                System.out.println("Player " + game.whoWinner() + " wins!");
                System.out.println("Do you want to play again? [y/n]: ");
                String replay = scan.nextLine();
                if (replay.equalsIgnoreCase("y")) {
                    game.restart();
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
        }
    }
}
