package stack_n_queue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 題目：多個 Stacks
 * 知識點：
 * 1. 建立一個有限制長度的新 Stack 類別來用
 * 2. 注意新增 Stack 跟 刪除 Stack 的時機
 */
public class NO_3_3 {

}

class SetOfStacks {
    ArrayList<LimitedStack> stacks = new ArrayList<>();

    public void push(int value){
        LimitedStack last = getLastStack();
        if(last!=null && !last.isFull()){
            last.push(value);
        } else {
            LimitedStack newStack = new LimitedStack(10);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public Integer pop() throws Exception {
        LimitedStack last = getLastStack();
        if(last==null) {throw new Exception();}
        Integer value = last.pop();
        //如果移完了，就要把 stask 刪除
        if(last.size() == 0) {
            stacks.remove(stacks.size() -1);
        }

        return value;
    }

    LimitedStack getLastStack(){
        if(stacks.size()==0) {
            return null;
        } else {
            return stacks.get(stacks.size()-1);
        }
    }

}

class LimitedStack extends Stack<Integer>{
    int capacity;
    int size=0;
    LimitedStack(int capacity) {
        this.capacity = capacity;
    }
    public Integer pop(){
        if(size - 1 >= 0){
            size --;
            return super.pop();
        } else {
            return null;
        }
    }
    public void push(int value){
        if(size < capacity){
            size ++;
            super.push(value);
        }
    }
    public boolean isFull(){
        return size >= capacity;
    }
}
