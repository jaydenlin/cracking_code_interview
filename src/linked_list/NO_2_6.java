package linked_list;

import util.ListNode;

import java.util.Stack;

/**
 * 題目：找出是否為迴文
 * 知識點：
 * 1. 利用 Runner 技巧，找到鏈結串列的中間點
 * 2. Runner 技巧的 while 迴圈要以 fast runner 為主
 * 3. 透過 fast runner 判斷是單數個鏈結串列還是偶數個
 */
public class NO_2_6 {
    boolean isPalindrome(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        Stack<Integer> stack = new Stack<>();
        while (fast!=null && fast.next!=null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        //若是單數個，快跑者會變成 null
        if(fast == null) {
            slow = slow.next;
        }

        //走剩下的slow runner
        while (slow!=null){
            if(slow.data != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;

    }
}
