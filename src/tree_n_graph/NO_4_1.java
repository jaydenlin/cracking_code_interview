package tree_n_graph;

import util.Graph;
import util.GraphNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 題目：判斷兩個點是否有路徑連到
 * 知識點：
 * 1. 使用廣度優先解
 * 2. 熟悉 Graph 的使用
 * 3. 用 GrpahNode 串結關係之後，把所有點加到 Graph 裡面
 */
public class NO_4_1 {
    Graph initGraph(){
        /**
         *   8 ==> 2
         *     ==> 3
         *
         *   1 ==> 2 ==> 5
         *     ==> 3 ==> 6 ==> 1
         *     ==> 4 ==> 7
         */
        GraphNode node1 = new GraphNode("1");
        GraphNode node2 = new GraphNode("2");
        GraphNode node3 = new GraphNode("3");
        GraphNode node4 = new GraphNode("4");
        GraphNode node5 = new GraphNode("5");
        GraphNode node6 = new GraphNode("6");
        GraphNode node7 = new GraphNode("7");
        GraphNode node8 = new GraphNode("8");

        node1.addAdjacents(node2);
        node1.addAdjacents(node3);
        node1.addAdjacents(node4);

        node3.addAdjacents(node6);
        node4.addAdjacents(node7);

        node6.addAdjacents(node1);
        node8.addAdjacents(node2);
        node8.addAdjacents(node3);

        node2.addAdjacents(node5);

        Graph graph = new Graph();
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);
        graph.addNode(node8);

        return graph;

    }

    boolean solution(Graph graph, GraphNode start, GraphNode end){

        if(start == end) return true;

        LinkedList<GraphNode> queue = new LinkedList<>();
        List<GraphNode> nodes = graph.getNodes();

        for(GraphNode node: nodes){
            node.state = GraphNode.State.Unvisited;
        }
        // 廣度優先起手式：先放一個在 Queue
        start.state = GraphNode.State.Visting;
        queue.add(start);

        GraphNode cur;
        while (!queue.isEmpty()) {
            //移一個出來看廣度
            cur = queue.removeFirst();
            if(cur != null) {
                //檢查這個點所有相鄰的點
                for(GraphNode v: cur.getAdjacents()) {
                    if(v.state == GraphNode.State.Unvisited) {
                        if(v == end) {
                            return true;
                        } else {
                            v.state = GraphNode.State.Visting;
                            //放回 Queue
                            queue.add(v);
                        }
                    }
                }
            }
            cur.state =  GraphNode.State.Visited;
        }

        return false;

    }

    public static void main(String[] args) {
        NO_4_1 no = new NO_4_1();
        Graph graph = no.initGraph();

        System.out.println(no.solution(graph, graph.getNodes().get(0), graph.getNodes().get(4)));//true
        System.out.println(no.solution(graph, graph.getNodes().get(0), graph.getNodes().get(7)));//false
    }

}
