package linked_list;

import util.ListNode;

/*
題目：清單加總
知識點：
1.透過遞迴解雙重鏈結陣列
2.%10 取個位數
3.考量不同 list 讀到 null 的情況
4.考量往下傳是 null 的情況
5.考量終止條件
6.result鏈結串列可以在遞迴中建立，就跟後面再做樹的題目一樣

 */
public class NO_2_5 {
    ListNode addList(ListNode n1, ListNode n2, int carry) {
        if(n1==null && n2==null && carry==0) {
            return null;
        }
        ListNode result = new ListNode(0);
        //int sum = n1.data + n2.data + carry;
        int sum = carry;//先加carry
        if(n1!=null) {
            sum += n1.data;
        }
        if(n2!=null) {
            sum += n2.data;
        }

        carry = sum/10;
        result.data = sum%10;
        //這裡要注意傳入 null 的情況
        result.next =  addList(n1 == null ? null : n1.next,n2 == null ? null :  n2.next, carry);//在遞迴中建立鏈結串列
        return result;
    }

    public static void main(String[] args) {
        ListNode root1 = ListNode.init(new int[]{7,1,6});
        ListNode root2 = ListNode.init(new int[]{5,9,2});
        NO_2_5 no = new NO_2_5();
        ListNode result = no.addList(root1, root2, 0);

        System.out.println(100%10);
    }

}
