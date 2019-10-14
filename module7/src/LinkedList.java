public class LinkedList<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node<String> n1 = new Node<>("Bread");
        Node<String> n2 = new Node<>("Milk");
        Node<String> n3 = new Node<>("Eggs");
        Node<String> n4 = new Node<>("Beer");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node<String> current = n1;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
