import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.*;
import java.util.*;

public class graphTest {
    public static <V ,E> List<V> bfs (Graph <V,E> g, V start ){
        // make empty list to add the nodes you visit
        List<V> visited = new ArrayList<>();

        // make a queue to add the nodes to as needed
        Queue<V> q = new LinkedList<V>();
        q.add(start);

        // while there's still something in the queue
        while(q.peek() != null){
            //pull the item in the front of the queue
            V frontNode = q.poll();

            // see if the node from front of queue has been visited yet
            if (!visited.contains(frontNode)){
                //then add to visited list
                visited.add(frontNode);

                //add its adjacent nodes ot queue in numerical order
                for(V item : g.getNeighbors(frontNode)) {
                    q.add(item);
                }
            }
        }
        return visited;
    }

    public static <V,E> List<V> dfs (Graph <V,E> g, V start ){
        // make empty list to add the nodes you visit
        List<V> visited = new ArrayList<>();

        // make a queue to add the nodes to as needed
        Stack<V> st = new Stack<V>();
        st.push(start);

        // while the stack isn't empty
        while(!st.empty()){
            // figure out what node is on top
            V topNode = st.pop();

            //check to see if that node has been visited
            if(!visited.contains(topNode)){
                //if not, add it to visited list
                visited.add(topNode);

                //add its adjacent neighbors to the stack
                for(V item : g.getNeighbors(topNode)) {
                    st.push(item);
                }
            }
        }
        //return list of visited items
        return visited;
    }


    public static void main(String[] args) {

        // create graph
        SparseGraph<String, Integer> g = new SparseGraph<>();

        g.addEdge(1, "A", "B");
        g.addEdge(2, "A", "C");
        g.addEdge(3, "B", "E");
        g.addEdge(4, "B", "D");
        g.addEdge(5, "C", "F");
        g.addEdge(6, "E", "F");

        List bfslist = bfs(g, "A");
        System.out.println(bfslist);

        List dfslist = dfs(g, "A");
        System.out.println(dfslist);

    }



}
