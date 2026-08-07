package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class MakeTheStringGreat {

    @Test
    public void test(){
        String s="leEeetcode";
        Assertions.assertEquals("leetcode", makeGood(s));
    }

    @Test
    public void test1(){
        String s="abBAcC";
        Assertions.assertEquals("", makeGood(s));
    }

    public String makeGood(String s){
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (!stack.isEmpty() && (Character.isUpperCase(ch) && stack.peek() == Character.toLowerCase(ch)
                    || Character.isLowerCase(ch) && stack.peek() == Character.toUpperCase(ch))) {
                stack.pop();
            }
            else
                stack.push(ch);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.insert(0,stack.pop());
        }
        return builder.toString();
    }
}
