package util;

public class ListNode {
    public ListNode next;
    public int data;
    public ListNode(int data){
        this.data = data;
    }

    public static ListNode init (int[] nodes){
        ListNode root = null;
        ListNode cur = null;
        for(int nodeValue: nodes){
            if(root==null) {
                root = new ListNode(nodeValue);
                cur = root;
            } else {
                cur.next = new ListNode(nodeValue);
                cur = cur.next;
            }

        }
        return root;
    }
}
