package week6;

import java.util.Stack;

interface stackINF{

    public void push(int val);
    public int pop();
    public int peek();
    public int getSize();
    public boolean isEmpty();

}

public class StackImpl implements stackINF {


    //Design stack using an array
    int[] arr;
    int size;
    int top; // pointer to access elements at top of the stack

    public StackImpl(int size){
        this.size=size;
        this.top=-1;
        this.arr=new int[size];
    }

    // insert element at top of the stack
    public void push(int val){
        if(top>size-1){
            System.out.println("Stack is full, no insertion possible");
            return;
        }
        arr[++top]=val;
    }

    // returns the element at the top of the stack and remove it
    public int pop(){
        if(top<0){
            System.out.println("stack is empty so returning the default value");
            return Integer.MIN_VALUE; // a default garbage value
        }
        int pop= arr[top];
        arr[top]=0;
        top--;
        return pop;
    }

    //returns the element at the top of the stack don't remove the element
    public int peek(){
        if(top<0){
            System.out.println("stack is empty so returning the default value");
            return Integer.MIN_VALUE; // a default garbage value
        }
        return arr[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int getSize(){
        return top+1;
    }


    public static void main(String[] args) {

        stackINF stack = new StackImpl(10);
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(34);
        stack.push(1); // latest top after the pop
        stack.push(2); // this was popped
        System.out.println(stack.getSize());
        stack.pop();
        System.out.println(stack.peek());
    }


}