package stack_n_queue;

import java.util.Stack;

/**
 * 題目：回傳堆疊的最小值
 * 知識點：
 * 1. 在 node 裡面存 min
 * 2. 或是在另一個堆疊裡面放當下的 min
 */
public class NO_3_2 {


}
//存在 node 裡面的解法
class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value){
        int newMin =  Math.min(value, min());
    }
    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }
}
class NodeWithMin{
    public int value;
    public int min;
    public NodeWithMin( int value, int min){
        this.value = value;
        this.min = min;
    }

}
//用另一個 Stack 紀錄 min 的狀態
class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> minStack;
    public StackWithMin2(){
        minStack = new Stack<>();
    }

    public void push(int value){
        super.push(value);
        if(value < min()){
            minStack.push(value);
        }
    }
    public Integer pop(){
        int value = super.pop();
        if(value ==min()){
            minStack.pop();
        }
        return value;
    }
    public int min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
