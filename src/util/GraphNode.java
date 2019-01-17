package util;

import java.util.ArrayList;
import java.util.List;


public class GraphNode {
    public enum State { Unvisited, Visited, Visting}
    List<GraphNode> adjacents = new ArrayList<GraphNode>();
    public String data;
    public State state;

    public GraphNode(String data){
        this.data = data;
    }

    public void addAdjacents(GraphNode node){
        adjacents.add(node);
    }

    public List<GraphNode> getAdjacents(){
        return adjacents;
    }
}
