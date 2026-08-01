package week6;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStackOptimised {

    public Stack<Long> stack;
    long min;

    public MinStackOptimised(){
        stack= new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int ele) {
        if(stack.isEmpty()){
            min=ele;
            stack.push((long)ele);
        }
        else {
            if(ele< min){
                long encodedValue= (2L *ele)-min;
                min=ele;
                stack.push(encodedValue);
            }
            else {
                stack.push((long)ele);
            }
        }
    }

    public int pop(){
        if (stack.isEmpty()) throw new EmptyStackException();
        long pop = stack.pop(); //0
        long originalValue=0;
        if(pop>min) return (int) pop;  // 0
        // pop could be  original value or an encoded value
        // pop is original when the value is greater than min at the time of insertion
        // pop is encoded value when the value is less than the min, at the time of insertion
        if(pop<min){ // -4 < -3
            originalValue= min;
            min= 2 *min-pop; // -6 +4 //-2
        }
        return (int) originalValue;
    }
    public int top(){
        if (stack.isEmpty()) throw new EmptyStackException();
        long peek = stack.peek();
        if(peek>min) return (int)peek;
        else return (int)min;
    }

    public int getMin(){
        return (int)min;
    }

    public static void main(String[] args) {
        MinStackOptimised minStack = new MinStackOptimised();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
