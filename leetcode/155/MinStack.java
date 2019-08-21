package no155;

import java.util.LinkedList;

public class MinStack {
    /** 
     * 辅助栈两种思路
     *      1.同步增减元素，栈顶添加当前最小值
     *      2.不同步，栈顶只在新最小值时入栈，只在最小值出栈时做出栈操作
     *
     */
    LinkedList<Integer> arr = new LinkedList<Integer>();
    LinkedList<Integer> min = new LinkedList<Integer>();
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        arr.addFirst(x);
        if(min.isEmpty()||x<=min.getFirst()) {min.addFirst(x);}
    }
    
    public void pop() {
        int n = arr.removeFirst();
        if(n==min.getFirst()) {min.removeFirst();}
    }
    
    public int top() {
        return arr.getFirst();
    }
    
    public int getMin() {
        return min.getFirst();
    }
}
