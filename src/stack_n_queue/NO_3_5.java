package stack_n_queue;

import java.util.Stack;

/**
 * 題目：排序堆疊
 * 知識點：
 * 1. 同一個 stack 一直取，並且一直被放入
 * 2. 另一個 stack 遍歷裡面的東西，跟取出來的值比較
 * 複雜度：
 * n 平方
 */
public class NO_3_5 {
    public void sort(Stack<Integer> s){
        Stack<Integer> sortedStack = new Stack<>();
        //掃 未排序的stack 放進 已排序的stack
        while (!s.isEmpty()) {
            int tmp = s.pop();
            //掃 已排序的stack 放進 未排序的stack
            //如果 已排序的stack 裡面的第一個比 tmp 大，就拿出來
            while (!sortedStack.isEmpty() && sortedStack.peek() > tmp){
                s.push(sortedStack.pop());
            }

            sortedStack.push(tmp);
        }
        //將排序後的 stack 放入
        while(!sortedStack.isEmpty()){
            s.push(sortedStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(5);
        s.push(8);
        s.push(3);
        s.push(2);

        NO_3_5 no = new NO_3_5();
        no.sort(s);
        System.out.println(s.pop());//1
        System.out.println(s.pop());//2
        System.out.println(s.pop());//3
        System.out.println(s.pop());//5
        System.out.println(s.pop());//8
    }
}
