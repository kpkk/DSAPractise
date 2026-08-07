package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

public class LongestValidParenthesis {

    @Test
    public void test(){
        String s="(()";
        Assertions.assertEquals(2, longestValidParenthesis(s));
    }

    @Test
    public void test1(){
        String s=")()())";
        Assertions.assertEquals(4, longestValidParenthesis(s));
    }

    public int maxLenValidString(String s){
        Stack<Integer> stack = new Stack<>();
        int maxLen=Integer.MIN_VALUE;
        stack.push(-1);
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    maxLen=Math.max(maxLen, i-stack.peek());

            }
        }
        return maxLen;
    }

    public int longestValidParenthesis(String s){
        int open=0, closed=0, maxLen=0;
        int right=0;
        while (right<s.length()){
            if(s.charAt(right)=='(')
                open++;
            else closed++;
            if(open==closed) maxLen=Math.max(maxLen, 2*open);
            else if(open<closed){
                open=0;
                closed=0;
            }
            right++;
        }
        open=0; closed=0; right=s.length()-1;
        while (right>=0){
            if(s.charAt(right)=='(')
                open++;
            else closed++;
            if(open==closed) maxLen=Math.max(maxLen,2*open);
            else if(open>closed) {
                open=0;
                closed=0;
            }
            right--;
        }
        return maxLen;
    }
}
