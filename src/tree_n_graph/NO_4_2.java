package tree_n_graph;

import util.TreeNode;

/**
 * 題目：最小平衡樹
 * 知識點：
 * 1. 用二分法不斷拆分陣列來建構樹
 * 2. 注意剩下最後兩個的情況
 * 3. 注意終止條件 end < start
 * 4. 使用多型函式建立遞迴條件
 */
public class NO_4_2 {
    TreeNode createMinimalBST(int[] array){

        return createMinimalBST(array, 0, array.length -1);

    }

    TreeNode createMinimalBST(int[] array, int start, int end){
        //注意終止條件
        if(end < start) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode();
        node.value = array[mid];
        node.left = createMinimalBST(array, start, mid -1);
        node.right = createMinimalBST(array, mid + 1, end);
        return node;
    }

}
