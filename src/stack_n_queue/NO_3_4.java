package stack_n_queue;

import java.util.Stack;

/**
 * 題目：用兩個 Stacks 實作 Queue
 * 知識點：
 * 1. 用另一個 Stack 翻轉順序
 * 2. 當 oldest Stack 空了之後，再把 newest Stack 的資料倒進去
 */
public class NO_3_4 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.peek());//1
        System.out.println(queue.remove());//1
        System.out.println(queue.remove());//2
        System.out.println(queue.peek());//3
    }
}

class MyQueue<T>  {
    Stack<T> oldest = new Stack<>();
    Stack<T> newest =  new Stack<>();

    public int size(){
        return oldest.size() + newest.size();
    }
    public void add(T value) {
        newest.push(value);
    }

    public T peek() {
        shiftStack();
        return oldest.peek();
    }
    public T remove() {
        shiftStack();
        return oldest.pop();
    }

    void shiftStack(){
        if(oldest.isEmpty()) {
            while (!newest.isEmpty()){
                oldest.push(newest.pop());
            }
        }
    }
}
