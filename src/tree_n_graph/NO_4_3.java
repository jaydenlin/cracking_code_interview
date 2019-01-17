package tree_n_graph;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 題目：對二元樹建立每個深度的鏈結清單
 * 知識點：
 * 1. 用深度遍歷來遍歷每個點
 * 2. 用一多個 list 來收集每一層的點
 * 3. 注意 level 跟 lists.size 的關係
 */
public class NO_4_3 {
    void createLevelLinkedList(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(node == null) {
            return;
        }

        LinkedList<TreeNode> list =null;
        if(lists.size() == level) {//若是 size = 5 代表已經有 0,1,2,3,4 層，level 5 還沒到
            list = new LinkedList<TreeNode>();// 若 lists.size() == level 代表 level 層還沒到，要建一個新的
            lists.add(list);
        } else {

            list = lists.get(level);
        }
        list.add(node);

        createLevelLinkedList(node.left, lists, level +1);
        createLevelLinkedList(node.right, lists, level +1);
    }
}
