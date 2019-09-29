public class Rabbit extends Animal {

    private boolean haveSeenFox = false;
    private boolean canSeeFoxNow = false;
    private int distanceToFox;
    private int directionToFox;
    private int directionToBush;
    private int distanceToBush;
    private int turnSinceFox = 0;
    private int directionToEdge;
    private int distanceToEdge;

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    public int decideMove() {

        // set seeing fox to false before we look
        canSeeFoxNow = false;

        // looking around for fox - taken from fox class
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            // look in each direction around you for fox
            if (look(i) == Model.FOX) {
                // reset see fox variable
                turnSinceFox = 0;

                // if you see the fox set variables, direction, distance
                canSeeFoxNow = haveSeenFox = true;
                directionToFox = i;
                distanceToFox = distance(i);

                // if you see the fox, try to move away out of his sight either diagonal away, decreasing optimums, then random
                if (canMove(Model.turn(directionToFox, 5))) {
                    return Model.turn(directionToFox, 5);
                } else if (canMove(Model.turn(directionToFox, 3))){
                    //System.out.println("Moving randomly");
                    return Model.turn(directionToFox, 3);
                }else if (canMove(Model.turn(directionToFox, 7))) {
                    return Model.turn(directionToFox, 7);
                }else if (canMove(Model.turn(directionToFox, 1))) {
                    return Model.turn(directionToFox, 1);
                }else{
                    return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
                }
            }
        }

        // so what happens when you haven't seen the fox?
        turnSinceFox +=1;

        // look around for edges or bushes
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.BUSH) {
                //Direction to bush = i
                directionToBush = i;
                distanceToBush = distance(i);
            }

            if (look(i) == Model.EDGE) {
                directionToEdge = i;
                distanceToEdge = distance(i);
            }
        }
        return Model.STAY; // I was never seen and we've seen the fox recently
    }
}
