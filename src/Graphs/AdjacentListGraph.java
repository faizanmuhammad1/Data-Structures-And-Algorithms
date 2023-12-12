import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacentListGraph{
    private class Node{
        private final String label;
        Node(String label){
            this.label=label;
        }

        @Override
        public String toString() {
            return STR."Node{label='\{label}\{'\''}\{'}'}";
        }
    }
    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacencyList = new HashMap<Node,List<Node>>();

    public void addNode(String label){
        Node newNode = new Node(label);
        nodes.putIfAbsent(label,newNode);
        adjacencyList.putIfAbsent(newNode,new ArrayList<>());
    }
    public void addEdge(String from,String to){
        Node fromNode = nodes.get(from);
        if(fromNode==null){
            throw new IllegalArgumentException();
        }
        Node toNode = nodes.get(to);
        if(toNode==null){
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

}

