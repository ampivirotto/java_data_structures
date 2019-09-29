public class Room {
    private int numberInRoom;
    private static int totalNumber;

    public Room() {
        this.numberInRoom = 0;
    }

    public Room(int numberInRoom) {
        this.numberInRoom = numberInRoom;
        totalNumber += numberInRoom;
    }

    public void addOneToRoom() {
        this.numberInRoom += 1;
        totalNumber += 1;
    }

    public void removeOneFromRoom(){
        if (this.numberInRoom > 0){
            this.numberInRoom -= 1;
            totalNumber -= 1;
        }else{
            System.out.println("Room is empty.");
        }
    }

    public int getNumber(){
        return numberInRoom;
    }

    public int getTotal(){
        return totalNumber;
    }

}
