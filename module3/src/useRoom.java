public class useRoom {
    public static void main(String[] args) {
        Room small = new Room(2);
        Room empty = new Room();
        Room large = new Room(7);

        small.addOneToRoom();
        empty.removeOneFromRoom();
        large.removeOneFromRoom();

        System.out.println(small.getNumber());
        System.out.println(small.getTotal());
        System.out.println(empty.getNumber());
        System.out.println(empty.getTotal());
        System.out.println(large.getTotal());
        System.out.println(large.getNumber());

    }
}
