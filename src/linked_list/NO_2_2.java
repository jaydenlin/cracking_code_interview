package linked_list;

import util.ListNode;

/**
 * 題目：回傳倒數第k個元素到最後一個元素
 * 知識點：
 * 1. 從後面累加回來的方式可以用遞迴做
 * 2. 找出遞迴公式就可以實作了
 * 3. 計算 return 的次數，要呼叫後才開始加
 */
public class NO_2_2 {
    //k(0th) = 0, 特殊情況無意義作為終止條件
    //k(1th) = 1 , 1th 表示倒數最後一個元素, 1表示 k 為 1
    //k(2th) = 2,  2th 表示倒數倒數第2個元素, 2表示 k 為 2
    //k(3th) = 3
    //可知 k(3th) = k(2th) + 1
    //即 k(node) = k(node.next) + 1
    //此為不回傳值的寫法
    int printKthToLast1(ListNode node, int k){
        if(node==null) {
            return 0;
        }
        int j = printKthToLast1(node.next, k) + 1;
        if(j==k) {
            System.out.println(node.data);
        }
        return j;
    }

    ListNode printKthToLast2(ListNode node, int k, Count returnCount){
        if(node==null) {
            return null;
        }
        ListNode n = printKthToLast2(node.next, k, returnCount);//注意不可以寫成 printKthToLast2(node.next, k, returnCount+1); 因為 return 次數要真的 return 後才開始加
        //計算 return 幾次就是從後面數來幾次
        returnCount.count = returnCount.count + 1;
        if(returnCount.count == k) {
            return node;
        }
        return n;
    }

    public static void main(String[] args) {
        NO_2_2 no = new NO_2_2();
        ListNode root = ListNode.init(new int[]{1,2,4,5,6,7,8});

        no.printKthToLast1(root, 3);
        Count returnCount = new Count();
        System.out.println(no.printKthToLast2(root, 3, returnCount).data);;

    }
}
class Count{
    public int count = 0;
}
