package week6;

import java.util.Map;
import java.util.Stack;

public class MinStack {

    class SimpleEntry{
        int val;
        int min;

        public SimpleEntry(int val, int min){
            this.min=min;
            this.val=val;
        }
    }

    Stack<SimpleEntry> stack;
    int min;

    public MinStack(){
        stack= new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int ele) {
        int min = stack.isEmpty() ? ele : Math.min(ele, stack.peek().min);
        stack.push(new SimpleEntry(ele, min));
    }

    public int pop(){
        return stack.pop().val;
    }
    public int top(){
        return stack.peek().val;
    }

    public int getMin(){
        return stack.peek().min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
