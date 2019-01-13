package linked_list;

import util.ListNode;

/**
 * 題目：找到環狀起點
 * 知識點：
 * 1.利用 Runner 的技巧跑
 * 2.Runner 跑時以 fast 的 while 全為主
 * 3.假設slow 走 k 部到環狀起點，那麼走到起點時，fast已經走了 2k ，並且已在環內走了 k 布
 * 由於是環，所以此時 fast 距離 slow 為 mod(k, 環長度) = K ，因此再經過(環長度-K)步，就會發生碰撞
 * 此時碰撞點在環原點前 K 步
 * 4.此時把 slow 重新放回 head，slow 跟 fast 改以同速度前進，走了 k 步之後會剛好在環狀起點相遇
 * 因為 fast 走了 k 步，k = K + 圈數 * 環長度，等於繞了幾圈後走了 K
 */
public class NO_2_8 {
    ListNode findCycleBegining(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        //檢查如果沒有相遇
        if(fast == null || fast.next==null){
            return null;
        }

        //重新 set slow 到 head
        slow = head;
        //注意！這裡走的速率要一樣
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
