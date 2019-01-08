package util;

public class Tree {
    public static TreeNode buildBinary(int[] nodes, int index){

        if(index >= nodes.length || nodes[index]==-1) {
            return null;
        }
        TreeNode treeNode =  new TreeNode();

        treeNode.value = nodes[index];
        treeNode.left = buildBinary(nodes, 2*index+1);
        treeNode.right = buildBinary(nodes, 2*index+2);

        return treeNode;
    }

    public static void main(String[] args) {

        TreeNode root = buildBinary(new int[]{1,2,3,4,5,6,7,8}, 0);

        System.out.println("ok");

    }


}
