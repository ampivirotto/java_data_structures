public class Rabbit2 extends Animal {
    private boolean canSeeFoxNow = false;
    private boolean haveSeenFox = false;
    private int distanceToFox;
    private int directionToFox;
    private int currentDirection;
    private int turnsSinceFox;

    public Rabbit2(Model model, int row, int column) {

        super(model, row, column);
    }

    int decideMove() {
        // look all around for fox - taken from fox class
        canSeeFoxNow = false;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.FOX) {
                canSeeFoxNow = haveSeenFox= true;
                directionToFox = i;
                distanceToFox = distance(i);
                turnsSinceFox = 0;
            }
        }
        turnsSinceFox+=1;
        if (canSeeFoxNow == true){
            int move = Model.turn((directionToFox), 5);
            if (look(move) == Model.BUSH){
                return Model.turn((directionToFox), 3);
            }
            if (look(move) == Model.EDGE){
                return Model.turn(directionToFox, 3);
            }
            return move;
        }else{
            if(turnsSinceFox > 5){
                int directionToEdge = 0;
                for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
                    if (look(i) == Model.EDGE) {
                        directionToEdge = i;
                        break;
                    }
                }
                return Model.turn((directionToEdge), 4);
            }else{
                return Model.turn(directionToFox, 5);
            }
        }

    }
}
