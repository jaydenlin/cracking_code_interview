package linked_list;

import util.ListNode;

/*
題目：將鏈結串列根據 x 分大小兩邊
知識點：
將 node 插入頭尾的技巧
 */
public class NO_2_4 {
    ListNode partrition(ListNode n, int x) {

        ListNode head = n;
        ListNode tail = n;

        while(n!=null){
            ListNode next = n.next;
            if(n.data < x) {

                //放在頭
                n.next = head;//接到頭
                head = n;//更新 head
            } else {
                //放在尾
                tail.next = n;//接到尾
                tail = n;//更新 head
            }
            n = next;
        }
        //清空 tail.next
        tail.next = null;
        return head;
    }




    public static void main(String[] args) {
        NO_2_4 no = new NO_2_4();
        ListNode root = ListNode.init(new int[]{8,7,6,5,2,3,1});
        ListNode newRoot = no.partrition(root, 5);

        System.out.println("ok");
    }
}
