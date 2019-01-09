package linked_list;

import util.ListNode;
import java.util.HashSet;
/*
題目：刪除出現過的值
知識點：
1.利用 HashSet 紀錄出現過的值
2.利用 While 迴圈遍歷 LinkedList
3.注意 root 傳入後要用 cur 遍歷
4.要刪除的話 記得要記 previous 項 畫圖即知
 */
public class NO_2_1 {

    static void printList(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    //利用 HashSet 來記錄出現過的值
    void deleteDup1(ListNode root){
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = root;
        ListNode previous = null;
        while (cur != null) {
            if(set.contains(cur.data)){
                previous.next = cur.next;
            } else {
                set.add(cur.data);
                previous = cur;
            }
            cur = cur.next;
        }

    }
    // 雙層迴圈
    // 該項跟該項之後的每一項比較是否相同
    void deleteDup2(ListNode root){
        ListNode cur = root;
        while (cur!=null){
            ListNode runner = cur;
            while (runner.next != null) {
                if(runner.next.data == cur.data) {
                    runner.next = runner.next.next;
                }else{
                    runner =  runner.next;
                }
            }
            cur =cur.next;
        }
    }

    public static void main(String[] args) {
        NO_2_1 no = new NO_2_1();
        ListNode root = ListNode.init(new int[]{1,2,3,3,2,1,4});
        no.deleteDup1(root);
        printList(root);

    }

}
