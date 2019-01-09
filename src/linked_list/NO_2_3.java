package linked_list;

import util.ListNode;
/*
題目：刪除某個節點
知識點：
由於沒有給節點的頭，就是複製下一個節點，直接連過去即可
 */
public class NO_2_3 {
    boolean deleteNode(ListNode n){
        if(n==null || n.next==null) {
            return false;
        }
        ListNode nextCopy = n.next;
        n.data = nextCopy.data;
        n.next = nextCopy.next;

        return true;
    }
}
