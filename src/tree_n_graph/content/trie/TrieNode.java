package tree_n_graph.content.trie;

import java.util.HashMap;

public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf = false;
    public TrieNode(char c){
        this.c = c;
    }
    public TrieNode(){

    }
}
