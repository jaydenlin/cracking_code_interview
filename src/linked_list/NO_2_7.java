package linked_list;

import util.ListNode;

/**
 * 題目：判斷兩個鏈結串列有沒有交集
 * 知識點：
 * 1.尾巴不同表示沒有交集
 * 2.將兩個鏈結串列調成一樣長才可以遍歷
 * 3.同時遍歷兩個鏈結串列的技巧
 */
public class NO_2_7 {
    ListNode findIntersection(ListNode node1, ListNode node2){
        if(node1==null || node2==null) return null;

        Result r1 = getLastAndSize(node1);
        Result r2 = getLastAndSize(node2);

        //如果尾巴不同表示沒有交集
        if(r1.tail != r2.tail) {
            return null;
        }

        ListNode longer = r1.size > r2.size ? node1: node2;
        ListNode shorter = r1.size > r2.size ? node2: node1;
        //將兩個鏈結串列調成一樣長才可以遍歷
        int offset = Math.abs(r1.size - r2.size);
        longer = getKthNode(longer, offset);

        //同時遍歷兩個鏈結串列的技巧
        while (shorter!=longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        //回傳其中一個
        return longer;

    }
    ListNode getKthNode(ListNode node, int k){
        ListNode cur = node;
        int count = k;
        while (cur!=null && count!=0){
            cur = cur.next;
            count--;
        }
        return cur;
    }
    Result getLastAndSize(ListNode node){
        Result result = new Result();
        ListNode cur = node;
        int size = 0;

        while (cur!=null){

            cur = cur.next;
            result.tail = cur;
            size++;
        }

        result.size = size;
        return result;
    }
}

class Result {
    ListNode tail;
    int size;
}
