package tree_n_graph.content.trie;

import java.util.HashMap;

public class Trie {
    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    public void insert(String word){
        HashMap<Character, TrieNode> children =  root.children;
        for(int i=0;i<word.length();i++){
            char w = word.charAt(i);
            TrieNode next;
            if(children.containsKey(w)){
                next = children.get(w);//往下一個 node
            } else {
                next =  new TrieNode(w);
                children.put(w, next);//在該層 children 多建一個 node
            }
            //更新下一層要找的 children
            children = next.children;

            //如果到最後一個字元
            //idLeaf 為 true 預設 TrieNode 的 isLeaf 是 false
            if(i == word.length() -1) {
                next.isLeaf = true;
            }
        }
    }
    public boolean startWith(String word){
        TrieNode t = this.searchNode(word);
        if(t!=null){ //startWith 不用判斷是不是 leaf
            return true;
        }
        return false;
    }
    public boolean search(String word){
        TrieNode t = this.searchNode(word);
        if(t!=null && t.isLeaf){//search 要判斷是不是 leaf
            return true;
        }
        return false;
    }

    private TrieNode searchNode(String word){
        HashMap<Character, TrieNode> children =  root.children;
        TrieNode next = null;
        for(int i =0 ; i < word.length(); i++){
            char w = word.charAt(i);

            if(children.containsKey(w)){
                next = children.get(w);
                children = next.children;
            } else {
                return null;
            }

        }
        return next;
    }
}
